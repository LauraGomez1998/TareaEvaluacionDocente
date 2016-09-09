package co.edu.eam.ingesoft.pa2.tareaopenshift.controladores;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.RolEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Usuario;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.seguridad.Acceso;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.seguridad.Rol;
import co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad.MD5Util;

@Named("login")
@SessionScoped
public class SessionBean implements Serializable {

	private String user;

	private String password;

	@EJB
	private UsuarioEJB usuarioEJB;

	@EJB
	private RolEJB rolEJB;

	private List<Rol> listaRoles;

	private List<Acceso> listaAccesos;

	private Usuario usuario;

	public String login() {
		Usuario usuario = null;
		if (!usuarioEJB.listarUsuario(user).isEmpty()) {
			usuario = usuarioEJB.listarUsuario(user).get(0);
		}
		password = MD5Util.code(password);
		if (usuario != null && password.equals(usuario.getPassword())) {
			this.usuario = usuario;
			listaRoles = rolEJB.listarRoles(usuario);
			listaAccesos = rolEJB.listarAccesos(listaRoles);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha iniciado sesión existosamente",
					null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "/paginas/inicio.jsf?faces-redirect=true";
		} else {
			listaAccesos = null;
			listaRoles = null;
			this.usuario = null;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Usuario o contraseña incorrectos, intente de nuevo", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}
	}

	public boolean isLogged() {
		return this.usuario != null;
	}

	public String LogOut() {
		Faces.getSession().invalidate();
		return "/index.jsf?faces-redirect=true";
	}

	/**
	 * Accesored y modificdores
	 */

	public List<Acceso> getListaAccesos() {
		return listaAccesos;
	}

	public void setListaAccesos(List<Acceso> listaAccesos) {
		this.listaAccesos = listaAccesos;
	}

	public List<Rol> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<Rol> listaRoles) {
		this.listaRoles = listaRoles;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
