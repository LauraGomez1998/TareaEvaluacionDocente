package co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades;

import java.io.Serializable;

public class RespPregPK  implements Serializable{
	
	private PregEvalPK pregEval;
	
	private int idRespuesta;
	
	public RespPregPK() {
		// TODO Auto-generated constructor stub
	}

	public RespPregPK(PregEvalPK pregEval, int idRespuesta) {
		super();
		this.pregEval = pregEval;
		this.idRespuesta = idRespuesta;
	}

	public PregEvalPK getPregEval() {
		return pregEval;
	}

	public void setPregEval(PregEvalPK pregEval) {
		this.pregEval = pregEval;
	}

	public int getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRespuesta;
		result = prime * result + ((pregEval == null) ? 0 : pregEval.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RespPregPK other = (RespPregPK) obj;
		if (idRespuesta != other.idRespuesta)
			return false;
		if (pregEval == null) {
			if (other.pregEval != null)
				return false;
		} else if (!pregEval.equals(other.pregEval))
			return false;
		return true;
	}
	
	

}
