package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.tareaopenshift.ejbremote.AsignaturaRemoteEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.tareaopenshift.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Asignatura;

@Stateless
@LocalBean
@Remote(AsignaturaRemoteEJB.class)
public class AsignaturaEJB extends EJBGenerico<Asignatura> implements AsignaturaRemoteEJB {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Asignatura.class;
	}
	
	public Asignatura buscar(Object pk){
		return dao.buscar(pk);
	}
	
	public void crear(Asignatura asignatura) throws ExcepcionNegocio{
		if(buscar(asignatura.getIdAsignatura())!=null){
			throw new ExcepcionNegocio("La asignatura ya se encuentra registrada");
		}else{
			dao.crear(asignatura);
		}
	}
	

}
