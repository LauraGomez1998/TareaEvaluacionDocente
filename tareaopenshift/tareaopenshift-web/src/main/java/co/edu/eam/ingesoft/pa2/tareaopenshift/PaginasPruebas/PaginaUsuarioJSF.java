package co.edu.eam.ingesoft.pa2.tareaopenshift.PaginasPruebas;

import org.apache.bcel.generic.Select;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Location("paginas/pagina.jsf")
public class PaginaUsuarioJSF {
	
	@Drone
	private WebDriver browser;
	
	@FindBy(id="tfnombre")
	private WebElement tfnombre;

	@FindBy(id="tfapellido")
	private WebElement tfapellido;
	
	@FindBy(id="tfcedula")
	private WebElement tfcedula;
	
	@FindBy(id="tfusuario")
	private WebElement tfusuario;
	
	@FindBy(id="tfcontrasenia")
	private WebElement tfcontrasenia;
	
	@FindBy(id="comboUsuario")
	private Select comboUsuario;
	
	@FindBy(id="comboPrograma")
	private Select comboPrograma;
	
	@FindBy(id="btnCrear")
	private WebElement btnCrear;
	
	@FindBy(id="comboFacultad")
	private Select comboFacultad;
	
	@FindBy(id="facesMessage")
	private WebElement msj;
	
	public String CrearUsuarioPrueba(){
		tfcedula.sendKeys("1998");
		tfnombre.sendKeys("Daniela");
		tfapellido.sendKeys("Amaya");
		tfusuario.sendKeys("Daniela");
		tfcontrasenia.sendKeys("1234");
		
		Graphene.guardAjax(btnCrear).click();
		Graphene.waitModel().until().element(msj).is().present();
		
		return msj.getText();
	}
	
	
	
	
}
