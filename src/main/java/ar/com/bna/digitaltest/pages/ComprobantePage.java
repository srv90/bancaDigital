package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComprobantePage extends BasePage {

	private By rubroLabel = By.xpath("//p[normalize-space()='Cobranzas para Empresas y Comercios']");
	private By enteLabel = By.xpath("//p[normalize-space()='Mercado Libre']");
	private By referenciaALabel = By.xpath("//p[normalize-space()='0044953569']");
	private By importeLabel = By.xpath("(//p[@role])[1]");
	private By aliasLabel = null;
	


	public ComprobantePage(WebDriver driver) {
		super(driver);
	}

	public boolean validarDatosTransferencia(String rubro, String ente, String referencia, String importe) {

		return super.waitUntilElementIsPresent(rubroLabel).getText().equals(rubro)
				&& super.waitUntilElementIsPresent(enteLabel).getText().equals(ente)
				&& super.waitUntilElementIsPresent(referenciaALabel).getText().equals(referencia)
				&& super.waitUntilElementIsPresent(importeLabel).getText().equals(importe);

	}
	
//	public boolean validarDatosDebin(String alias, String ente, String referencia, String importe) {
//
//		aliasLabel = By.xpath("(//p[normalize-space()='" + alias +"']");
//		return super.waitUntilElementIsPresent(aliasLabel).getText().equals(alias)
//				&& super.waitUntilElementIsPresent(enteLabel).getText().equals(ente)
//				&& super.waitUntilElementIsPresent(referenciaALabel).getText().equals(referencia)
//				&& super.waitUntilElementIsPresent(importeLabel).getText().equals(importe);
//
//	}

}
