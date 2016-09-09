package co.edu.eam.ingesoft.pa2.tareaopenshif.Pruebas;

import javax.ejb.EJB;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.caferrer.testdata.junit.TestDataUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Usuario;

@RunWith(Arquillian.class)
public class PruebaUsuario {
	
	@EJB
	private UsuarioEJB usuarioEJB;
	
	@Deployment
	public static EnterpriseArchive desplegar() {
		EnterpriseArchive ear = ArquillianUtil.createDeployment("../tareaopenshift-ear/target/tareaopenshift-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaUsuario.class));
		return ear;
	}
	
	@Test
	public void TestUsuario(){
		Usuario usuario = new Usuario();
		usuario.setId(3421);
		usuario.setNombre("Alejandro");
		usuario.setApellido("Matallana");
		usuario.setUsuario("Alejandro");
		usuario.setPassword("1234");
		usuarioEJB.crear(usuario);
		Usuario u = usuarioEJB.buscar(3421);
		Assert.assertNotNull(u);
		
	}
	
	@AfterClass
	public static void finlizar(){
		TestDataUtil.ejecutarSQL("sqltest/Prueba-delete.sql");
	}

}
