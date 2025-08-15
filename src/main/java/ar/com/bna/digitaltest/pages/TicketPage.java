package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TicketPage extends BasePage {

	private By ticketMessage = By.xpath("//h1[@id='ticket_title']");
	private By importe = By.xpath("//p[@id='ticket_title']");
	private By comprobanteButton = By.id(".movements.voucherNumber.title.label..file_file.false.span");

	public TicketPage(WebDriver driver) {
		super(driver);
	}

	public String getMessageText() {

		return super.waitUntilElementIsPresent(ticketMessage).getText();

	}

	public String getImporte() {
		return super.waitUntilElementIsPresent(importe).getText();
	}

	public ComprobantePage getComprobantePage() {
		super.waitUntilElementIsClickable(comprobanteButton).click();
		return super.getInstance(ComprobantePage.class);
	}
	

}
