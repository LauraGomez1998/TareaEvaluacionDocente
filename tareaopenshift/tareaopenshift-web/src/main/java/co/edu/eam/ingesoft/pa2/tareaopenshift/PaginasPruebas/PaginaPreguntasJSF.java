package co.edu.eam.ingesoft.pa2.tareaopenshift.PaginasPruebas;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Location("paginas/preguntas.jsf")
public class PaginaPreguntasJSF {
	
	@Drone
	private WebDriver browser;
	

	@FindBy(id="pregunta")
	private WebElement tApregunta;
	
	@FindBy(id="peso")
	private WebElement tfPeso;
	
	@FindBy(id="btnCrear")
	private WebElement btnCrear;
	
	@FindBy(id="facesMessage")
	private WebElement msj;
	
	
	public String CrearPregunta(){
		tApregunta.sendKeys("Pregunta prueba 1");
		tfPeso.sendKeys("12");
		
		Graphene.guardAjax(btnCrear).click();
		Graphene.waitModel().until().element(msj).is().present();
		
		return msj.getText();
	}

}
