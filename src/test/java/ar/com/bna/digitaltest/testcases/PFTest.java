package ar.com.bna.digitaltest.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ar.com.bna.digitaltest.pages.ComprobantePFPage;
import ar.com.bna.digitaltest.pages.DebinPage;
import ar.com.bna.digitaltest.pages.HomePage;
import ar.com.bna.digitaltest.pages.InvestmentsPage;
import ar.com.bna.digitaltest.pages.LoginPage1;
import ar.com.bna.digitaltest.pages.LoginPage2;
import ar.com.bna.digitaltest.pages.SellerGeneratePage;
import ar.com.bna.digitaltest.pages.SellerPage;
import ar.com.bna.digitaltest.pages.TicketPage;
import ar.com.bna.digitaltest.pages.newPFPage;
import ar.com.bna.digitaltest.pages.newPFPage2;

public class PFTest extends BaseTest {

	private String importePF;
	private String plazoPF;
	private String mensajePFExitoso;
	private InvestmentsPage investmentsPage = null;
	private newPFPage newPFPage = null;
	private newPFPage2 newPFPage2 = null;
	private ComprobantePFPage comprobantePFPage = null;

	@BeforeMethod()
	public void loginAndGoToInvestmentsPage() {
		importePF = super.getTestDataProperties().getProperty("importePF");
		plazoPF = super.getTestDataProperties().getProperty("plazoPF");
		mensajePFExitoso = super.getTestDataProperties().getProperty("mensajePFExitoso");

	}

	@Test(priority = 1)
	public void generatePF() {

		LoginPage1 loginPage1 = super.getPageThread().get().getInstance(LoginPage1.class);
		loginPage1.enterUsername(super.getTestDataProperties().getProperty("validUsername"));
		LoginPage2 loginPage2 = loginPage1.getLoginPage2();
		loginPage2.enterPassword(super.getTestDataProperties().getProperty("validPassword"));
		HomePage homePage = loginPage2.getHomePage();
		investmentsPage = homePage.getInvestmentsPage();
		newPFPage = investmentsPage.getnewPFPage();
		newPFPage2 = newPFPage.getnewPFPage2(importePF, plazoPF);
		comprobantePFPage = newPFPage2.getComprbobantePFPage();
		Assert.assertEquals(mensajePFExitoso, comprobantePFPage.getComprobanteMensaje());

	}


}