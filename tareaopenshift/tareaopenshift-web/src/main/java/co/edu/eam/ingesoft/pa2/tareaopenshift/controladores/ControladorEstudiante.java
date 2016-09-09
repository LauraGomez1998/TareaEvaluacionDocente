package co.edu.eam.ingesoft.pa2.tareaopenshift.controladores;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.WSDLEJB;

@Named("estudiante")
@ViewScoped
public class ControladorEstudiante implements Serializable {

	private String codigo;
	private String cedula;

	@EJB
	private WSDLEJB wsldEJB;

	public void buscar() {
		if (wsldEJB.buscar(codigo, cedula)) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se encontró el estudiante", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se encontró el estudiante", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void crear() {
		if (wsldEJB.crear(codigo, cedula)) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró curso bhdksa", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se resgistró curso", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public String getCedula() {
		return cedula;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
