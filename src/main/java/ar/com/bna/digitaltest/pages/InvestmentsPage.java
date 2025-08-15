package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvestmentsPage extends BasePage {

	private By nuevoPFButton = By.id("investmentRetail.landing.button.newFixedTerm");
	// private By header = By.xpath("//span[normalize-space()='Pagos']");

	public InvestmentsPage(WebDriver driver) {
		super(driver);
	}

	// public String getLoginPageHeader() {
	// return super.waitUntilElementIsPresent(header).getText();
	// }

	public newPFPage getnewPFPage() {
		super.moveToWebElement(nuevoPFButton);
		super.waitUntilElementIsClickable(nuevoPFButton).click();
		return super.getInstance(newPFPage.class);
	}
}

 
