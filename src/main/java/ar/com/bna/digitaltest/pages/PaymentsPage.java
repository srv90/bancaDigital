package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentsPage extends BasePage{
	
	private By pagarButton = By.id("payNow.paymentsRequest.payments.taxAndServices.paymentsRequest.span");
	private By header = By.xpath("//span[normalize-space()='Pagos']");
	

	public PaymentsPage(WebDriver driver) {
		super(driver);
	}

	public String getLoginPageHeader() {
		return super.waitUntilElementIsPresent(header).getText();
	}
	
	public PaymentsAgenda getPaymentsAgendaPage() {
		super.waitUntilElementIsClickable(pagarButton).click();
		return super.getInstance(PaymentsAgenda.class);
	}
	
	
	
}
