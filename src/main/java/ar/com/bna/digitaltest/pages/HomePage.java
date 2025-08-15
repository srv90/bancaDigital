package ar.com.bna.digitaltest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	private By saludoCliente = By.xpath("//span[starts-with(text(),'Hola,')]");
	private By misCuentasEmpresa = By.xpath("//p[normalize-space()='Saldo global']");
	private By misCuentasIndividuo = By.xpath("//p[normalize-space()='Caja de Ahorro']");
	private By pagosButton = By.id("channels.payments.button");
	private By transferenciasButton = By.id("menu.diaryTransfer.button");
	private By debinButton = By.id("menu.debin.button");
	private By vencimientos = By.xpath("(//div[@class='sc-cbelJu itLWeV'])[3]");
	private By inversionesButton = By.xpath("//span[normalize-space()='Invertir']");
	// private By inversionesButton = By.id("menu.INVESTMENTS.button");
	private By instagramButton = By.xpath("//button[@class='sc-fqkvVR sc-iGgWBj dKdTHM ugwH sc-fifgRP cjbiky']");
	private By instagramModal = By.id("modal-content");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String getSaludoCliente() {
		return super.waitUntilElementIsPresent(saludoCliente).getText();
	}

	public boolean getCuentasClienteEmpresa() {
		return super.waitUntilElementIsPresent(misCuentasEmpresa).isDisplayed();
	}

	public boolean getCuentasClienteIndividuo() {
		return super.waitUntilElementIsPresent(misCuentasIndividuo).isDisplayed();
	}

	public boolean getVencimientos() {
		return super.waitUntilElementIsPresent(vencimientos).isDisplayed();
	}

	public PaymentsPage getPagosPage() {
		this.getCuentasClienteEmpresa();
		super.moveToWebElement(pagosButton);
		super.waitUntilElementIsClickable(pagosButton).click();
		return super.getInstance(PaymentsPage.class);
	}

	public TransfersPage getTransferenciasPage() {
		this.getCuentasClienteEmpresa();
		super.moveToWebElement(transferenciasButton);
		super.waitUntilElementIsClickable(transferenciasButton).click();
		return super.getInstance(TransfersPage.class);
	}

	public DebinPage getDebinPage() {
		this.getCuentasClienteEmpresa();
		super.clickWebElement(debinButton);
		return super.getInstance(DebinPage.class);
	}

	public InvestmentsPage getInvestmentsPage() {

		this.getCuentasClienteIndividuo();

		if (super.existsElement(instagramModal) > 0) {

			super.waitUntilElementIsPresent(instagramModal).findElement(instagramButton).click();

		}

		super.moveToWebElement(inversionesButton);
		super.waitUntilElementIsClickable(inversionesButton).click();
		return super.getInstance(InvestmentsPage.class);

	}

}