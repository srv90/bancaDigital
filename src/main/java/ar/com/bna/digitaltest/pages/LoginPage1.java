package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage1 extends BasePage {

	private By header = By.xpath("//*[name()='svg' and @aria-label='Banco Nación']");
	private By username = By.id("username");
	private By continuarButton = By.id("global.continue");
	private By recuperarUsuario = By.id(".login.stepOne.forgotUser..false.false.span");

	public LoginPage1(WebDriver driver) {
		super(driver);
	}


	public String getLoginPageHeader() {
		return super.waitUntilElementIsPresent(header).getDomAttribute("alt");
	}

	public void enterUsername(String username) {
		super.sendKeys(this.username, username);
	}
	
	public RecuperarUsuarioPage getRecuperarUsuario() {
		super.waitUntilElementIsPresent(recuperarUsuario).click();
		return super.getInstance(RecuperarUsuarioPage.class);
	}

	public LoginPage2 getLoginPage2() {
		super.click(continuarButton);
		return super.getInstance(LoginPage2.class);
	}

}
