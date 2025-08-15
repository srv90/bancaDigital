package ar.com.bna.digitaltest.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ar.com.bna.digitaltest.pages.DebinPage;
import ar.com.bna.digitaltest.pages.HomePage;
import ar.com.bna.digitaltest.pages.LoginPage1;
import ar.com.bna.digitaltest.pages.LoginPage2;
import ar.com.bna.digitaltest.pages.SellerGeneratePage;
import ar.com.bna.digitaltest.pages.SellerPage;
import ar.com.bna.digitaltest.pages.TicketPage;

public class DebinTest extends BaseTest {

	private DebinPage debinPage = null;
	private SellerPage sellerPage = null;
	private SellerGeneratePage sellerGeneratePage = null;
	private String aliasUsd;
	private String aliasPesos;
	private String importeDebin;
	private String importeDebinUSD;
	private String horaExpiracion;
	private String ticketOkMensaje;
	private TicketPage ticketPage = null;
	private String moneda;
	private String alias;

	@BeforeMethod()
	public void loginAndGoToNuevoPagoPage() {
		aliasPesos = super.getTestDataProperties().getProperty("aliasPesos");
		aliasUsd = super.getTestDataProperties().getProperty("aliasUsd");
		importeDebin = super.getTestDataProperties().getProperty("importeDebin");
		importeDebin = super.getTestDataProperties().getProperty("importeDebinUsd");
		horaExpiracion = super.getTestDataProperties().getProperty("horaExpiracion");
		ticketOkMensaje = super.getTestDataProperties().getProperty("ticketOkMessageDebin");
		LoginPage1 loginPage1 = super.getPageThread().get().getInstance(LoginPage1.class);
		loginPage1.enterUsername(super.getTestDataProperties().getProperty("validUsername"));
		LoginPage2 loginPage2 = loginPage1.getLoginPage2();
		loginPage2.enterPassword(super.getTestDataProperties().getProperty("validPassword"));
		HomePage homePage = loginPage2.getHomePage();
		debinPage = homePage.getDebinPage();

	}

	@Test(priority = 1, enabled = false)
	public void verifyTitle() {
		Assert.assertEquals(super.getTestDataProperties().getProperty("title"), debinPage.getPageTitle());
	}

	@Test(priority = 2, enabled = false)
	public void verifyHeader() {
		Assert.assertEquals("DEBIN", debinPage.getDebinPageHeader());

	}

	@Test(priority = 3, dataProvider = "debinData")
	public void generateDebin(int moneda, String importe) {

		boolean recurrencia = false;

		getMonedaYAlias(moneda);
		sellerPage = debinPage.getSolicitudesPage();
		sellerGeneratePage = sellerPage.getOrdenDebinPage();
		ticketPage = sellerGeneratePage.generarDebin(importe, alias, horaExpiracion, recurrencia, this.moneda);
		String okMessageTicket = ticketPage.getMessageText();
		String importeTicket = ticketPage.getImporte();
		Assert.assertEquals(okMessageTicket, ticketOkMensaje);
		// Assert.assertEquals(importeTicket, importeDebin);

	}

	@Test(priority = 4, dataProvider = "debinData")

	public void generateDebinRecurrente(int moneda, String importe) {

		boolean recurrencia = true;
		getMonedaYAlias(moneda);
		sellerPage = debinPage.getSolicitudesPage();
		sellerGeneratePage = sellerPage.getOrdenDebinPage();
		ticketPage = sellerGeneratePage.generarDebin(importe, alias, horaExpiracion, recurrencia, this.moneda);
		String okMessageTicket = ticketPage.getMessageText();
		String importeTicket = ticketPage.getImporte();
		Assert.assertEquals(okMessageTicket, ticketOkMensaje);
		// Assert.assertEquals(importeTicket, importeDebin);

	}

	@DataProvider
	public static Object[][] debinData() {

		return new Object[][] { { 1, "1" }, { 2, "1" } };

	}

	private void getMonedaYAlias(int moneda) {
		if (moneda == 1) {
			this.moneda = "Pesos";
			this.alias = aliasPesos;
		} else {
			this.moneda = "USD";
			this.alias = aliasUsd;
		}
	}
}
