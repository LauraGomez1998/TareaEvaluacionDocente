package co.edu.eam.ingesoft.pa2.tareaopenshift.PaginasPruebas;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


@Location("paginas/programa.jsf")
public class PaginaProgramaJSF {
	
	@Drone
	private WebDriver browser;
	
	@FindBy(id="idPrograma")
	private WebElement idPrograma;
	
	@FindBy(id="nombre")
	private WebElement nombre;
	
	//comboFacultad_input
	@FindBy(id="comboFacultad_input")
	private Select comboFacultad;
	
	@FindBy(id="btnCrear")
	private WebElement btnCrear;
	
	@FindBy(id="facesMsjs")
	private WebElement msj;
	
	public String CrearProgramaPrueba(){
		idPrograma.sendKeys("54321");
		nombre.sendKeys("Ingenieria Civil");
		comboFacultad.selectByValue("1");
		
		Graphene.guardAjax(btnCrear).click();
		Graphene.waitModel().until().element(msj).is().present();
		return msj.getText();
	}
	
	
	
	
	
	
	
	
}
