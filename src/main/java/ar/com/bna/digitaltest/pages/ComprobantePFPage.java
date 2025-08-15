package ar.com.bna.digitaltest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComprobantePFPage extends BasePage {

	private By comprobanteTitulo =  By.id("ticket_title");

	
	public ComprobantePFPage(WebDriver driver) {
		super(driver);
	}

	
	public String getComprobanteMensaje() {
		
		return super.waitUntilElementIsPresent(comprobanteTitulo).getText();
	}
	
}
