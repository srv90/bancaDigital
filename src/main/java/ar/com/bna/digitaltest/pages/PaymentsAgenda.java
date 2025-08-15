package ar.com.bna.digitaltest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentsAgenda extends BasePage{
	
	private By nuevoPagoButton = By.id(".payments.newPayment..controls_Plus_Circle.false.span");
	private By nuevoAdhesionButton = By.id(".payments.newAdhesion..controls_Plus_Circle.false.span");

	private By header = By.xpath("//span[normalize-space()='Pagos de impuestos y servicios']");

	public PaymentsAgenda(WebDriver driver) {
		super(driver);
	}

	public String getLoginPageHeader() {
		return super.waitUntilElementIsPresent(header).getText();
	}
	
	public FirstPaymentPage1 getFirstPaymentPage1() {
		super.waitUntilElementIsClickable(nuevoPagoButton).click();
		return super.getInstance(FirstPaymentPage1.class);
	}
	
//	public AddTaxesServicesPage getNuevaAdhesionPage() {
//		super.waitUntilElementIsClickable(nuevoAdhesionButton).click();
//		return super.getInstance(addTaxesServices.class);
//	}
	
}
