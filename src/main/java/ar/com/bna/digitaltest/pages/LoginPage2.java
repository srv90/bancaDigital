package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage2 extends BasePage {

	private By password = By.id("password");
	private By continuarButton = By.id("global.continue");
	private By avatarImagen = By.cssSelector("img[id^='avatar']");
	private By alertError = By.xpath("//div[@class='notification-message']");
	
		public LoginPage2(WebDriver driver) {
		super(driver);
	}

	public void enterPassword(String password) {
		super.sendKeys(this.password, password);
	}

	public boolean avatarIsDisplayed() {
		return super.waitUntilElementIsPresent(avatarImagen).isDisplayed();
	}

	
	public String alertErrorMessageText() {
		
		return super.waitUntilElementIsPresent(alertError).getText();
	}

	public boolean alertErrorMessageIsDisplayed() {
		return super.waitUntilElementIsPresent(alertError).isDisplayed();
	}
	
	public String getImagenActual() {
		
		return super.waitUntilElementIsPresent(avatarImagen).getAttribute("id");
	}

	public HomePage getHomePage() {
		super.click(continuarButton);
		return super.getInstance(HomePage.class);

	}

}
