package co.edu.eam.ingesoft.pa2.tareaopenshift.clienteRest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.PreguntaEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Pregunta;
import co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad.Seguridad;

@Seguridad
@Path("/pregunta")
public class PreguntasRest {

	@EJB
	private PreguntaEJB preguntaEJB;
	
	
	public PreguntasRest() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Path("/listarPreguntas")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarPreguntas(){
		List<Pregunta> listaPreguntas = preguntaEJB.listarPreguntas();
		if(!listaPreguntas.isEmpty()){
			return new RespuestaDTO(listaPreguntas);	
		}else{
			return new RespuestaDTO(null, "La lista no existe", "11");
		}
		
	}
	
}
