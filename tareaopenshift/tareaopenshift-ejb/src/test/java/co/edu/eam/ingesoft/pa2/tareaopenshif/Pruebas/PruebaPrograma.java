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

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.FacultadEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.ProgramaEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Programa;

@RunWith(Arquillian.class)
public class PruebaPrograma {
	
	@EJB
	private ProgramaEJB programaEJB;
	
	@EJB
	private FacultadEJB facultadEJB;
	
	@Deployment
	public static EnterpriseArchive desplegar() {
		EnterpriseArchive ear = ArquillianUtil.createDeployment("../tareaopenshift-ear/target/tareaopenshift-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaPrograma.class));
		return ear;
	}
	
	
	@Test
	public void TestPrograma(){
		
		Programa programa = new Programa();
		programa.setIdPrograma("2134");
		programa.setNombrePrograma("Prueba programa unitario");
		programa.setIdFacultad(facultadEJB.buscar("1"));
		programaEJB.crear(programa);
		Programa p = programaEJB.buscar("2134");
		Assert.assertNotNull(p);	
		
	}
	
	@AfterClass
	public static void finalizar(){
		TestDataUtil.ejecutarSQL("sqltest/Prueba-delete.sql");
	}

}
