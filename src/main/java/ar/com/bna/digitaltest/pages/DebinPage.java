package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DebinPage extends BasePage {

	private By header = By.xpath("//h1");
	private By solicitudesButton = By.id("debinSeller-list.card");
	private By gestionesButton = By.id("debinBuyer-listPendings.card");

	public DebinPage(WebDriver driver) {
		super(driver);
	}

	public String getDebinPageHeader() {
		return super.waitUntilElementIsPresent(header).getText();
	}

	public SellerPage getSolicitudesPage() {
		super.waitUntilElementIsClickable(solicitudesButton).click();
		return super.getInstance(SellerPage.class);
	}

	public BuyerPage getGestionesPage() {
		super.waitUntilElementIsClickable(gestionesButton).click();
		return super.getInstance(BuyerPage.class);
	}

}
