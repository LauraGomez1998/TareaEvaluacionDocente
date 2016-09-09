package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Usuario;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.seguridad.Acceso;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.seguridad.AccesoRol;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.seguridad.Rol;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.seguridad.UsuarioRol;

@LocalBean
@Stateless
public class RolEJB {
	
	@PersistenceContext
	private EntityManager m;
	
	
	public List<Rol> listarRoles(Usuario usuario){
		Query query = m.createNamedQuery(UsuarioRol.LISTAR_ROL_USUARIO);
		query.setParameter(1,usuario);
		return query.getResultList();
	}
	
	public List<Acceso> listarAccesos(List<Rol> listaRoles){
		List<Acceso> listaAcceso = new ArrayList<>();
		if (!listaRoles.isEmpty()) {
			for (int i = 0; i < listaRoles.size(); i++) {
				Query q = m.createNamedQuery(AccesoRol.LISTAR_ACCESOS);
				q.setParameter(1, listaRoles.get(i));
				List<Acceso> listaResul = q.getResultList();
				if (!listaResul.isEmpty()) {
					for (int j = 0; j < listaResul.size(); j++) {
						listaAcceso.add(listaResul.get(j));
					}
				}
			}
		}
		return listaAcceso;
		
	}

}
