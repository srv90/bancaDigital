package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstPaymentPage1 extends BasePage {

	private By header = By.xpath("//span[normalize-space()='Pago de impuestos y servicios']");
	private By continuarButton = By.id("global.continue");
	private By errorMessage = By.xpath("//p[normalize-space()='Este campo es obligatorio.']");
	//private By guardarPagoCheckbox = By.id("checkAddPayment.span");
	private By rubroDropdownButton = By.id("react-select__value-category_category");
	private By rubroDropdownValue;
	private By enteDropdownButton = By.id("entity_entityContainer");
	private By enteDropdownValue;
	private By codigoPagoTextbox = By.id("paymentCode");

	public FirstPaymentPage1(WebDriver driver) {
		super(driver);
	}


	public String getFirstPaymentPage1Header() {
		return super.waitUntilElementIsPresent(header).getText();
	}

	public void click() {
		super.click(continuarButton);
	}

	public FirstPaymentPage2 getFirstPaymentPage2(String rubro, String ente, String codigoPago) {

		this.rubroDropdownValue = By.xpath("//div[contains(text(), '" + rubro + "')]");
		this.enteDropdownValue = By.xpath("//div[contains(text(), '" + ente + "')]");
		super.getWebElement(rubroDropdownButton).click();
		super.waitUntilElementIsClickable(rubroDropdownValue).click();
		super.getWebElement(enteDropdownButton).click();
		super.waitUntilElementIsClickable(enteDropdownValue).click();
		super.getWebElement(codigoPagoTextbox).sendKeys(codigoPago);
		//super.getWebElement(guardarPagoCheckbox).click();
		this.getWebElement(continuarButton).click();
		return super.getInstance(FirstPaymentPage2.class);
	}

	public boolean getErrorMessagesText(String message) {

		return super.getWebElements(errorMessage).stream().allMatch(s -> s.getText().equals(message));

	}

}
