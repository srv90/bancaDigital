package ar.com.bna.digitaltest.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ar.com.bna.digitaltest.pages.FirstPaymentPage2;
import ar.com.bna.digitaltest.pages.HomePage;
import ar.com.bna.digitaltest.pages.LoginPage1;
import ar.com.bna.digitaltest.pages.LoginPage2;
import ar.com.bna.digitaltest.pages.FirstPaymentPage1;
import ar.com.bna.digitaltest.pages.PaymentsAgenda;
import ar.com.bna.digitaltest.pages.PaymentsPage;

public class ConfirmarPagoTest extends BaseTest {

	private String rubro;
	private String ente;
	private String codigoPagoCorrecto;
	private String referencia;
	private String concepto;
	private FirstPaymentPage2 firstPaymentPage2 = null;
	
	@BeforeMethod()
	public void loginAndGoToNuevoPagoPage() {
		rubro = super.getTestDataProperties().getProperty("rubro");
		ente = super.getTestDataProperties().getProperty("ente");
		codigoPagoCorrecto = super.getTestDataProperties().getProperty("codigoPagoCorrecto");
		referencia = super.getTestDataProperties().getProperty("referencia");
		concepto = super.getTestDataProperties().getProperty("concepto");
		LoginPage1 loginPage1 = super.getPageThread().get().getInstance(LoginPage1.class);
		loginPage1.enterUsername(super.getTestDataProperties().getProperty("validUsername"));
		LoginPage2 loginPage2 = loginPage1.getLoginPage2();
		loginPage2.enterPassword(super.getTestDataProperties().getProperty("validPassword"));
		HomePage homePage = loginPage2.getHomePage();
		PaymentsPage pagosPage = homePage.getPagosPage();
		PaymentsAgenda paymentsAgenda = pagosPage.getPaymentsAgendaPage();
		FirstPaymentPage1 firstPaymentPage1 = paymentsAgenda.getFirstPaymentPage1();
		firstPaymentPage2 = firstPaymentPage1.getFirstPaymentPage2(rubro, ente, codigoPagoCorrecto);

	}

	@Test(priority = 1, enabled = false)
	public void verifyTitle() {
		Assert.assertEquals(super.getTestDataProperties().getProperty("title"),
				firstPaymentPage2.getPageTitle());
	}

	@Test(priority = 2, enabled = false)
	public void verifyHeader() {
		Assert.assertEquals("Pago de impuestos y servicios", firstPaymentPage2.getFirstPaymentPage2Header());

	}

	@Test(priority = 3, enabled = false)
	public void enterNoDataAndSubmmit() {
		firstPaymentPage2.click();
		Assert.assertTrue(firstPaymentPage2.getErrorMessagesText(super.getTestDataProperties().getProperty("mandatoryMessage")));

	}

	@Test(priority = 4, enabled = false, description = "Valida que los datos ingresados en la pantalla anterior sean los mismos")
	public void verifyData() {
		Assert.assertTrue(firstPaymentPage2.validarDatos(rubro, ente, codigoPagoCorrecto));

	}


	@Test(priority = 5)
	public void submmitPayment() {

		firstPaymentPage2.generarPago("1000", concepto, referencia);
		
	}
	
	
	
}
