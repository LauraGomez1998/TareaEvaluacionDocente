/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Alejandro
 *
 */
@Entity
@IdClass(value=RespPregPK.class)
@Table(name = "RespuestasPreg")
public class RespPreg implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "idRespuesta")
	private Respuesta idRespuesta;

	
	@Column(name = "calificacion")
	private double calificacion;
	
	@Id
	@ManyToOne
	@JoinColumns({@JoinColumn(name="idPregunta", referencedColumnName="idPregunta"),
		@JoinColumn(name="idEvaluacion", referencedColumnName="idEvaluacion")})
	private PregEval pregEval;

	// Constructor vacio
	public RespPreg() {
		super();
	}
	
	

	public RespPreg(Respuesta idRespuesta, double calificacion, PregEval pregEval) {
		super();
		this.idRespuesta = idRespuesta;
		this.calificacion = calificacion;
		this.pregEval = pregEval;
	}



	public Respuesta getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(Respuesta idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public PregEval getPregEval() {
		return pregEval;
	}

	public void setPregEval(PregEval pregEval) {
		this.pregEval = pregEval;
	}


}
