package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePage {

	private By modificarImagenButton = By.id("settings.options.changeSecuritySeal");
	private By confirmacionAlert = By.id("La_imagen_de_seguridad_ha_sido_modificada_con_éxito.");
	private By settingsButton = By.id("loggedUserMenu");
	private By salirButton = By.id("global.logout");

	public SettingsPage(WebDriver driver) {
		super(driver);
	}

	public ChangeSecuritySealPage getchangeSecuritySealPage() {

		super.waitUntilElementIsClickable(modificarImagenButton).click();
		return super.getInstance(ChangeSecuritySealPage.class);
	}

	public String getConfirmacionAlertMensaje() {
		return super.waitUntilElementIsPresent(confirmacionAlert).getText();
	}

	
	public LoginPage1 getLoginPage1 () {
		
		super.moveToWebElement(settingsButton);
		super.clickWebElement(settingsButton);
		super.clickWebElement(salirButton);
		return super.getInstance(LoginPage1.class);
	}
}
