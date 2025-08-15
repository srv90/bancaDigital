package ar.com.bna.digitaltest.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ar.com.bna.digitaltest.pages.FirstPaymentPage2;
import ar.com.bna.digitaltest.pages.FirstPaymentPage3;
import ar.com.bna.digitaltest.pages.HomePage;
import ar.com.bna.digitaltest.pages.LoginPage1;
import ar.com.bna.digitaltest.pages.LoginPage2;
import ar.com.bna.digitaltest.pages.ComprobantePage;
import ar.com.bna.digitaltest.pages.FirstPaymentPage1;
import ar.com.bna.digitaltest.pages.PaymentsAgenda;
import ar.com.bna.digitaltest.pages.PaymentsPage;
import ar.com.bna.digitaltest.pages.TicketPage;

public class ConfirmarPagoTokenTest extends BaseTest {

	private String rubro;
	private String ente;
	private String codigoPagoIncorrecto;
	private String codigoPagoCorrecto;
	private String concepto;
	private String importeTransferencia;
	private String referencia;
	private String errorMessage;
	private String okMessage;
	private FirstPaymentPage1 firstPaymentPage1 = null;
	private FirstPaymentPage2 firstPaymentPage2 = null;
	private FirstPaymentPage3 firstPaymentPage3 = null;
	private TicketPage ticketPage = null;
	private ComprobantePage comprobantePage = null;

	@BeforeMethod()
	public void loginAndGoToNuevoPagoPage() {
		rubro = super.getTestDataProperties().getProperty("rubro");
		ente = super.getTestDataProperties().getProperty("ente");
		concepto = super.getTestDataProperties().getProperty("concepto");
		importeTransferencia = super.getTestDataProperties().getProperty("importeTransferencia");
		referencia = super.getTestDataProperties().getProperty("referencia");
		codigoPagoIncorrecto = super.getTestDataProperties().getProperty("codigoPagoIncorrecto");
		codigoPagoCorrecto = super.getTestDataProperties().getProperty("codigoPagoCorrecto");
		errorMessage = super.getTestDataProperties().getProperty("ticketErrorMessage");
		okMessage = super.getTestDataProperties().getProperty("ticketOkMessage");
		LoginPage1 loginPage1 = super.getPageThread().get().getInstance(LoginPage1.class);
		loginPage1.enterUsername(super.getTestDataProperties().getProperty("validUsername"));
		LoginPage2 loginPage2 = loginPage1.getLoginPage2();
		loginPage2.enterPassword(super.getTestDataProperties().getProperty("validPassword"));
		HomePage homePage = loginPage2.getHomePage();
		PaymentsPage pagosPage = homePage.getPagosPage();
		PaymentsAgenda paymentsAgenda = pagosPage.getPaymentsAgendaPage();
		firstPaymentPage1 = paymentsAgenda.getFirstPaymentPage1();

	}

	@Test(priority = 1, enabled = false)
	public void verifyTitle() {

		firstPaymentPage2 = firstPaymentPage1.getFirstPaymentPage2(rubro, ente, codigoPagoIncorrecto);
		firstPaymentPage3 = firstPaymentPage2.generarPago("1000", concepto, referencia);
		Assert.assertEquals(super.getTestDataProperties().getProperty("title"), firstPaymentPage3.getPageTitle());
	}

	@Test(priority = 2, enabled = false)
	public void verifyHeader() {
		firstPaymentPage2 = firstPaymentPage1.getFirstPaymentPage2(rubro, ente, codigoPagoIncorrecto);
		firstPaymentPage3 = firstPaymentPage2.generarPago("1000", concepto, referencia);
		Assert.assertEquals("Nuevo pago de impuesto y/o servicio", firstPaymentPage3.getFirstPaymentPage3Header());

	}

	@Test(priority = 3, enabled = false)
	public void enterNoTokenAndSubmmit() {
		firstPaymentPage2 = firstPaymentPage1.getFirstPaymentPage2(rubro, ente, codigoPagoIncorrecto);
		firstPaymentPage3 = firstPaymentPage2.generarPago("1000", concepto, referencia);
		firstPaymentPage3.click();
		Assert.assertTrue(firstPaymentPage3.getErrorMessageText(super.getTestDataProperties().getProperty("tokenMessage")));

	}

	@Test(priority = 4, enabled = false, description = "Valida que los datos ingresados en la pantalla anterior sean los mismos")
	public void verifyData() {
		firstPaymentPage2 = firstPaymentPage1.getFirstPaymentPage2(rubro, ente, codigoPagoIncorrecto);
		firstPaymentPage3 = firstPaymentPage2.generarPago("1000", concepto, referencia);
		Assert.assertTrue(firstPaymentPage3.validarDatos(rubro, ente, concepto));

	}

	@Test(priority = 5)
	public void enterTokenAndSubmmitWrongPayment() {

		firstPaymentPage2 = firstPaymentPage1.getFirstPaymentPage2(rubro, ente, codigoPagoIncorrecto);
		firstPaymentPage3 = firstPaymentPage2.generarPago("1000", concepto, referencia);
		ticketPage = firstPaymentPage3.ingresarTokenYGenerarPago();
		String errorMessageTicket = ticketPage.getMessageText();
		String importeTicket = ticketPage.getImporte();
		comprobantePage = ticketPage.getComprobantePage();
		Assert.assertEquals(errorMessageTicket, errorMessage, "Los mensajes no coinciden");
		Assert.assertEquals(importeTicket, importeTransferencia);
		Assert.assertTrue(comprobantePage.validarDatosTransferencia(rubro, ente, referencia, importeTransferencia),"Los datos del comprobante no coinciden");

	}

	@Test(priority = 6)
	public void enterTokenAndSubmmitCorrectPayment() {
		firstPaymentPage2 = firstPaymentPage1.getFirstPaymentPage2(rubro, ente, codigoPagoCorrecto);
		firstPaymentPage3 = firstPaymentPage2.generarPago("1000", concepto, referencia);
		ticketPage = firstPaymentPage3.ingresarTokenYGenerarPago();
		String okMessageTicket = ticketPage.getMessageText();
		String importeTicket = ticketPage.getImporte();
		comprobantePage = ticketPage.getComprobantePage();
		Assert.assertEquals(okMessageTicket, okMessage);
		Assert.assertEquals(importeTicket, importeTransferencia);
		Assert.assertTrue(comprobantePage.validarDatosTransferencia(rubro, ente, referencia, importeTransferencia),"Los datos del comprobante no coinciden");

	}

}
