package co.edu.eam.ingesoft.pa2.tareaopenshift.clienteRest;

import java.util.HashMap;

import java.util.Map;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.WSDLEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.dto.RespuestaDTO;

@Path("/seguridad")
public class LoginRest {

	@EJB
	private WSDLEJB wsdlEJB;
	public static Map<String, String> tokens = new HashMap<>();

	@GET
	@Path("/validarlog")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO login(@QueryParam(value = "ced") String ced, @QueryParam(value = "cod") String cod) {
		if (wsdlEJB.buscar(cod, ced)) {
			String token = UUID.randomUUID().toString();
			tokens.put(token, ced);
			return new RespuestaDTO(token);
		} else {
			return new RespuestaDTO(null, "NO AUTORIZADO", "-1");
		}

	}

}