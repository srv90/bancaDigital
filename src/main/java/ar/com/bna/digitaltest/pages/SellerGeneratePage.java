package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SellerGeneratePage extends BasePage {

	private By header = By.xpath("//h1");
	private By prestacionUsd = By.xpath("//div[normalize-space()='usdDebin']");
	private By prestacionPesos = By.xpath("//div[normalize-space()='pruebapesos']");
	private By recurrenciaCheckbox = By.id("recurring");
	private By prestacionesCombobox = By.xpath("//div[@id='react-select__value-entitlement_entitlement']");
	private By cuentaCreditoCombobox = By.xpath("//div[@id='react-select__value-accountSelector_accountSelector']");
	//private By cuentaCreditoUsd = By.xpath("//span[normalize-space()='CCE U$S 00700170285542']"); // 00700170288299 00700170285542 11301300027942
	//private By cuentaCreditoPesos = By.xpath("//span[normalize-space()='CC $ 00700170604733']"); 
	private By cuentaCreditoUsd = By.xpath("//div[normalize-space()='CUENTAS CORRIENTES ESPECIALES DOLAR 0170285542']"); // 00700170288299 00700170285542 11301300027942
	private By cuentaCreditoPesos = By.xpath("//div[normalize-space()='CUENTA CORRIENTES PESOS 0170604733']");
	private By aliasCBU = By.id("aliasCbu");
	private By cbucvu = By.cssSelector("//p[normalize-space()='CBU/CVU']");
	private By importe = By.id("amount");
	private By horaExpiracion = By.id("validityTime");
	private By checkboxTyC = By.id("agreement.span");
	private By modalTexto = By.id("agreement_modal_scroll");
	private By modalAceptarButton = By.id("termsAndConditions.component.aceptar.label");
	private By continuarButton = By.id("global.continue");
	private By guardarPlantillaButton = By.id("global.save.template");
	private By confirmarButton = By.id("global.confirm");
	private By tokens = By.id("secondFactor");
	private By comprobanteButton = By.id(".movements.voucherNumber.title.label..file_file.false.span");

	public SellerGeneratePage(WebDriver driver) {
		super(driver);
	}

	public TicketPage generarDebin(String importe, String aliasCBU, String horaExpiracion, boolean recurrencia,
			String moneda) {

		super.moveToWebElement(guardarPlantillaButton);

		if (recurrencia) {
			super.waitUntilElementIsClickable(recurrenciaCheckbox).click();
			super.waitUntilElementIsClickable(prestacionesCombobox).click();
			if (moneda.equalsIgnoreCase("USD")) {
				super.waitUntilElementIsClickable(prestacionUsd).click();
			} else {
				super.waitUntilElementIsClickable(prestacionPesos).click();
			}

		}

		super.waitUntilElementIsClickable(cuentaCreditoCombobox).click();

		if (moneda.equalsIgnoreCase("USD")) {
			super.waitUntilElementIsPresent(cuentaCreditoUsd).click();
		} else {
			super.waitUntilElementIsPresent(cuentaCreditoPesos).click();

		}

		super.doubleClickWebElement(this.importe);
		super.getWebElement(this.importe).sendKeys(importe);
		super.getWebElement(this.aliasCBU).sendKeys(aliasCBU);
		super.getWebElement(this.horaExpiracion).sendKeys(horaExpiracion, Keys.TAB, Keys.SPACE);
		super.waitUntilElementIsPresent(modalTexto).click();
		super.waitUntilElementIsPresent(modalTexto).sendKeys(Keys.END);
		super.waitUntilElementIsClickable(modalAceptarButton).click();
		super.moveToWebElement(continuarButton);
		super.getWebElement(continuarButton).click();
		super.moveToWebElement(confirmarButton);
		super.getWebElement(tokens).sendKeys("111111", Keys.ENTER);

		return super.getInstance(TicketPage.class);
	}

	public ComprobantePage getComprobantePage() {
		super.waitUntilElementIsClickable(comprobanteButton).click();
		return super.getInstance(ComprobantePage.class);
	}

}
