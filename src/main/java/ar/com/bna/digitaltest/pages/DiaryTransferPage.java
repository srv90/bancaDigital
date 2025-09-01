package ar.com.bna.digitaltest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ar.com.bna.digitaltest.util.Utilities;

public class DiaryTransferPage extends BasePage {
	
	private By dropDownBtnCuentaOrigen = By.xpath("//div[contains(@id, 'originAccount_originAccountContainer')]");
	private By cuentasOrigen = By.xpath("//span[contains(@aria-label, ' Pesos argentinos ')]");
	private By mainContainer = By.xpath("//main[contains(@id,'mainLayout')]");
	private By todo = By.xpath("//div[contains(@id,'defaultLayoutContent')]");


	private By dropDownBtnCuentaDestino = By.id("recipientAccount_recipientAccountContainer");
	private By txtAmount = By.id("amount");
	private By txtReference = By.id("reference");
	private By dropDownConcept = By.id("react-select__value-concept_concept");
	
	private By btnContinue = By.id("global.continue");
	
	private By inputToken = By.xpath("//input[contains(@id,'secondFactor')]");
	private By btnConfirm = By.id("global.confirm");

	public DiaryTransferPage(WebDriver driver) {
		super(driver);
	}
	
	public void SendTransfer(String importe) {
		
		super.moveToWebElement(dropDownBtnCuentaOrigen);
		super.click(dropDownBtnCuentaOrigen);
		List<WebElement> cuentas = super.getWebElements(this.cuentasOrigen);

		String numeroCuenta = Utilities.getCuenta(cuentas, importe)
				.orElseThrow(() -> new RuntimeException("Ninguna cuenta tiene saldo suficiente para hacer un PF"));
		this.cuentasOrigen = By.xpath("//span[normalize-space()='" + numeroCuenta + "']");
		super.moveToWebElement(cuentasOrigen);
		super.click(this.cuentasOrigen);
		
		super.moveToWebElement(dropDownBtnCuentaDestino);
		super.click(dropDownBtnCuentaDestino);
		super.selectItemFromReactDropDownByIndex(dropDownBtnCuentaDestino,5);
		
		super.moveToWebElement(txtAmount);
		super.click(txtAmount);
		super.getWebElement(txtAmount).sendKeys(importe);
		
		super.moveToWebElement(txtReference);
		super.click(txtReference);
		super.sendKeys(txtReference, "Mito");
		
		super.scrollByElement(super.getWebElement(mainContainer),500);
		super.moveToWebElement(btnContinue);
		super.doubleClickWebElement(btnContinue);
		
		super.moveToWebElement(inputToken);
		super.click(inputToken);
		super.getWebElement(inputToken).sendKeys("111111", Keys.ENTER);
		super.moveToWebElement(btnConfirm);
		super.doubleClickWebElement(btnConfirm);

	}
	
	

}
