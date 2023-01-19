package dam.ad.uf2.db4o.persistencia;

import java.util.ArrayList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import dam.ad.uf2.db4o.data.Lenguaje;




public class AccesoLenguajesDB4O {
	static final String PATH_DB = "DB4O/Lenguajes.yap"; 
	ObjectContainer db;
	
	public AccesoLenguajesDB4O() {
		 db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), PATH_DB);

	}
	
	public void cerraDB() {
		db.close();
	}

	
	public Lenguaje insertar(Lenguaje lenguaje) {
		db.store(lenguaje);
		
		return lenguaje;
		
	}

	public ArrayList<Lenguaje> consultarTodos() {
		ArrayList<Lenguaje> listaLenguajes = new ArrayList<Lenguaje>();
		 
		 ObjectSet<Lenguaje> setLenguajes = db.queryByExample(Lenguaje.class); //
		 
		 listaLenguajes.addAll(setLenguajes);
		 
		 return listaLenguajes;
	}

	public ArrayList<Lenguaje> lenguajesDespuesDe1990() {
		ArrayList<Lenguaje> listaLenguajes = new ArrayList<Lenguaje>(); 
		ObjectSet<Lenguaje> setLenguajes = db.queryByExample(Lenguaje.class);
		
		for (Lenguaje listaLenguajeMayor1990 : setLenguajes) {
			if (listaLenguajeMayor1990.getAnioPublicacion() > 1990) {
				listaLenguajes.add(listaLenguajeMayor1990);
				
			}
		}
		
		return listaLenguajes;
	}

	public ArrayList<Lenguaje> modificarVarios(String nombre, int puesto, double porcentaje, String diferencia) {
		ArrayList<Lenguaje> listaLenguajes = new ArrayList<Lenguaje>(); 
		ObjectSet<Lenguaje> setLenguajes = db.queryByExample(Lenguaje.class);
		
		for (Lenguaje listaLenguajesAntigua : setLenguajes) {
			if (listaLenguajesAntigua.getNombre().equalsIgnoreCase(nombre)) {
				listaLenguajes.add(listaLenguajesAntigua);
			}
		}
		
		if (!listaLenguajes.isEmpty()) {
			Lenguaje lenguajeModif = new Lenguaje();
			lenguajeModif.setNombre(nombre);
			//pilotoModif.setEscuderia(escuderia);
			setLenguajes = db.queryByExample(lenguajeModif);
			
			while (setLenguajes.hasNext()) {  
				lenguajeModif = setLenguajes.next();
				lenguajeModif.setPuestoRanking(puesto);
				lenguajeModif.setPorcentajeUso(porcentaje);
				lenguajeModif.setDiferencia(diferencia);
				
				db.store(lenguajeModif);
				
			}
		}
		
		
		return listaLenguajes;
	}

	public ArrayList<Lenguaje> consultarLenguajes(String nombre) {
		
		Lenguaje lenguajeNombre = new Lenguaje();
		lenguajeNombre.setNombre(nombre);
		ObjectSet<Lenguaje> setLenguajes = db.queryByExample(lenguajeNombre);
		
		
		return new ArrayList<Lenguaje>(setLenguajes);
	}

}
