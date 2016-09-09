package co.edu.eam.ingesoft.pa2.tareaopenshift.PruebasJSF;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import co.edu.eam.ingesoft.pa2.tareaopenshift.PaginasPruebas.PaginaProgramaJSF;
import co.edu.eam.ingesoft.pa2.tareaopenshift.PaginasPruebas.PaginaUsuarioJSF;

@RunWith(Arquillian.class)
public class PruebaUsuarioJSF {

	
	@Drone
	private WebDriver browser;
	
	
	@Deployment
	public static EnterpriseArchive desplegar(){
		EnterpriseArchive ear=ArquillianUtil.createDeployment("../tareaopenshift-ear/target/tareaopenshift-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaUsuarioJSF.class));
		return ear;
	}
	
	@BeforeClass
	public static void inicio(){
		
	}
	
	@Test
	@RunAsClient
	public void TestPreguntasJSF(@InitialPage PaginaUsuarioJSF pagina){
		String respuesta=pagina.CrearUsuarioPrueba();
		ArquillianUtil.takeScreenshot(browser, "pruebaUsusarioJSF.jpg");
		Assert.assertEquals("Se realizó registro exitosamente", respuesta);
		
	}
	
	@AfterClass
	public static void finalizar(){
		
	}
}
