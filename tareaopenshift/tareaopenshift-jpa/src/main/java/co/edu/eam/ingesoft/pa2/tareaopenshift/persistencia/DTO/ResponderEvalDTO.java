package co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.DTO;

import java.util.List;



public class ResponderEvalDTO {

	private List<PreguntaDTO> listaPreg;
	private String idGrupo;
	private int idEval;
	private String idEstudiante;
	private String comentario;
	
	
	public ResponderEvalDTO() {
		// TODO Auto-generated constructor stub
	}


	public ResponderEvalDTO(List<PreguntaDTO> listaPreg, String idGrupo, int idEval, String idEstudiante,
			String comentario) {
		super();
		this.listaPreg = listaPreg;
		this.idGrupo = idGrupo;
		this.idEval = idEval;
		this.idEstudiante = idEstudiante;
		this.comentario = comentario;
	}


	public List<PreguntaDTO> getListaPreg() {
		return listaPreg;
	}


	public void setListaPreg(List<PreguntaDTO> listaPreg) {
		this.listaPreg = listaPreg;
	}


	public String getIdGrupo() {
		return idGrupo;
	}


	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
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


	
}
