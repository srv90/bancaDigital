package ar.com.bna.digitaltest.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ar.com.bna.digitaltest.util.Utilities;

public class FirstPaymentPage2 extends BasePage {

	private By header = By.xpath("//span[normalize-space()='Pago de impuestos y servicios']");
	private By continuarButton = By.xpath("//button[@type='submit']");
	private By errorMessage = By.xpath("//p[normalize-space()='Este campo es obligatorio.']");
	private By conceptoButton = By.id("concept_conceptContainer");
	private By conceptoCombobox = By.xpath("//div[contains(text(),'MPAGO COMPRA')]");
	private By importeTextbox = By.id("amount");
	private By rubroLabel = By.id("firstPayment.request.category.label");
	private By enteLabel = By.id("firstPayment.request.entity.label");
	private By codigoPagoLabel = By.id("firstPayment.request.paymentCode.label");
	private By perteneceALabel = By.id("firstPayment.request.belongsTo.label");
	private By cuentas = By.xpath("//span[contains(@aria-label, ' Pesos argentinos ')]");
	private By cuentaDebitoCombobox = By.id("debitAccount_debitAccountContainer");
	private By referenciaTextbox = By.id("reference");

	private By cuenta = null;

	public FirstPaymentPage2(WebDriver driver) {
		super(driver);
	}

	public String getFirstPaymentPage2Header() {
		return super.waitUntilElementIsPresent(header).getText();
	}

	public boolean validarDatos(String rubro, String ente, String codigoPago) {

		return super.waitUntilElementIsPresent(rubroLabel).getText().equals(rubro)
				&& super.waitUntilElementIsPresent(enteLabel).getText().equals(ente)
				&& super.waitUntilElementIsPresent(codigoPagoLabel).getText().equals(codigoPago);
	}

	public void click() {
		super.clickWebElement(continuarButton);
	}

	public FirstPaymentPage3 generarPago(String importe, String concepto, String referencia) {

		super.moveToWebElement(this.continuarButton);
		super.waitUntilElementIsClickable(cuentaDebitoCombobox).click();
		List<WebElement> cuentas = super.getWebElements(this.cuentas);
		String numeroCuenta = Utilities.getCuenta(cuentas, importe).orElseThrow(
				() -> new RuntimeException("Ninguna cuenta tiene saldo suficiente para hacer la transacción."));
		this.cuenta = By.xpath("//span[normalize-space()='" + numeroCuenta + "']");
		super.moveToWebElement(cuenta);
		super.waitUntilElementIsClickable(this.cuenta).click();
		super.waitUntilElementIsClickable(conceptoButton).click();
		super.waitUntilElementIsPresent(conceptoCombobox).click();
		super.getWebElement(referenciaTextbox).sendKeys(referencia);
		super.doubleClickWebElement(importeTextbox);
		super.getWebElement(importeTextbox).sendKeys(importe);
		super.clickWebElement(continuarButton);
		return super.getInstance(FirstPaymentPage3.class);
	}

	public boolean getErrorMessagesText(String message) {

		return super.getWebElements(errorMessage).stream().allMatch(s -> s.getText().equals(message));

	}

}
