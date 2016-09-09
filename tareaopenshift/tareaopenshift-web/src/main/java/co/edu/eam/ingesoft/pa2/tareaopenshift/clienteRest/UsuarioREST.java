package co.edu.eam.ingesoft.pa2.tareaopenshift.clienteRest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Usuario;

@Path("/usuario")
public class UsuarioREST {

	@EJB
	private UsuarioEJB usurioEJB;

	public UsuarioREST() {

	}

	@GET
	@Path("/buscarUsuario")
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	public RespuestaDTO buscar(@QueryParam(value = "cedula") int cedula) {
		Usuario u = usurioEJB.buscar(cedula);
		return new RespuestaDTO(u);
	}
	
	
	@Path("/crearUsuario")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO crear(Usuario usuario){
		usurioEJB.crear(usuario);
		return new RespuestaDTO();
	}
	
	
	@GET
	@Path("/lista")
	@Produces
	public RespuestaDTO listarUsuarios(){
		List<Usuario> lista =  usurioEJB.listarUsuario("LAURA");
		return new RespuestaDTO(lista);
		
	}
	
	
	
	
	
	
	
}
