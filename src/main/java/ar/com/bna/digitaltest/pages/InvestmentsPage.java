package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class InvestmentsPage extends BasePage{
	
	private By nuevoPFButton = By.id("fixedTerms-manage_card");
	private By invertirSolapa =  By.xpath("//span[normalize-space()='Invertir']");
	//private By header = By.xpath("//span[normalize-space()='Pagos']");


	public InvestmentsPage(WebDriver driver) {
		super(driver);
	}


	//public String getLoginPageHeader() {
	//	return super.waitUntilElementIsPresent(header).getText();
	//}
	
	public newPFPage getnewPFPage() {
		super.moveToWebElement(invertirSolapa);
		super.waitUntilElementIsClickable(invertirSolapa).click();
		super.moveToWebElement(nuevoPFButton);
		super.waitUntilElementIsClickable(nuevoPFButton).click();
		return super.getInstance(newPFPage.class);
	}
}
