package ar.com.bna.digitaltest.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginStressTest {

	ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@BeforeMethod
	public void setUp() throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		driver.set(new ChromeDriver(options));
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get().get("https://digitaltest.bna.com.ar/loginStep1");

	}

	@Test(dataProvider = "inputData", invocationCount = 1)
	public void testLogin(String UserName, String Password) throws InterruptedException {

		driver.get().findElement(By.id("username")).sendKeys(UserName);
		driver.get().findElement(By.id("global.continue")).click();
		driver.get().findElement(By.name("password")).sendKeys(Password);
		driver.get().findElement(By.id("global.continue")).click();
		driver.get().findElement(By.id("loggedUserMenu")).click();
		driver.get().findElement(By.id("global.logout")).click();

	}

	@DataProvider(name = "inputData", parallel = true)
	public static Object[][] loginData() {
		return new Object[][] {{"pruebaqa3", "Test01xp!"}, {"pruebaqa5", "Test01xp!"}, {"pruebaqa6", "Test01xp!"},
		{"pruebaqa7", "Test01xp!"}, {"pruebaqa8", "Test01xp!"}, {"pruebaqa9", "Test01xp!"},
//		{"pruebaqa10", "Test01xp!"}, {"pruebaqa11", "Test01xp!"}, {"pruebaqa12", "Test01xp!"},
//		{"pruebaqa13", "Test01xp!"}, {"pruebaqa14", "Test01xp!"}, {"pruebaqa15", "Test01xp!"},
//		{"pruebaqa32", "Test01xp!"}, {"pruebaqa17", "Test01xp!"}, {"pruebaqa18", "Test01xp!"},
		{"pruebaqa19", "Test01xp!"}, {"pruebaqa20", "Test01xp!"}
		
		
		
		};

	}

	@AfterMethod
	public void tear_down() throws InterruptedException {
		// driver.remove();
		driver.get().quit();
		System.out.println("driver cierre");
	}

}
