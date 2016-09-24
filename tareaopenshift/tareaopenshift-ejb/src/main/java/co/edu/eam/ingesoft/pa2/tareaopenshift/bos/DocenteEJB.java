package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.tareaopenshift.ejbremote.DocenteRemoteEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.tareaopenshift.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Docente;

@Stateless
@LocalBean
@Remote(DocenteRemoteEJB.class)
public class DocenteEJB extends EJBGenerico<Docente> implements DocenteRemoteEJB{

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Docente.class;
	}
	
	public void crear(Docente docente) throws ExcepcionNegocio{
		if(buscar(docente.getId())!=null){
			throw new ExcepcionNegocio("El docente ya existe");
		}else{
			dao.crear(docente);
		}
	}
	
	public Docente buscar(Object pk){
		return dao.buscar(pk);
	}

}
