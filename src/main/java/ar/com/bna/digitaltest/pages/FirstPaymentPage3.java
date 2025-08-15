package ar.com.bna.digitaltest.pages;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FirstPaymentPage3 extends BasePage {

	private By header = By.xpath("//span[normalize-space()='Nuevo pago de impuesto y/o servicio']");
	private By confirmarButton = By.id("global.confirm");
	private By errorMessage = By.xpath("//p[normalize-space()='El código ingresado es inválido']");
	private By rubroLabel = By.id("firstPayment.request.category.label");
	private By enteLabel = By.id("firstPayment.request.entity.label");
	private By codigoPagoLabel = By.id("firstPayment.request.paymentCode.label");
	private By conceptoLabel = By.id("firstPayment.request.concept.label");
	private By firstToken = By.xpath("(//div[@class='sc-edKZPI bZSjid line hideValue'])[1]");
	private By tokens = By.id("secondFactor");

	public FirstPaymentPage3(WebDriver driver) {
		super(driver);
	}

	public String getFirstPaymentPage3Header() {
		return super.waitUntilElementIsPresent(header).getText();
	}

	public void click() {
		super.clickWebElement(confirmarButton);
	}

	public boolean validarDatos(String rubro, String ente, String concepto) {

		return super.waitUntilElementIsPresent(rubroLabel).getText().equals(rubro)
				&& super.waitUntilElementIsPresent(enteLabel).getText().equals(ente)
				&& super.waitUntilElementIsPresent(conceptoLabel).getText().equals(concepto);

	}

	public TicketPage ingresarTokenYGenerarPago() {
		
		super.moveToWebElement(confirmarButton);
		super.clickWebElement(firstToken);
	    super.getWebElement(tokens).sendKeys("111111", Keys.ENTER);
	    return super.getInstance(TicketPage.class);
	}
	


	public boolean getErrorMessageText(String message) {

		return super.waitUntilElementIsPresent(errorMessage).getText().equals(message);

	}


}
