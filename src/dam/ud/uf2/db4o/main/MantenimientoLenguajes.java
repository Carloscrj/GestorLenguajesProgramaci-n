package dam.ud.uf2.db4o.main;

import java.util.ArrayList;
import java.util.Scanner;

import dam.ad.uf2.db4o.data.Creador;
import dam.ad.uf2.db4o.data.Lenguaje;
import dam.ad.uf2.db4o.persistencia.AccesoLenguajesDB4O;


public class MantenimientoLenguajes {
	
	static AccesoLenguajesDB4O accesoDB;
	static Scanner sc;

	public static void main(String[] args) {
		
		accesoDB = new AccesoLenguajesDB4O();
		
	
		sc = new Scanner(System.in);
		
		opcionElegida();
		
		sc.close();
		
		accesoDB.cerraDB();
	}

	private static void opcionElegida() {
		boolean continuar=true;
		int opcion;
		
		while (continuar) {
			
			opcion=darOpciones();
			
			if(opcion==1) {
				insertarLenguajes();
			}else if(opcion==2) {
				consultarTodosLosLenguajes();
			}else if (opcion==3) {
				modificarPosicionPorcentajeDiferencia();
			}else if (opcion==4) {
				consultarLenguajesPublicadosDespues1990();
			}else{
				System.out.println("Fin del proceso.");
				continuar=false;;
			
			}
		}
	}

	private static void modificarPosicionPorcentajeDiferencia() {
		String nombre= validarString("Introduzca el nombre del lenguaje");
		int puesto= validarInt("Introduzca la nueva posicion");
		double porcentaje= validarDouble("Introduzca el nuevo porcentaje");
		String diferencia= validarString("Introduzca la nueva diferencia");
		
		ArrayList<Lenguaje> listaLenguajes = accesoDB.modificarVarios(nombre, puesto, porcentaje, diferencia);
		
		if (listaLenguajes.isEmpty()) {
			System.out.println("No se han encontrado datos con ese lenguaje.");
		} else {
			System.out.println("Lenguaje modificado.");
		}
		
	}

	private static double validarDouble(String msg) {
		boolean intNoValido = true;
		double dato = 0;
		
		while(intNoValido) {
			System.out.println(msg);
			dato = Double.parseDouble(sc.nextLine());
				if(dato<0){
					System.out.println("Opción no valida.Porcentaje menor que 0.");
				} else {
					intNoValido =  false;
				}
				
		}
		return dato;
	}

	private static int validarInt(String msg) {
		boolean intNoValido = true;
		int dato = 0;
		
		while(intNoValido) {
			System.out.println(msg);
			dato = Integer.parseInt(sc.nextLine());
				if(dato<1){
					System.out.println("Opción no valida.Posición menor que 1.");
				} else {
					intNoValido =  false;
				}
				
		}
		return dato;
	}

	private static String validarString(String msg) {
		boolean stringNoValido = true;
		String dato = null;
		
		while(stringNoValido) {
			System.out.println(msg);
			dato = sc.nextLine();
				if(dato.isBlank()){
					System.out.println("Opción no valida campo en blanco.");
				} else {
					stringNoValido =  false;
				}
				
		}
		return dato;
	}

	private static void consultarLenguajesPublicadosDespues1990() {
		ArrayList<Lenguaje> listaLenguajes = accesoDB.lenguajesDespuesDe1990();
		
		if (listaLenguajes.isEmpty()) {
			System.out.println("No se han encontrado lenguajes publicado después de 1990.");
		}else {
			System.out.println("Se han encontrado "+listaLenguajes.size()+ " lenguajes publicados después de 1990.");
			for (Lenguaje lenguaje : listaLenguajes) {
				System.out.println(lenguaje);
			}
		}
		
	}

	private static void consultarTodosLosLenguajes() {
		ArrayList<Lenguaje> listaLenguajes = accesoDB.consultarTodos();
		if (listaLenguajes.isEmpty()) {
			System.out.println("\nNo se han encontrado lenguajes.");
		}else {
			System.out.println("\nSe han encontrado "+listaLenguajes.size()+ " lenguajes.");
			for (Lenguaje lenguaje : listaLenguajes) {
				System.out.println(lenguaje);
			}
		}
		
	}

	private static void insertarLenguajes() {
		Lenguaje lenguajes[] = {new Lenguaje("Python", new Creador("Guido Van Rossum", "Países Bajos"), 1991, 1, 17.18, "+5.41"),
				new Lenguaje("C", new Creador("Dennis Ritchie", "Estados Unidos"), 1978, 2, 15.08,"+4.35"),
				new Lenguaje("Java", new Creador("James Gosling", "Canadá"), 1995, 3, 11.98, "+1.26"),
				new Lenguaje("C++", new Creador("Bjarne Stroustrup", "Estados Unidos"), 1983, 4, 10.75,"+2.46"),
				new Lenguaje("C#", new Creador("Anders Hejlsberg", "Dinamarca"), 2000, 5, 4.25,"-1.8"),
				new Lenguaje("Visual Basic", new Creador("Alan Cooper", "Estados Unidos"), 1991, 6, 4.11,"-1.61"),
				new Lenguaje("JavaScript", new Creador("Brendan Eich", "Estados Unidos"), 1995, 7, 2.74,"+0.08"),
				new Lenguaje("Java", new Creador("James Gosling", "Canadá"), 1995, 3, 11.98, "+1.26")};
		
	
		ArrayList<Lenguaje> listaLenguaje = new ArrayList<Lenguaje>(); 
		
		for (Lenguaje lenguaje : lenguajes) {
			listaLenguaje = accesoDB.consultarLenguajes(lenguaje.getNombre());
			
			if (listaLenguaje.isEmpty()) {
				accesoDB.insertar(lenguaje);
			}
			
		}
			
			
	}
		
		
	private static int darOpciones() {
		String mensaje=("Que acción desea realizar"+"\n Pulse 0 para terminar el proceso."+
				"\n Pulse 1 para insertar los lenguajes."+"\n Pulse 2 para consultar todos los lenguajes."
				+"\n Pulse 3 para modificar, posicion porcentaje de uso y la diferencia."
				+"\n Pulse 4 para consultar lenguajes publicados después de 1990.");
		
		int opcion= controlOpciones(mensaje,0,4);

		return opcion;
	}

	private static int controlOpciones(String mensaje, int min, int max) {
		boolean valorNoval = true;
		int opcion=0;
		
		while(valorNoval) {
			try {
				System.out.println(mensaje);
				opcion= Integer.parseInt(sc.nextLine());
				
				if(opcion>=min && opcion<=max) {
					valorNoval = false;
				} else {
					System.out.println("El número tiene que estar entre"+min+" y "+max+".");
				}
				}catch (NumberFormatException e) { 
				 System.out.println("El valor introducido debe ser un número y no una letra");
				}
		
		}
		return opcion;
	}

}
