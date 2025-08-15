package ar.com.bna.digitaltest.pages;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ar.com.bna.digitaltest.util.Utilities;

public class ChangeSecuritySealPage extends BasePage {

	private By imagenesListado = By.xpath("//ul[@class='sc-ejfMa-d cOQQsi sc-IqJVf gGPejk']/li");
	private By continuarButton = By.id("global.continue");
	private By imagenNueva = By.xpath("//li[@class='sc-iEXKAA inqorl']/button");
	private By imagenActual = By.xpath("//div[@class='sc-fyVfxW jqDDsE']/img");

	public ChangeSecuritySealPage(WebDriver driver) {
		super(driver);

	}

	public ChangeSecuritySealPageConfirmation getChangeSecuritySealPageConfirmation() {

		super.waitUntilElementIsPresent(imagenesListado);
		super.waitUntilElementIsClickable(imagenNueva).click();
		super.moveToWebElement(continuarButton);
		super.click(continuarButton);
		return super.getInstance(ChangeSecuritySealPageConfirmation.class);

	}


}
