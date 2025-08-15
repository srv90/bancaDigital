package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SellerPage extends BasePage {

	private By header = By.xpath("//h1");
	private By nuevoDebinButton = By.id("debin.seller.new.button.label");
	private By eliminarDebinButton = By.id("global.delete");

	
	public SellerPage(WebDriver driver) {
		super(driver);
	}
	
	//falta header
	
	public SellerGeneratePage getOrdenDebinPage() {
		super.scrollToBottom();
		//super.moveToWebElement(nuevoDebinButton);
		super.waitUntilElementIsClickable(nuevoDebinButton).click();
		return super.getInstance(SellerGeneratePage.class);
		
	}
	
	

}
