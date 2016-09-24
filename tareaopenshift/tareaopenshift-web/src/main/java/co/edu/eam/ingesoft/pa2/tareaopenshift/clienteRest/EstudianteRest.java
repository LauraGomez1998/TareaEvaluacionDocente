package co.edu.eam.ingesoft.pa2.tareaopenshift.clienteRest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.WSDLEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Grupo;
import co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad.Seguridad;

@Seguridad
@Path("/estudiante")
public class EstudianteRest {
	
	@EJB
	private WSDLEJB wsdlEJB;
	
	public EstudianteRest() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarEstudiante")
	public RespuestaDTO buscar(@QueryParam (value="cod") String cod, 
			@QueryParam (value="ced") String ced){
		if(wsdlEJB.buscar(cod, ced)){
			return new RespuestaDTO(true);
		}else{
			return new RespuestaDTO(false, "No encontró", "11");
		}
	}
	
	@GET
	@Path("/listarCursos")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarCursos(@QueryParam (value="cod") String cod, 
			@QueryParam (value="ced") String ced){
		List<Grupo> listaGrupos = wsdlEJB.listarGruposEstudiante(cod, ced);
		if(!listaGrupos.isEmpty()){
			return new RespuestaDTO(listaGrupos);
		}else{
			return new RespuestaDTO(null, "La lista no existe", "11");
		}
	}

}
