package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import java.util.GregorianCalendar;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.tareaopenshift.ejbremote.RespuestaRemoteEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.tareaopenshift.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.DTO.ResponderEvalDTO;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Evaluacion;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Grupo;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.PregEval;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Pregunta;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.RespPreg;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Respuesta;

@Stateless
@LocalBean
@Remote(RespuestaRemoteEJB.class)
public class RespuestaEJB extends EJBGenerico<Respuesta> implements RespuestaRemoteEJB {
	@EJB
	private PreguntaEJB preguntaEJB;
	@EJB
	private EvaluacionEJB evaluacionEJB;
	@EJB
	private PregEvalEJB pregEvalEJB;
	@EJB
	private RespPregEJB respPregEJB;
	@EJB
	private GrupoEJB grupoEJB;

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Respuesta.class;
	}

	public Respuesta buscar(Object pk) {
		return dao.buscar(pk);
	}

	public void crear(Respuesta respuesta) throws ExcepcionNegocio {
		if (buscar(respuesta.getIdRespuestas()) != null) {
			throw new ExcepcionNegocio("La respuesta ya ha sido registrada");
		} else {
			dao.crear(respuesta);
		}
	}

	@Override
	public void crear(ResponderEvalDTO dto) {
		// TODO Auto-generated method stub
		Evaluacion evaluacion = evaluacionEJB.buscar(dto.getIdEval());
		Pregunta pregunta = preguntaEJB.buscar(dto.getIdPreg());
		PregEval pregEval = new PregEval(pregunta, evaluacion);
		pregEvalEJB.crear(pregEval);

		Grupo grupo = grupoEJB.buscar(dto.getIdGrupo());
		Respuesta respuesta = new Respuesta(1, grupo, GregorianCalendar.getInstance().getTime(), dto.getComentario());
		crear(respuesta);

		RespPreg respPreg = new RespPreg(respuesta, dto.getCaificacion(), pregEval);
		respPregEJB.crear(respPreg);
	}

}
