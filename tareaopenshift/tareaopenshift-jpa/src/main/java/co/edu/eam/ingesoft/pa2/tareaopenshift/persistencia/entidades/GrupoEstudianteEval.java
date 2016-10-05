package co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.enumeraciones.EstadoEvaluacion;

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

	@Enumerated(EnumType.STRING)
	@Column(name="estadoEvaluacion")
	private EstadoEvaluacion estadoEvaluacion;
	
	public GrupoEstudianteEval() {
		// TODO Auto-generated constructor stub
	}

	public GrupoEstudianteEval(Grupo idGrupo, String idEstudiante, EstadoEvaluacion estadoEvaluacion) {
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

	public EstadoEvaluacion getEstadoEvaluacion() {
		return estadoEvaluacion;
	}

	public void setEstadoEvaluacion(EstadoEvaluacion estadoEvaluacion) {
		this.estadoEvaluacion = estadoEvaluacion;
	}
	
	
}
