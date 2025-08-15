package ar.com.bna.digitaltest.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ar.com.bna.digitaltest.pages.ChangeSecuritySealPage;
import ar.com.bna.digitaltest.pages.ChangeSecuritySealPageConfirmation;
import ar.com.bna.digitaltest.pages.HomePage;
import ar.com.bna.digitaltest.pages.LoginPage1;
import ar.com.bna.digitaltest.pages.LoginPage2;
import ar.com.bna.digitaltest.pages.SettingsPage;

public class PerfilTest extends BaseTest {

	private SettingsPage settingsPage = null;
	private ChangeSecuritySealPage changeSecuritySealPage = null;
	private ChangeSecuritySealPageConfirmation changeSecuritySealPageConfirmation = null;
	private String imagenOkMessage = null;
	private LoginPage1 loginPage1 = null;
	private LoginPage2 loginPage2 = null;
	private String username;
	private String password;

	@BeforeMethod()
	public void loginAndGoToSettingsPage() {

		imagenOkMessage = super.getTestDataProperties().getProperty("imagenOkMessage");
		username = super.getTestDataProperties().getProperty("validUsername");
		password = super.getTestDataProperties().getProperty("validPassword");
		loginPage1 = super.getPageThread().get().getInstance(LoginPage1.class);
		loginPage1.enterUsername(username);
		loginPage2 = loginPage1.getLoginPage2();
		loginPage2.enterPassword(password);
		HomePage homePage = loginPage2.getHomePage();
		settingsPage = homePage.getSettingsPage();

	}

	@Test(priority = 1)
	public void changeAvatarImage() {

		changeSecuritySealPage = settingsPage.getchangeSecuritySealPage();
		changeSecuritySealPageConfirmation = changeSecuritySealPage.getChangeSecuritySealPageConfirmation();
		changeSecuritySealPageConfirmation.cambiarImagen();
		String imagenSettings = changeSecuritySealPageConfirmation.getIdImagenNueva();
		loginPage1 = settingsPage.getLoginPage1();
		loginPage1.enterUsername(username);
		loginPage2 = loginPage1.getLoginPage2();
		Assert.assertEquals(loginPage2.getImagenActual(), imagenSettings, "La imagen no se modificó");

	}

}
