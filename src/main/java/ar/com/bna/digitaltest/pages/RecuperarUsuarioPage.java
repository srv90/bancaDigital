package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecuperarUsuarioPage extends BasePage{
	
	private By header = By.xpath("//span[normalize-space()='Recuperar usuario']");
	private By continuarButton = By.id("global.continue");
	private By errorMensajeObligatorio = By.xpath("//p[normalize-space()='Este campo es obligatorio.']");
	private By errorMensajeFormato = By.xpath("//p[normalize-space()='El CUIT/CUIL ingresado no es válido']");
	private By errorMensajeCuitCuilInexistente = By.xpath("//h1[normalize-space()='No hemos podido procesar tu solicitud']");
	private By textbox = By.id("document");


	public RecuperarUsuarioPage(WebDriver driver) {
		super(driver);
	}
	
	public String getLoginPageHeader() {
		return super.waitUntilElementIsPresent(header).getText();
	}
	
	public void enterCuilCuit(String cuitCuil) {
		super.sendKeys(textbox, cuitCuil);
	}
	
	public void click() {
		super.getWebElement(continuarButton).click();
	}
	
	public String getErrorMensajeObligatorio() {
		return super.getWebElement(errorMensajeObligatorio).getText();
	}
	
	public String getErrorMensajeFormato() {
		return super.getWebElement(errorMensajeFormato).getText();
	}
	
	public String getErrorMensajeCuitCuilInexistente() {
		return super.waitUntilElementIsPresent(errorMensajeCuitCuilInexistente).getText();
	}

}
