package ar.com.bna.digitaltest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ar.com.bna.digitaltest.util.Utilities;

public class newPFPage extends BasePage {

	private By importe = By.id("amount");
	private By cuentaOrigenCombobox = By.xpath("//div[@id='react-select__value-account_account']");
	private By cuentas = By.xpath("//span[contains(@aria-label, ' Pesos argentinos ')]");
	private By cuenta = null;
	private By tipoPFCombobox = By.id("fixedTermType_fixedTermTypeContainer");
	private By tipoPF = By.xpath("//div[normalize-space()='Plazo Fijo Tradicional']");
	private By tipoRenovacionCombobox = By.id("react-select__value-endOfTermAction_endOfTermAction");
	private By tipoRenovacion = By.xpath("//div[normalize-space()='Sin renovación (Acreditación al vencimiento)']");
	private By plazo = By.id("term");
	private By continuarButton = By.id("global.continue");

	public newPFPage(WebDriver driver) {
		super(driver);
	}

	public newPFPage2 getnewPFPage2(String importe, String plazo) {

		super.doubleClickWebElement(this.importe);
		super.getWebElement(this.importe).sendKeys(importe);
		super.getWebElement(cuentaOrigenCombobox).click();
		List<WebElement> cuentas = super.getWebElements(this.cuentas);
		String numeroCuenta = Utilities.getCuenta(cuentas, importe).orElseThrow(() -> new RuntimeException("Ninguna cuenta tiene saldo suficiente para hacer un PF"));
		this.cuenta = By.xpath("//span[normalize-space()='" + numeroCuenta + "']");
		super.moveToWebElement(cuenta);
		super.click(this.cuenta);
		super.waitUntilElementIsClickable(tipoPFCombobox).click();
		super.moveToWebElement(tipoPF);
		super.waitUntilElementIsPresent(tipoPF).click();
		super.waitUntilElementIsClickable(tipoRenovacionCombobox).click();
		super.waitUntilElementIsPresent(tipoRenovacion).click();
		super.getWebElement(this.plazo).sendKeys(plazo);
		super.moveToWebElement(continuarButton);
		super.getWebElement(continuarButton).click();
		return super.getInstance(newPFPage2.class);
	}

}
