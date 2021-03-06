package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;


import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.tareaopenshift.ejbremote.RespPregRemoteEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.ejbremote.RespuestaRemoteEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.tareaopenshift.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.RespPreg;

@Stateless
@LocalBean
@Remote(RespuestaRemoteEJB.class)
public class RespPregEJB extends EJBGenerico<RespPreg> implements RespPregRemoteEJB{

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return RespPreg.class;
	}
	
	
	public void crear(RespPreg respPreg) throws ExcepcionNegocio{
		
			dao.crear(respPreg);
		
	}
}
