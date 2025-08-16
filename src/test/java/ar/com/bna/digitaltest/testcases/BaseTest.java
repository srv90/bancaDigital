package ar.com.bna.digitaltest.testcases;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ar.com.bna.digitaltest.pages.BasePage;

public class BaseTest {

	public WebDriver driver;
	protected BasePage page;
	private Properties properties;
	private Properties propertiesData;
	protected Logger logger;
	private ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
	private ThreadLocal<BasePage> pageThread = new ThreadLocal<>();

	@BeforeClass
	public void initializeProperties() {

		properties = new Properties();
		propertiesData = new Properties();

		loadProperties(properties, "src/main/java/ar/com/bna/digitaltest/config/config.properties");
		loadProperties(propertiesData, "src/main/java/ar/com/bna/digitaltest/testdata/testdata.properties");

		System.out.println("PROPERTIES LOADED");

	}

	@BeforeMethod
	public void setup() {

		// logger = LogManager.getLogger(this.getClass());

		String browser = System.getProperty("browser", properties.getProperty("browser")).toLowerCase();

		switch (browser) {
		case "chrome":
			driver = createChromeDriver(false);
			break;
		case "headless":
			driver = createChromeDriver(true);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);

		}
		
		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));
		driverThread.set(driver);
		pageThread.set(new BasePage(driver));

		System.out.printf("Before Test Thread ID: %d%n", Thread.currentThread().getId());
		System.out.println("DRIVER CREATED");
	}

	// @AfterMethod
	public void tearDown() {

		System.out.println("After Test Thread ID: " + Thread.currentThread().getId());
		driverThread.get().quit();
		System.out.println("DRIVER CLOSED");
		driverThread.remove();

	}

	@AfterSuite()
	public void openHtmlReport() {

		try {
			File reportsFile = new File("reports\\index.html");
			if (reportsFile.exists()) {
				Desktop.getDesktop().browse(reportsFile.toURI());
			} else {
				System.out.println("No se encuentra el reporte " + reportsFile.getAbsolutePath());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ThreadLocal<BasePage> getPageThread() {
		return pageThread;
	}

	public Properties getConfigProperties() {
		return properties;
	}

	public Properties getTestDataProperties() {
		return propertiesData;
	}

	private void loadProperties(Properties props, String relativePath) {
		Path path = Paths.get(System.getProperty("user.dir"), relativePath);

		try (FileInputStream fis = new FileInputStream(path.toFile())) {
			props.load(fis);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Properties file not found: " + path, e);
		} catch (IOException e) {
			throw new RuntimeException("Error loading properties file: " + path, e);
		}
	}

	private WebDriver createChromeDriver(boolean headless) {
		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);

		if (headless) {
			options.addArguments("--headless=new", "--force-device-scale-factor=0.6");
		} else {
			options.addArguments("--force-device-scale-factor=0.9");
		}
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\E97782\\Downloads\\chromedriver-win64\\chromedriver.exe");


		return new ChromeDriver(options);
	}

}
