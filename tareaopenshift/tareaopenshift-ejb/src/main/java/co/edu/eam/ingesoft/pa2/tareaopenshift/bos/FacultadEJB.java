/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.tareaopenshift.ejbremote.FacultadRemoteEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.tareaopenshift.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Facultad;

/**
 * @author Alejandro
 *
 */
@LocalBean
@Stateless
@Remote(FacultadRemoteEJB.class)
public class FacultadEJB extends EJBGenerico<Facultad> implements FacultadRemoteEJB {

	@Override
	public List<Facultad> listarFacultad() {
		return dao.ejecutarNamedQuery(Facultad.LISTA_FACULTADES);
	}

	public Facultad buscar(Object pk) {
		return dao.buscar(pk);
	}
	
	

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Facultad.class;
	}

	public void crear(Facultad f){
		if(buscar(f.getIdFacultad())==null){
		dao.crear(f);
		}else {
			throw new ExcepcionNegocio("Ya se encuentra esta facultad");
		}
	}
}
