package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import java.util.GregorianCalendar;
import java.util.List;

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
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.GrupoEstudianteEval;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.PregEval;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Pregunta;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.RespPreg;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Respuesta;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.enumeraciones.EstadoEvaluacion;

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
	@EJB
	private GrupoEstudianteEvalEJB grupoEstudianteEvalEJB;

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
		
		

		Grupo grupo = grupoEJB.buscar(dto.getIdGrupo());
		Respuesta respuesta = new Respuesta(grupo, GregorianCalendar.getInstance().getTime(), dto.getComentario());
		crear(respuesta);
		
		Evaluacion evaluacion = evaluacionEJB.buscar(dto.getIdEval());
		
		
		
		for(int i=0; i< dto.getListaPreg().size(); i++){
			Pregunta pregunta = preguntaEJB.buscar(dto.getListaPreg().get(i).getIdPreg());
			
			PregEval pregEval = new PregEval(pregunta, evaluacion);
			pregEvalEJB.crear(pregEval);

			RespPreg respPreg = new RespPreg(respuesta, dto.getListaPreg().get(i).getCalificacion(), pregEval);
			respPregEJB.crear(respPreg);
		}
		evaluacion.setEstado(EstadoEvaluacion.CALIFICADO);
		evaluacionEJB.editar(evaluacion);
		GrupoEstudianteEval grupoEval = new GrupoEstudianteEval(grupo, dto.getIdEstudiante(), evaluacion.getEstado());
		grupoEstudianteEvalEJB.crear(grupoEval);
		
		
		
		
	}

}
