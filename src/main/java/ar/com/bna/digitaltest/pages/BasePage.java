package ar.com.bna.digitaltest.pages;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	private Actions actions;
	private static final int DEFAULT_WAIT_SECONDS = Integer.parseInt(
		    System.getProperty("espera.segundos", "40")
		);

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_SECONDS ));
		actions = new Actions(driver);

	}

	public <TestPage extends BasePage> TestPage getInstance(Class<TestPage> pageClass) {

		try {
			System.out.println("page: " + pageClass.getDeclaredConstructor(WebDriver.class));
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
            throw new RuntimeException("No se pude crear la página: " + pageClass.getSimpleName(), e);

		}
	
	}

	public void sendKeys(By locator, String text) {
		this.waitUntilElementIsPresent(locator).sendKeys(text);

	}

	public WebElement getWebElement(By locator) {
		try {
			return this.driver.findElement(locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<WebElement> getWebElements(By locator) {
		try {
			return this.driver.findElements(locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void click(By locator) {
		this.getWebElement(locator).click();
	}

	public String getPageTitle() {
		return this.driver.getTitle();
	}

	public WebElement waitUntilElementIsPresent(By locator) {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public WebElement waitUntilElementIsClickable(By locator) {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Select getDropdown(By locator) {
		return new Select(this.getWebElement(locator));

	}

	public void moveToWebElement(By locator) {
		actions.moveToElement(this.waitUntilElementIsPresent(locator)).perform();

	}

	public void moveToWebElementByOffset(By locator) {
		actions.moveToElement(this.waitUntilElementIsClickable(locator), 0, 0).perform();

	}

	public void clickWebElement(By locator) {
		actions.click(this.waitUntilElementIsPresent(locator)).perform();

	}

	public void doubleClickWebElement(By locator) {
		actions.doubleClick(this.waitUntilElementIsPresent(locator)).perform();
	}

	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	// Scrollear la pagina
	public void scrollByElement(WebElement element, int cantPixeles) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollBy({top: arguments[1], left: 0, behavior: 'smooth'});", element, cantPixeles);
	}

	public int existsElement(By locator) {

		return driver.findElements(locator).size();

	}
	/*
	 * public String getPageHeader(By locator) { return
	 * this.getWebElement(locator).getText(); }
	 */

	
	public void selectItemFromReactDropDownByIndex(By dropDownLocator, int indexElement) {

	    for (int i = 0; i < indexElement; i++) {
	        actions.sendKeys(Keys.DOWN);
	    }
	    actions.sendKeys(Keys.ENTER);

	    actions.build().perform();
	}
	
	
}
