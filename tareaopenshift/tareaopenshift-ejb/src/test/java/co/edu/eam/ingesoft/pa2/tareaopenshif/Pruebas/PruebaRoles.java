package co.edu.eam.ingesoft.pa2.tareaopenshif.Pruebas;

import java.util.List;

import javax.ejb.EJB;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.RolEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Usuario;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.seguridad.Rol;

@RunWith(Arquillian.class)
public class PruebaRoles {

	@EJB
	private RolEJB rolEJB;
	
	@EJB
	private UsuarioEJB usuarioEJB;
	
	@Deployment
	public static EnterpriseArchive desplegar() {
		EnterpriseArchive ear = ArquillianUtil.createDeployment("../tareaopenshift-ear/target/tareaopenshift-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaRoles.class));
		return ear;
	}
	
	@Test
	public void TestRol(){
		Usuario usuario = usuarioEJB.buscar(1234);
		List<Rol> listaRoles = rolEJB.listarRoles(usuario);
		Assert.assertEquals(1, listaRoles.size());
	}
}
