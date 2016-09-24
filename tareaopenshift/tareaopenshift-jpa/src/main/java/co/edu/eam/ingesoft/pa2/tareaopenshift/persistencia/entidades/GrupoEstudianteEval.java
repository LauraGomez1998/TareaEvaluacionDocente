package co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(GrupoEstudianteEvalPK.class)
@Table(name = "GrupoEstudianteEval")
public class GrupoEstudianteEval implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name="idGrupo")
	private Grupo idGrupo;
	
	@Id
	@Column(name="idEstudiante")
	private String idEstudiante;

	@Column(name="estadoEvaluacion")
	private String estadoEvaluacion;
	
	public GrupoEstudianteEval() {
		// TODO Auto-generated constructor stub
	}

	public GrupoEstudianteEval(Grupo idGrupo, String idEstudiante, String estadoEvaluacion) {
		super();
		this.idGrupo = idGrupo;
		this.idEstudiante = idEstudiante;
		this.estadoEvaluacion = estadoEvaluacion;
	}

	public Grupo getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Grupo idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(String idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getEstadoEvaluacion() {
		return estadoEvaluacion;
	}

	public void setEstadoEvaluacion(String estadoEvaluacion) {
		this.estadoEvaluacion = estadoEvaluacion;
	}
	
	
}
