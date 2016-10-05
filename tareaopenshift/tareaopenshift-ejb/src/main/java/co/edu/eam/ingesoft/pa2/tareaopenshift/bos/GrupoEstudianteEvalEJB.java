package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.tareaopenshift.ejbremote.GrupoEstudianteEvalRemoteEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.GrupoEstudianteEval;

@LocalBean
@Stateless
@Remote(GrupoEstudianteEvalRemoteEJB.class)
public class GrupoEstudianteEvalEJB extends EJBGenerico<GrupoEstudianteEval> implements GrupoEstudianteEvalRemoteEJB {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return GrupoEstudianteEval.class;
	}
	
	public void crear(GrupoEstudianteEval g){
		dao.crear(g);
	}
	
	

}
