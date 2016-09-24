package co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad;

import java.io.IOException;


import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import co.edu.eam.ingesoft.pa2.tareaopenshift.clienteRest.LoginRest;
import co.edu.eam.ingesoft.pa2.tareaopenshift.dto.RespuestaDTO;

@Seguridad
@Provider
public class FiltroRest implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext crc) throws IOException {
		String token = crc.getHeaderString("Authorization");
		
		if (!LoginRest.tokens.containsKey(token)) {
			RespuestaDTO respuesta = new RespuestaDTO(null, "NO esta autorizado", "-3");
			Response response = Response.status(401).entity(respuesta).build();
			crc.abortWith(response);
		} 
	}

}