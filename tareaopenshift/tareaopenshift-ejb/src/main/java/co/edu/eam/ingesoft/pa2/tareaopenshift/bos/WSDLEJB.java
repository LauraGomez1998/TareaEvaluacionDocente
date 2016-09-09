package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.ws.BindingProvider;

import co.edu.eam.ingesoft.pa2.tareaopenshift.entidades.Curso;
import co.edu.eam.ingesoft.pa2.tareaopenshift.entidades.Estudiante;
import co.edu.eam.ingesoft.pa2.tareaopenshift.entidades.ServiciosAcademicos;
import co.edu.eam.ingesoft.pa2.tareaopenshift.entidades.ServiciosEducativosService;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Asignatura;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Programa;

@LocalBean
@Stateless
public class WSDLEJB implements Serializable {

	@EJB
	private ProgramaEJB programaEJB;
	@EJB
	private FacultadEJB facultadEJB;
	@EJB
	private AsignaturaEJB asignaturaEJB;

	private Facultad facultad;
	private Programa programa;
	private Asignatura asignatura;

	public boolean buscar(String cod, String ced) {
		ServiciosEducativosService cliente = new ServiciosEducativosService();
		ServiciosAcademicos servicio = cliente.getServiciosAcademicos();

		BindingProvider bp = (BindingProvider) servicio;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://174.142.65.144:28080/eamweb/serviciosAcademicos");

		Estudiante e = servicio.consultaEstudiante(cod, ced);
		if (e != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean crear(String cod, String ced) {
		ServiciosEducativosService cliente = new ServiciosEducativosService();
		ServiciosAcademicos servicio = cliente.getServiciosAcademicos();

		BindingProvider bp = (BindingProvider) servicio;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://174.142.65.144:28080/eamweb/serviciosAcademicos");

		List<Curso> listaCursos = servicio.consultarCursosEstudiante(cod, ced);

		for (int i = 0; i < listaCursos.size(); i++) {
			if (facultadEJB
					.buscar(listaCursos.get(i).getAsignatura().getPrograma().getFacultad().getCodigo()) != null) {
				facultad.setIdFacultad(listaCursos.get(i).getAsignatura().getPrograma().getFacultad().getCodigo());
				facultad.setNombre(listaCursos.get(i).getAsignatura().getPrograma().getFacultad().getNombre());

			} else {
				facultad = new Facultad();
				facultad.setIdFacultad(listaCursos.get(i).getAsignatura().getPrograma().getFacultad().getCodigo());
				facultad.setNombre(listaCursos.get(i).getAsignatura().getPrograma().getFacultad().getNombre());
				facultadEJB.crear(facultad);

			}
			if (programaEJB.buscar(listaCursos.get(i).getAsignatura().getPrograma().getCodigo()) != null) {
				programa.setIdFacultad(facultad);
				programa.setIdPrograma(listaCursos.get(i).getAsignatura().getPrograma().getCodigo());
				programa.setNombrePrograma(listaCursos.get(i).getAsignatura().getPrograma().getNombre());

			} else {
				programa = new Programa();
				programa.setIdFacultad(facultad);
				programa.setIdPrograma(listaCursos.get(i).getAsignatura().getPrograma().getCodigo());
				programa.setNombrePrograma(listaCursos.get(i).getAsignatura().getPrograma().getNombre());
				programaEJB.crear(programa);
			}
			if (asignaturaEJB.buscar(listaCursos.get(i).getAsignatura().getCodigo()) == null) {
				asignatura=new Asignatura();
				asignatura.setIdAsignatura(listaCursos.get(i).getAsignatura().getCodigo());
				asignatura.setNombreAsignatura(listaCursos.get(i).getAsignatura().getNombre());
				asignatura.setIdPrograma(programa);
				asignaturaEJB.crear(asignatura);
			}

		}
		if (!listaCursos.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
