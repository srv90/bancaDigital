package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransfersPage extends BasePage{

	private By header = By.xpath("//h1");
    private By transferenciasAliasCbuCVuButton =  By.id("payNow.transfersRequest.cbu.transfersRequest.span");
	
	public TransfersPage(WebDriver driver) {
		super(driver);
	}


	public String getTransfersPageHeader() {
		return super.waitUntilElementIsPresent(header).getText();
	}
	
	public DiaryTransferPage getTransferenciasAliasCbuCVu() {
		super.waitUntilElementIsClickable(transferenciasAliasCbuCVuButton).click();
		return super.getInstance(DiaryTransferPage.class);
		
	}
	
	
	

}
