package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ChangeSecuritySealPageConfirmation extends BasePage {

	private By tokens = By.id("secondFactor");
	private By confirmarButton = By.id("global.confirm");
	private By nuevaImagen = By.tagName("img");

	
	public ChangeSecuritySealPageConfirmation(WebDriver driver) {
		super(driver);
	}

	public void cambiarImagen() {

		getIdImagenNueva();
		super.moveToWebElement(confirmarButton);
		super.getWebElement(tokens).sendKeys("111111", Keys.ENTER);
	}

	
	public String getIdImagenNueva() {
		
		System.out.println(super.waitUntilElementIsPresent(nuevaImagen).getAttribute("id"));
		return super.waitUntilElementIsPresent(nuevaImagen).getAttribute("id");
	}

}
