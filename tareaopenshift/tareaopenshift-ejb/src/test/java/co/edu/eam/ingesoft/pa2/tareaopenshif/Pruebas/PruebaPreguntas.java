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

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.PreguntaEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Pregunta;

@RunWith(Arquillian.class)
public class PruebaPreguntas {

	@EJB
	private PreguntaEJB preguntaEJB;

	@Deployment
	public static EnterpriseArchive desplegar() {
		EnterpriseArchive ear = ArquillianUtil.createDeployment("../tareaopenshift-ear/target/tareaopenshift-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaPreguntas.class));
		return ear;
	}

	
	@Test
	public void TestPreguntas(){
		Pregunta pregunta = new Pregunta();
		pregunta.setIdPregunta(321);
		pregunta.setTexto("Pregunta prueba");
		pregunta.setValor(50);
		preguntaEJB.crear(pregunta);
		Pregunta p = preguntaEJB.buscar(321);
		Assert.assertNotNull(p);
	}
	
	
	
	@AfterClass
	public static void finalizar(){
		TestDataUtil.ejecutarSQL("sqltest/Prueba-delete.sql");
	}
	
	

}
