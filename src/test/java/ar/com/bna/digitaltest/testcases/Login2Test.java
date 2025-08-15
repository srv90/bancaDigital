package ar.com.bna.digitaltest.testcases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ar.com.bna.digitaltest.pages.HomePage;
import ar.com.bna.digitaltest.pages.LoginPage1;
import ar.com.bna.digitaltest.pages.LoginPage2;

public class Login2Test extends BaseTest {

	@Test(priority = 1) //, dataProvider = "dataProvider")
	public void enterValidCredentialsAndLogin() { //(String username, String password) {  
		LoginPage1 loginPage1 = super.getPageThread().get().getInstance(LoginPage1.class);
		//loginPage1.enterUsername(username);
		loginPage1.enterUsername(super.getTestDataProperties().getProperty("validUsername"));
		LoginPage2 loginPage2 = loginPage1.getLoginPage2();
	    loginPage2.enterPassword(super.getTestDataProperties().getProperty("validPassword"));
		//loginPage2.enterPassword(password);
		HomePage homePage = loginPage2.getHomePage();
		Assert.assertTrue(homePage.getSaludoCliente().contains("Hola,"));
		//Assert.assertTrue(homePage.getVencimientos(), "El widget 'Próximos vencimientos' no está desplegado");

	}

	@Test(priority = 2)
	public void enterInvalidCredentialsAndLogin() {
		LoginPage1 loginPage1 = super.getPageThread().get().getInstance(LoginPage1.class);
		loginPage1.enterUsername(super.getTestDataProperties().getProperty("invalidUsername"));
		LoginPage2 loginPage2 = loginPage1.getLoginPage2();
		loginPage2.enterPassword(super.getTestDataProperties().getProperty("invalidPassword"));
		loginPage2.getHomePage();
		Assert.assertTrue(loginPage2.alertErrorMessageIsDisplayed(), "El mensaje de error no está desplegado");
		Assert.assertEquals(loginPage2.alertErrorMessageText(),
				super.getTestDataProperties().getProperty("wrongCredentialsMessage"));

	}

//	@DataProvider(parallel = true)
//	public Object[][] dataProvider() throws IOException {
//
//		return new Object[][] {
//
//				{ "pruebaqa101", "Test01xp!" }, { "pruebaqa102", "Test01xp!" }, { "pruebaqa103", "Test01xp!" },
//				{ "pruebaqa104", "Test01xp!" }// , { "pruebaqa8", "Test01xp!" }, { "pruebaqa9", "Test01xp!" },
////				{ "pruebaqa10", "Test01xp!" }, { "pruebaqa11", "Test01xp!" }, { "pruebaqa12", "Test01xp!" },
////				{ "pruebaqa13", "Test01xp!" }, { "pruebaqa14", "Test01xp!" }, { "pruebaqa15", "Test01xp!" },
////				{ "pruebaqa32", "Test01xp!" }, { "pruebaqa17", "Test01xp!" }, { "pruebaqa18", "Test01xp!" },
////				{ "pruebaqa19", "Test01xp!" }, { "pruebaqa20", "Test01xp!" }, { "Adrimen", "Test04xp!" },
////				{ "enzogorlami", "Pruebaqa1!" }, { "maribel25", "Test01xp!" }, { "leamen", "Test03xp!" },
////				{ "cynmen", "Test03xp!" }, { "maribel25", "Test01xp!" }, { "leamen", "Test03xp!" } 
//				};
//
//	}
}
