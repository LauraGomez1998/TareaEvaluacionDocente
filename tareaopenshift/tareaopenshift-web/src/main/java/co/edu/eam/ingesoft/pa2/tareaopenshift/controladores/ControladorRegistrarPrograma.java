package co.edu.eam.ingesoft.pa2.tareaopenshift.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.FacultadEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.ProgramaEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Programa;

@Named("programaWeb")
@ViewScoped
public class ControladorRegistrarPrograma implements Serializable{

	@EJB
	private ProgramaEJB programaEJB;
	
	@EJB
	private FacultadEJB facultadEJB;
	
	/**
	 * Lista de facultades
	 */
	private List<Facultad> listaFacultades;
	
	/**
	 * Identificador del programa
	 */
	private String idPrograma;
	
	/**
	 * Nombre del programa
	 */
	private String nombre;
	
	
	private Facultad facultadSeleccionada;
	
	@PostConstruct
	public void inicializar() {
		listaFacultades=facultadEJB.listarFacultad();
	}
	
	
	public void crear(){
		
		try {
			if(nombre!="" && idPrograma!=null){
				
				Programa programa = new Programa(idPrograma, nombre, facultadSeleccionada);
				programaEJB.crear(programa);
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Se registró programa exitosamente", null);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Llene campos", null);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (Exception e) {
			// TODO: handle exception
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Facultad> getListaFacultades() {
		return listaFacultades;
	}
	
	public void setListaFacultades(List<Facultad> listaFacultades) {
		this.listaFacultades = listaFacultades;
	}
	
	public String getIdPrograma() {
		return idPrograma;
	}
	
	public void setIdPrograma(String idPrograma) {
		this.idPrograma = idPrograma;
	}
	
	public Facultad getFacultadSeleccionada() {
		return facultadSeleccionada;
	}
	
	public void setFacultadSeleccionada(Facultad facultadSeleccionada) {
		this.facultadSeleccionada = facultadSeleccionada;
	}

	
	
	
	
	
	
	
	
	
}
