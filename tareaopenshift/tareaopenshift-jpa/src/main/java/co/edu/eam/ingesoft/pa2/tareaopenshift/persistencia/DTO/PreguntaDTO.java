package co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.DTO;

public class PreguntaDTO {
	
	
	private int idPreg;
	private double calificacion;
	
	public PreguntaDTO() {
		// TODO Auto-generated constructor stub
	}

	public PreguntaDTO(int idPreg, double calificacion) {
		super();
		this.idPreg = idPreg;
		this.calificacion = calificacion;
	}

	public int getIdPreg() {
		return idPreg;
	}

	public void setIdPreg(int idPreg) {
		this.idPreg = idPreg;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	

}
