package dam.ad.uf2.db4o.data;

public class Creador {
	private String nombre;
	private String nacionalidad;
	
	public Creador(String nombre, String nacionalidad) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}
	
	public Creador() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return "Creador [nombre=" + nombre + ", nacionalidad=" + nacionalidad + "]";
	}
	
	
	
	
}
