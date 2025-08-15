package ar.com.bna.digitaltest.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ar.com.bna.digitaltest.pages.HomePage;
import ar.com.bna.digitaltest.pages.LoginPage1;
import ar.com.bna.digitaltest.pages.LoginPage2;
import ar.com.bna.digitaltest.pages.FirstPaymentPage1;
import ar.com.bna.digitaltest.pages.PaymentsAgenda;
import ar.com.bna.digitaltest.pages.PaymentsPage;

public class NuevoPagoTest extends BaseTest {

	private FirstPaymentPage1 firstPaymentPage1 = null;
	
	@BeforeMethod()
	public void loginAndGoToNuevoPagoPage() {
		LoginPage1 loginPage1 = super.getPageThread().get().getInstance(LoginPage1.class);
		loginPage1.enterUsername(super.getTestDataProperties().getProperty("validUsername"));
		LoginPage2 loginPage2 = loginPage1.getLoginPage2();
		loginPage2.enterPassword(super.getTestDataProperties().getProperty("validPassword"));
		HomePage homePage = loginPage2.getHomePage();
		PaymentsPage pagosPage = homePage.getPagosPage();
	 	PaymentsAgenda paymentsAgenda = pagosPage.getPaymentsAgendaPage();
		firstPaymentPage1 = paymentsAgenda.getFirstPaymentPage1();
		
	}
	

	@Test(priority = 1)
	public void verifyTitle() {
		Assert.assertEquals(super.getTestDataProperties().getProperty("title"), firstPaymentPage1.getPageTitle());
	}

	@Test(priority = 2)
	public void verifyHeader() {
		Assert.assertEquals("Pago de impuestos y servicios", firstPaymentPage1.getFirstPaymentPage1Header());

	}
	
	@Test(priority = 3)
	public void enterNoDataAndSubmmit() {
		//firstPaymentPage1.selectCheckbox();
		firstPaymentPage1.click();
		Assert.assertTrue(firstPaymentPage1.getErrorMessagesText(super.getTestDataProperties().getProperty("mandatoryMessage")));

	}
	
	

	
	
	
}
