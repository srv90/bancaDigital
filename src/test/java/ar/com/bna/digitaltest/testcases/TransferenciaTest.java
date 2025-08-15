package ar.com.bna.digitaltest.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ar.com.bna.digitaltest.pages.HomePage;
import ar.com.bna.digitaltest.pages.LoginPage1;
import ar.com.bna.digitaltest.pages.LoginPage2;
import ar.com.bna.digitaltest.pages.TransfersPage;

public class TransferenciaTest extends BaseTest {

	private TransfersPage transfersPage =  null;
	
	@BeforeMethod()
	public void loginAndGoToNuevoPagoPage() {
		LoginPage1 loginPage1 = super.getPageThread().get().getInstance(LoginPage1.class);
		loginPage1.enterUsername(super.getTestDataProperties().getProperty("validUsername"));
		LoginPage2 loginPage2 = loginPage1.getLoginPage2();
		loginPage2.enterPassword(super.getTestDataProperties().getProperty("validPassword"));
		HomePage homePage = loginPage2.getHomePage();
		transfersPage = homePage.getTransferenciasPage();

	}

	@Test(priority = 1)
	public void verifyTitle() {
		Assert.assertEquals("Home banking",transfersPage.getPageTitle());
	}

	@Test(priority = 2)
	public void verifyHeader() {
		Assert.assertEquals("Transferencias",transfersPage.getTransfersPageHeader());

	}

}
