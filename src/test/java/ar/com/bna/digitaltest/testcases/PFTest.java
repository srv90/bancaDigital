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

	@Test(priority = 1, dataProvider = "dataProvider")
	public void generatePF(String username, String password) {

		LoginPage1 loginPage1 = super.getPageThread().get().getInstance(LoginPage1.class);
		// loginPage1.enterUsername(super.getTestDataProperties().getProperty("validUsername"));
		loginPage1.enterUsername(username);
		LoginPage2 loginPage2 = loginPage1.getLoginPage2();
		loginPage2.enterPassword(password);
		// loginPage2.enterPassword(super.getTestDataProperties().getProperty("validPassword"));
		HomePage homePage = loginPage2.getHomePage();
		investmentsPage = homePage.getInvestmentsPage();
		newPFPage = investmentsPage.getnewPFPage();
		newPFPage2 = newPFPage.getnewPFPage2(importePF, plazoPF);
		comprobantePFPage = newPFPage2.getComprbobantePFPage();
		Assert.assertEquals(mensajePFExitoso, comprobantePFPage.getComprobanteMensaje());

	}

	@DataProvider(parallel = false)
	public Object[][] dataProvider() throws IOException {

		return new Object[][] {  //21 a 27 error usuario

//				{ "pruebaqa117", "Test01xp!" }, { "pruebaqa5", "Test01xp!" }, { "pruebaqa14", "Test01xp!" },
//				{ "pruebaqa0", "Test01xp!" }, { "pruebaqa6", "Test01xp!" }, { "pruebaqa7", "Test01xp!" },
//				{ "pruebaqa8", "Test01xp!" }, { "pruebaqa9", "Test01xp!" }, { "pruebaqa10", "Test01xp!" },
//				{ "pruebaqa11", "Test01xp!" }, { "pruebaqa15", "Test01xp!" }, { "pruebaqa13", "Test01xp!" },
//				{ "pruebaqa15", "Test01xp!" }, { "pruebaqa32", "Test01xp!" }, { "pruebaqa17", "Test01xp!" },
//				{ "pruebaqa18", "Test01xp!" }, { "pruebaqa19", "Test01xp!" }, { "pruebaqa20", "Test01xp!" },
//				{ "pruebaqa22", "Test01xp!" }, 
				/*
				 * { "pruebaqa21", "Test01xp!" }, { "pruebaqa24", "Test01xp!" }, { "pruebaqa31",
				 * "Test01xp!" }, { "pruebaqa30", "Test01xp!" }, { "pruebaqa25", "Test01xp!" },
				 * { "pruebaqa29", "Test01xp!" }, { "pruebaqa26", "Test01xp!" }, { "pruebaqa34",
				 * "Test01xp!" }, { "pruebaqa33", "Test01xp!" }, { "pruebaqa27", "Test01xp!" },
				 */
				{ "pruebaqa66", "Test01xp!" },
//				{ "pruebaqa35", "Test01xp!" }, { "pruebaqa36", "Test01xp!" }, { "pruebaqa37", "Test01xp!" },
//				{ "pruebaqa38", "Test01xp!" }, { "pruebaqa39", "Test01xp!" }, { "pruebaqa40", "Test01xp!" },
//				{ "pruebaqa41", "Test01xp!" }, { "pruebaqa42", "Test01xp!" }, { "pruebaqa43", "Test01xp!" },
//				{ "pruebaqa44", "Test01xp!" }, { "pruebaqa45", "Test01xp!" }, { "pruebaqa46", "Test01xp!" },
//				{ "pruebaqa47", "Test01xp!" }, { "pruebaqa48", "Test01xp!" }, { "pruebaqa50", "Test01xp!" },
//				{ "pruebaqa49", "Test01xp!" }, { "pruebaqa51", "Test01xp!" }, { "pruebaqa52", "Test01xp!" },
//				{ "pruebaqa53", "Test01xp!" }, { "pruebaqa54", "Test01xp!" }, { "pruebaqa55", "Test01xp!" },
//				{ "pruebaqa56", "Banca01xp!" }, { "pruebaqa57", "Test01xp!" }, { "pruebaqa58", "Test01xp!" },
//				{ "pruebaqa59", "Test01xp!" }, { "pruebaqa60", "Test01xp!" }, { "pruebaqa61", "Test01xp!" },
//				{ "pruebaqa62", "Test01xp!" }, { "pruebaqa63", "test01xp!" }, { "pruebaqa64", "Test01xp!" },
//				{ "pruebaqa65", "Test01xp!" }, { "pruebaqa66", "Test01xp!" }, { "pruebaqa67", "Test01xp!" },
//				{ "pruebaqa68", "Test01xp!" }, { "pruebaqa69", "Test01xp!" }, { "pruebaqa70", "Test01xp!" },
//				{ "pruebaqa71", "Test01xp!" }, { "pruebaqa72", "Test01xp!" }, { "pruebaqa73", "Test01xp!" },
//				{ "pruebaqa74", "Test01xp!" }, { "pruebaqa75", "Test01xp!" }, { "pruebaqa76", "Test01xp!" },
//				{ "pruebaqa77", "Test01xp!" }, { "pruebaqa78", "Test01xp!" }, { "pruebaqa79", "Test01xp!" },
//				{ "pruebaqa80", "Test01xp!" }, { "pruebaqa80", "Test01xp!" }, { "pruebaqa82", "Test01xp!" },
//				{ "pruebaqa81", "Test01xp!" }, { "pruebaqa83", "Test01xp!" }, { "pruebaqa84", "Test01xp!" },
//				{ "pruebaqa85", "Test01xp!" }, { "pruebaqa86", "Test01xp!" }, { "pruebaqa87", "Test01xp!" },
//				{ "pruebaqa88", "Test01xp!" }, { "pruebaqa89", "Test01xp!" }, { "pruebaqa90", "Test01xp!" },
//				{ "pruebaqa91", "Test01xp!" }, { "pruebaqa92", "Test01xp!" }, { "pruebaqa93", "Test01xp!" },
//				{ "pruebaqa94", "Test01xp!" }, { "pruebaqa95", "Test01xp!" }, { "pruebaqa96", "Test01xp!" },
//				{ "pruebaqa97", "Test01xp!" }, { "pruebaqa98", "Test01xp!" }, { "pruebaqa99", "Test01xp!" },
//				{ "pruebaqa100", "Test01xp!" }, { "pruebaqa0", "Test01xp!" }, { "pruebaqa101", "Test01xp!" },
//				{ "pruebaqa102", "Test01xp!" }, { "pruebaqa103", "Test01xp!" }, { "pruebaqa104", "Test01xp!" },
//				{ "pruebaqa105", "Test01xp!" }, { "pruebaqa106", "Test01xp!" }, { "pruebaqa107", "Test01xp!" },
//				{ "pruebaqa108", "Test01xp!" }, { "pruebaqa109", "Test01xp!" }, { "pruebaqa110", "Test01xp!" },
//				{ "pruebaqa11I", "Test01xp!" }, { "pruebaqa112", "Test01xp!" }, { "pruebaqa113", "Test01xp!" },
//				{ "pruebaqa114", "Test01xp!" }, { "pruebaqa115", "Test01xp!" }, { "pruebaqa116", "Test01xp!" },
//				{ "pruebaqa117", "Test01xp!" }, { "pruebaqa118", "Test01xp!" }, { "pruebaqa119", "Test01xp!" },
//				{ "pruebaqa120", "Test01xp!" }, { "pruebaqa121", "Test01xp!" }, { "pruebaqa122", "Test01xp!" },
//				{ "pruebaqa12E", "Test01xp!" }, { "pruebaqa124", "Test01xp!" }, { "pruebaqa125", "Test01xp!" },
//				{ "pruebaqa126", "Test01xp!" }, { "pruebaqa127", "Test01xp!" }, { "pruebaqa128", "Test01xp!" },
//				{ "pruebaqa129", "Test01xp!" }, { "pruebaqa130", "Test01xp!" }, { "pruebaqa131", "Test01xp!" },
//				{ "pruebaqa132", "Test01xp!" }, { "pruebaqa133", "Test01xp!" }, { "pruebaqa134", "Test01xp!" },
//				{ "pruebaqa135", "Test01xp!" }, { "pruebaqa136", "Test01xp!" }, { "pruebaqa137", "Test01xp!" },
//				{ "pruebaqa138", "Test01xp!" }, { "pruebaqa139", "Test01xp!" }, { "pruebaqa140", "Test01xp!" },
//				{ "pruebaqa141", "Test01xp!" }, { "pruebaqa142", "Test01xp!" }, { "pruebaqa143", "Test01xp!" },
//				{ "pruebaqa144", "Test01xp!" }, { "pruebaqa145", "Test01xp!" }, { "pruebaqa146", "Test01xp!" },
//				{ "pruebaqa147", "Test01xp!" }, { "pruebaqa148", "Test01xp!" }, { "pruebaqa149", "Test01xp!" },
//				{ "pruebaqa150", "Test01xp!" }, { "pruebaqa151", "Test01xp!" }, { "pruebaqa152", "Test01xp!" },
//				{ "pruebaqa153", "Test01xp!" }, { "pruebaqa154", "Test01xp!" }, { "pruebaqa155", "Test01xp!" },
//				{ "pruebaqa156", "Test01xp!" }, { "pruebaqa157", "Test01xp!" }, { "pruebaqa158", "Test01xp!" },
//				{ "pruebaqa159", "Test01xp!" }, { "pruebaqa160", "Test01xp!" }, { "pruebaqa161", "Test01xp!" },
//				{ "pruebaqa162", "Test01xp!" }, { "pruebaqa163", "Test01xp!" }, { "pruebaqa164", "Test01xp!" },
//				{ "pruebaqa165", "Test01xp!" }, { "pruebaqa166", "Test01xp!" }, { "pruebaqa167", "Test01xp!" },
//				{ "pruebaqa168", "Test01xp!" }, { "pruebaqa169", "Test01xp!" }, { "pruebaqa170", "Test01xp!" },
//				{ "pruebaqa171", "Test01xp!" }, { "pruebaqa172", "Test01xp!" }, { "pruebaqa173", "Test01xp!" },
//				{ "pruebaqa174", "Test01xp!" }, { "pruebaqa175", "Test01xp!" }, { "pruebaqa176", "Test01xp!" },
//				{ "pruebaqa177", "Test01xp!" }, { "pruebaqa178", "Test01xp!" }, { "pruebaqa179", "Test01xp!" },
//				{ "pruebaqa180", "Test01xp!" }, { "pruebaqa181", "Test01xp!" }, { "pruebaqa182", "Test01xp!" },
//				{ "pruebaqa183", "Test01xp!" }, { "pruebaqa184", "Test01xp!" }, { "pruebaqa185", "Test01xp!" },
//				{ "pruebaqa186", "Test01xp!" }, { "pruebaqa187", "Test01xp!" }, { "pruebaqa188", "Test01xp!" },
//				{ "pruebaqa189", "Test01xp!" }, { "pruebaqa190", "Test01xp!" }, { "pruebaqa191", "Test01xp!" },
//				{ "pruebaqa192", "Test01xp!" }, { "pruebaqa193", "Test01xp!" }, { "pruebaqa194", "Test01xp!" },
//				{ "pruebaqa195", "Test01xp!" }, { "pruebaqa196", "Test01xp!" }, { "pruebaqa197", "Test01xp!" },
//				{ "pruebaqa198", "Test01xp!" }, { "pruebaqa199", "Test01xp!" }, { "pruebaqa200", "Test01xp!" },
//				{ "pruebaqa201", "Test01xp!" },
//				{ "BDEMPRE1", "Test00xp!" }, { "BDEMPRE2", "Test00xp!" },
////				{ "BDEMPRE3", "Test00xp!" }, { "BDEMPRE02", "Test00xp!" }, { "BDEMPREK", "Test00xp!" },
////				{ "BDEMPREZ", "Test00xp!" }, { "BDEMPREM", "Test00xp!" }, { "BDEMPREP", "Test00xp!" },
////				{ "BDEMPREK1", "Test00xp!" }, { "BDEMPREG", "Test00xp!" }, { "BDEMPREH", "Test00xp!" },
////				{ "BDEMPREY", "Test00xp!" }, { "BDEMPREPR", "Test00xp!" }, { "BDEMPREAC", "Test00xp!" },
////				{ "BDEMPRET1", "Test00xp!" }, { "BDEMPREMAS16", "Test00xp!" }, { "BDEMPREKK1", "Test00xp!" },
////				{ "BDEMPRE800", "Test00xp!" }, { "BDEMPRE40", "Test00xp!" }, { "BDEMPRENF", "Test00xp!" },
//				{ "bdcar001", "Test01xp!" }, { "bdcar002", "Test01xp!" }, { "bdcar003", "Test01xp!" },
//				{ "bdcar004", "Test01xp!" }, { "bdcar005", "Test01xp!" }, { "bdcar006", "Test01xp!" },
//				{ "bdcar007", "Test01xp!" }, { "bdcar008", "Test01xp!" }, { "bdcar009", "Test01xp!" },
//				{ "bdcar010", "Test01xp!" }, { "bdcar011", "Test01xp!" }, { "bdcar012", "Test01xp!" },
//				{ "bdcar013", "Test01xp!" }, { "bdcar014", "Test01xp!" }, { "bdcar015", "Test01xp!" },
//				{ "bdcar016", "Test01xp!" }, { "bdcar017", "Test01xp!" }, { "bdcar018", "Test01xp!" },
//				{ "bdcar019", "Test01xp!" }, { "bdcar020", "Test01xp!" }, { "bdcar021", "Test01xp!" },
//				{ "bdcar022", "Test01xp!" }, { "bdcar023", "Test01xp!" }, { "bdcar024", "Test01xp!" },
//				{ "bdcar025", "Test01xp!" }, { "bdcar026", "Test01xp!" }, { "bdcar027", "Test01xp!" },
//				{ "bdcar028", "Test01xp!" }, { "bdcar029", "Test01xp!" }, { "bdcar030", "Test01xp!" },
//				{ "bdcar031", "Test01xp!" }, { "bdcar032", "Test01xp!" }, { "bdcar033", "Test01xp!" },
//				{ "bdcar034", "Test01xp!" }, { "bdcar035", "Test01xp!" }, { "bdcar036", "Test01xp!" },
//				{ "bdcar037", "Test01xp!" }, { "bdcar038", "Test01xp!" }, { "bdcar039", "Test01xp!" },
//				{ "bdcar040", "Test01xp!" }, { "bdcar041", "Test01xp!" }, { "bdcar042", "Test01xp!" },
//				{ "bdcar043", "Test01xp!" }, { "bdcar044", "Test01xp!" }, { "bdcar045", "Test01xp!" },
//				{ "bdcar046", "Test01xp!" }, { "bdcar047", "Test01xp!" }, { "bdcar048", "Test01xp!" },
//				{ "bdcar049", "Test01xp!" }, { "bdcar050", "Test01xp!" }, { "bdcar051", "Test01xp!" },
//				{ "bdcar052", "Test01xp!" }, { "bdcar053", "Test01xp!" }, { "bdcar054", "Test01xp!" },
//				{ "bdcar055", "Test01xp!" }, { "bdcar056", "Test01xp!" }, { "bdcar057", "Test01xp!" },
//				{ "bdcar058", "Test01xp!" }, { "bdcar059", "Test01xp!" }, { "bdcar060", "Test01xp!" },
//				{ "bdcar061", "Test01xp!" }, { "bdcar062", "Test01xp!" }, { "bdcar063", "Test01xp!" },
//				{ "bdcar064", "Test01xp!" }, { "bdcar065", "Test01xp!" }, { "bdcar066", "Test01xp!" },
//				{ "bdcar067", "Test01xp!" }, { "bdcar068", "Test01xp!" }, { "bdcar069", "Test01xp!" },
//				{ "bdcar070", "Test01xp!" }, { "bdcar071", "Test01xp!" }, { "bdcar072", "Test01xp!" },
//				{ "bdcar073", "Test01xp!" }, { "bdcar074", "Test01xp!" }, { "bdcar075", "Test01xp!" },
//				{ "bdcar076", "Test01xp!" }, { "bdcar077", "Test01xp!" }, { "bdcar078", "Test01xp!" },
//				{ "bdcar079", "Test01xp!" }, { "bdcar080", "Test01xp!" }, { "bdcar081", "Test01xp!" },
//				{ "bdcar082", "Test01xp!" }, { "bdcar083", "Test01xp!" }, { "bdcar084", "Test01xp!" },
//				{ "bdcar085", "Test01xp!" }, { "bdcar086", "Test01xp!" }, { "bdcar087", "Test01xp!" },
//				{ "bdcar088", "Test01xp!" }, { "bdcar089", "Test01xp!" }, { "bdcar090", "Test01xp!" },
//				{ "bdcar091", "Test01xp!" }, { "bdcar092", "Test01xp!" }, { "bdcar093", "Test01xp!" },
//				{ "bdcar094", "Test01xp!" }, { "bdcar095", "Test01xp!" }, { "bdcar096", "Test01xp!" },
//				{ "bdcar097", "Test01xp!" }, { "bdcar098", "Test01xp!" }, { "bdcar099", "Test01xp!" },
//				{ "bdcar100", "Test01xp!" }, { "bdcar101", "Test01xp!" }, { "bdcar102", "Test01xp!" },
//				{ "bdcar103", "Test01xp!" }, { "bdcar104", "Test01xp!" }, { "bdcar105", "Test01xp!" },
//				{ "bdcar106", "Test01xp!" }, { "bdcar107", "Test01xp!" }, { "bdcar108", "Test01xp!" },
//				{ "bdcar109", "Test01xp!" }, { "bdcar110", "Test01xp!" }, { "bdcar111", "Test01xp!" },
//				{ "bdcar112", "Test01xp!" }, { "bdcar113", "Test01xp!" }, { "bdcar114", "Test01xp!" },
//				{ "bdcar115", "Test01xp!" }, { "bdcar116", "Test01xp!" }, { "bdcar117", "Test01xp!" },
//				{ "bdcar118", "Test01xp!" }, { "bdcar119", "Test01xp!" }, { "bdcar120", "Test01xp!" },
//				{ "bdcar121", "Test01xp!" }, { "bdcar122", "Test01xp!" }, { "bdcar123", "Test01xp!" },
//				{ "bdcar124", "Test01xp!" }, { "bdcar125", "Test01xp!" }, { "bdcar126", "Test01xp!" },
//				{ "bdcar127", "Test01xp!" }, { "bdcar128", "Test01xp!" }, { "bdcar129", "Test01xp!" },
//				{ "bdcar130", "Test01xp!" }, { "bdcar131", "Test01xp!" }, { "bdcar132", "Test01xp!" },
//				{ "bdcar133", "Test01xp!" }, { "bdcar134", "Test01xp!" }, { "bdcar135", "Test01xp!" },
//				{ "bdcar136", "Test01xp!" }, { "bdcar137", "Test01xp!" }, { "bdcar138", "Test01xp!" },
//				{ "bdcar139", "Test01xp!" }, { "bdcar140", "Test01xp!" }, { "bdcar141", "Test01xp!" },
//				{ "bdcar142", "Test01xp!" }, { "bdcar143", "Test01xp!" }, { "bdcar144", "Test01xp!" },
//				{ "bdcar145", "Test01xp!" }, { "bdcar146", "Test01xp!" }, { "bdcar147", "Test01xp!" },
//				{ "bdcar148", "Test01xp!" }, { "bdcar149", "Test01xp!" }, { "bdcar150", "Test01xp!" },
//				{ "bdcar151", "Test01xp!" }, { "bdcar152", "Test01xp!" }, { "bdcar153", "Test01xp!" },
//				{ "bdcar154", "Test01xp!" }, { "bdcar155", "Test01xp!" }, { "bdcar156", "Test01xp!" },
//				{ "bdcar157", "Test01xp!" }, { "bdcar158", "Test01xp!" }, { "bdcar159", "Test01xp!" },
//				{ "bdcar160", "Test01xp!" }, { "bdcar161", "Test01xp!" }, { "bdcar162", "Test01xp!" },
//				{ "bdcar163", "Test01xp!" }, { "bdcar164", "Test01xp!" }, { "bdcar165", "Test01xp!" },
//				{ "bdcar166", "Test01xp!" }, { "bdcar167", "Test01xp!" }, { "bdcar168", "Test01xp!" },
//				{ "bdcar169", "Test01xp!" }, { "bdcar170", "Test01xp!" }, { "bdcar171", "Test01xp!" },
//				{ "bdcar172", "Test01xp!" }, { "bdcar173", "Test01xp!" }, { "bdcar174", "Test01xp!" },
//				{ "bdcar175", "Test01xp!" }, { "bdcar176", "Test01xp!" }, { "bdcar177", "Test01xp!" },
//				{ "bdcar178", "Test01xp!" }, { "bdcar179", "Test01xp!" }, { "bdcar180", "Test01xp!" },
//				{ "bdcar181", "Test01xp!" }, { "bdcar182", "Test01xp!" }, { "bdcar183", "Test01xp!" },
//				{ "bdcar184", "Test01xp!" }, { "bdcar185", "Test01xp!" }, { "bdcar186", "Test01xp!" },
//				{ "bdcar187", "Test01xp!" }, { "bdcar188", "Test01xp!" }, { "bdcar189", "Test01xp!" },
//				{ "bdcar190", "Test01xp!" }, { "bdcar191", "Test01xp!" }, { "bdcar192", "Test01xp!" },
//				{ "bdcar193", "Test01xp!" }, { "bdcar194", "Test01xp!" }, { "bdcar195", "Test01xp!" },
//				{ "bdcar196", "Test01xp!" }, { "bdcar197", "Test01xp!" }, { "bdcar198", "Test01xp!" },
//				{ "bdcar199", "Test01xp!" }, { "bdcar200", "Test01xp!" }

		};

	}

}
