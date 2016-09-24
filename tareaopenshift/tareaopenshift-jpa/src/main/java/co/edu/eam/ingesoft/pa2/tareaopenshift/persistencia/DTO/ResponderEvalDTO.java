package co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.DTO;

public class ResponderEvalDTO {

	private String idGrupo;
	private int idPreg;
	private int idEval;
	private String idEstudiante;
	private String comentario;
	private double caificacion;
	
	
	public ResponderEvalDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ResponderEvalDTO(String idGrupo, int idPreg, int idEval, String idEstudiante, String comentario,
			double caificacion) {
		super();
		this.idGrupo = idGrupo;
		this.idPreg = idPreg;
		this.idEval = idEval;
		this.idEstudiante = idEstudiante;
		this.comentario = comentario;
		this.caificacion = caificacion;
	}
	public String getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}
	public int getIdPreg() {
		return idPreg;
	}
	public void setIdPreg(int idPreg) {
		this.idPreg = idPreg;
	}
	public int getIdEval() {
		return idEval;
	}
	public void setIdEval(int idEval) {
		this.idEval = idEval;
	}
	public String getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(String idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public double getCaificacion() {
		return caificacion;
	}
	public void setCaificacion(double caificacion) {
		this.caificacion = caificacion;
	}
	
	
	
	
	
}
