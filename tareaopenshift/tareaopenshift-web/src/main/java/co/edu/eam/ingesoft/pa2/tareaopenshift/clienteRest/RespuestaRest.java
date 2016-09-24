package co.edu.eam.ingesoft.pa2.tareaopenshift.clienteRest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.RespuestaEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.DTO.ResponderEvalDTO;
import co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad.Seguridad;

@Seguridad
@Path("/respuesta")
public class RespuestaRest {

	@EJB
	private RespuestaEJB respuestaEJB;

	
	public RespuestaRest() {
		// TODO Auto-generated constructor stub
	}
	
	@PUT
	@Path("/responder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void respuesta(ResponderEvalDTO dto){
		respuestaEJB.crear(dto);
	}
	
}
