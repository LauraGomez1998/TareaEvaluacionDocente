/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.tareaopenshift.ejbremote.ProgramaRemoteEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.tareaopenshift.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Programa;

/**
 * @author 
 *
 */
@LocalBean
@Stateless
@Remote(ProgramaRemoteEJB.class)
public class ProgramaEJB extends EJBGenerico<Programa> implements ProgramaRemoteEJB {

	@Override
	public List<Programa> listarPrograma() {

		return dao.ejecutarNamedQuery(Programa.LISTA_PROGRAMAS);
	}

	public Programa buscar(Object pk) {
		return dao.buscar(pk);
	}
	
	public void crear(Programa programa) throws ExcepcionNegocio {
		if (buscar(programa.getIdPrograma()) != null) {
			throw new ExcepcionNegocio("El programa ya se encuentra registrado");
		} else {
			dao.crear(programa);
		}
	}	

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Programa.class;
	}

}
