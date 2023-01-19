package dam.ad.uf2.db4o.data;

public class Lenguaje {
	
	public static final String ATR_NOMBRE = "nombre";
	public static final String ATR_CREADOR = "creador";
	public static final String ATR_ANIOPUBLICACION = "anioPublicacion";
	public static final String ATR_PUESTORANKING = "puestoRanking";
	public static final String ATR_PORCENTAJEUSO = "porcentajeUso";
	public static final String ATR_DIFERENCIA = "diferencia";
	
	private String nombre;
	private Creador creador;
	private int anioPublicacion;
	private int puestoRanking;
	private double porcentajeUso;
	private String diferencia;
	
	public Lenguaje(String nombre, Creador creador, int anioPublicacion, int puestoRanking, double porcentajeUso,
			String diferencia) {
		this.nombre = nombre;
		this.creador = creador;
		this.anioPublicacion = anioPublicacion;
		this.puestoRanking = puestoRanking;
		this.porcentajeUso = porcentajeUso;
		this.diferencia = diferencia;
	}

	public Lenguaje() {
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Creador getCreador() {
		return creador;
	}

	public void setCreador(Creador creador) {
		this.creador = creador;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public int getPuestoRanking() {
		return puestoRanking;
	}

	public void setPuestoRanking(int puestoRanking) {
		this.puestoRanking = puestoRanking;
	}

	public double getPorcentajeUso() {
		return porcentajeUso;
	}

	public void setPorcentajeUso(double porcentajeUso) {
		this.porcentajeUso = porcentajeUso;
	}

	public String getDiferencia() {
		return diferencia;
	}

	public void setDiferencia(String diferencia) {
		this.diferencia = diferencia;
	}

	public static String getAtrNombre() {
		return ATR_NOMBRE;
	}

	public static String getAtrCreador() {
		return ATR_CREADOR;
	}

	public static String getAtrAniopublicacion() {
		return ATR_ANIOPUBLICACION;
	}

	public static String getAtrPuestoranking() {
		return ATR_PUESTORANKING;
	}

	public static String getAtrPorcentajeuso() {
		return ATR_PORCENTAJEUSO;
	}

	public static String getAtrDiferencia() {
		return ATR_DIFERENCIA;
	}

	@Override
	public String toString() {
		return "Lenguaje [nombre=" + nombre + ", creador=" + creador + ", anioPublicacion=" + anioPublicacion
				+ ", puestoRanking=" + puestoRanking + ", porcentajeUso=" + porcentajeUso + ", diferencia=" + diferencia
				+ "]";
	}
	
	
	
	
	
	
}
