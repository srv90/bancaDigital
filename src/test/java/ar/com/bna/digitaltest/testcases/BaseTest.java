package ar.com.bna.digitaltest.testcases;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
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

		FileInputStream fileInputStream = null;
		properties = new Properties();
		propertiesData = new Properties();

		try {
			fileInputStream = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\ar\\com\\bna\\digitaltest\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fileInputStream = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\ar\\com\\bna\\digitaltest\\testdata\\testdata.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			propertiesData.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("PROPERTIES LOADED");

	}

	@BeforeMethod
	// @BeforeClass(dependsOnMethods = "initializeProperties")
	public void setup() {

		// logger = LogManager.getLogger(this.getClass());

		String browser = System.getProperty("browser") != null ? System.getProperty("browser")
				: properties.getProperty("browser");
		ChromeOptions options = new ChromeOptions();
		
		Map<String, Boolean> prefs = new HashMap<String, Boolean>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);
		if (browser.contains("headless")) {
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			options.addArguments("--headless=new");
			options.addArguments("--force-device-scale-factor=0.9");
			//options.addArguments("--start-maximized");
			options.addArguments("--window-size=1920,1080");

			driverThread.set(new ChromeDriver(options));
			//driverThread.get().manage().window().setSize(new Dimension(1440, 990));

		} else if (browser.equalsIgnoreCase("chrome")) {
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			options.addArguments("--force-device-scale-factor=0.9");

			// options.setPageLoadStrategy(PageLoadStrategy.NONE);
			// options.addArguments("--disk-cache-dir=/path/to/cache");
			// options.addArguments("--disable-blink-features=AutomationControlled");
			// options.addArguments("--remote-allow-origins=*");
			// options.addArguments("--window-size=1920,1080");
			driverThread.set(new ChromeDriver(options));
			driverThread.get().manage().window().maximize();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		//driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_lOAD_TIMEOUT));
		driverThread.get().get(properties.getProperty("url"));
		driver = driverThread.get();
		// page = new BasePage(driver);
		pageThread.set(new BasePage(driverThread.get()));
		System.out.println("Before Test Thread ID: " + Thread.currentThread().getId());
		System.out.println("DRIVER CREATED");
	}

	//@AfterMethod(alwaysRun = true)
	public void tearDown() {

		System.out.println("After Test Thread ID: " + Thread.currentThread().getId());
		driverThread.get().quit();
		System.out.println("DRIVER CLOSED");
		driverThread.remove();

	}

	//@AfterSuite()
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

}
