package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTaxesServicesPage extends BasePage {
	
	private By header = By.xpath("//span[normalize-space()='Nueva adhesión']");
	private By agregarButton = By.id("global.add");
	private By continuarButton = By.id("global.continue");
	private By errorMessage = By.xpath("//p[normalize-space()='Este campo es obligatorio.']");
	private By rubroDropdownButton = By.id("react-select__value-category_category");
	private By rubroDropdownValue;
	private By enteDropdownButton = By.id("entity_entityContainer");
	private By enteDropdownValue;
	private By codigoPagoTextbox = By.id("paymentCode");


	public AddTaxesServicesPage(WebDriver driver) {
		super(driver);
	}

	public String getAddTaxesServicesPageHeader() {
		return super.waitUntilElementIsPresent(header).getText();
	}


	public void getNewPaymentData(String rubro, String ente, String codigoPago) {

		this.rubroDropdownValue = By.xpath("//div[contains(text(), '" + rubro + "')]");
		this.enteDropdownValue = By.xpath("//div[contains(text(), '" + ente + "')]");
		super.getWebElement(rubroDropdownButton).click();
		super.waitUntilElementIsClickable(rubroDropdownValue).click();
		super.getWebElement(enteDropdownButton).click();
		super.waitUntilElementIsClickable(enteDropdownValue).click();
		super.getWebElement(codigoPagoTextbox).sendKeys(codigoPago);
		this.getWebElement(agregarButton).click();
		
		
	}
	
	

	
	
	
}
