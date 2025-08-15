package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class newPFPage2 extends BasePage{

	private By checkboxTyC = By.id("agreementinvestments.termsAndConditions.label.span");
	private By modalTexto = By.id("undefined_modal_scroll");
	private By modalAceptarButton = By.id("termsAndConditions.component.aceptar.label");
	private By confirmarButton = By.id("global.confirm");
	
	
	public newPFPage2(WebDriver driver) {
		super(driver);
	}
	
	
	public ComprobantePFPage getComprbobantePFPage() {
		
		super.waitUntilElementIsClickable(checkboxTyC).click();
		super.waitUntilElementIsPresent(modalTexto);
		super.moveToWebElement(modalTexto);
		super.getWebElement(modalTexto).click();
		super.waitUntilElementIsPresent(modalTexto).sendKeys(Keys.END);
		super.waitUntilElementIsClickable(modalAceptarButton).click();
		super.moveToWebElement(confirmarButton);
		super.waitUntilElementIsPresent(confirmarButton).click();
		
		return super.getInstance(ComprobantePFPage.class);
		
	}
	

}
