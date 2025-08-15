package ar.com.bna.digitaltest.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport() {
		
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\ar\\com\\bna\\digitaltest\\config\\config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\index.html");
		extentSparkReporter.config().setReportName("Web Automation Results");
		extentSparkReporter.config().setDocumentTitle("Test Results");
		extentSparkReporter.config().setTheme(Theme.DARK);
		
		
		
	    ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Browser", System.getProperty("browser") != null ? System.getProperty("browser"): properties.getProperty("browser"));
		extentReports.setSystemInfo("Application URL", properties.getProperty("url"));
		extentReports.setSystemInfo("Valid Email", properties.getProperty("validEmail"));
		extentReports.setSystemInfo("Valid Password", properties.getProperty("validPassword"));
		extentReports.setSystemInfo("OS Name", System.getProperty("os.name"));
		extentReports.setSystemInfo("User", System.getProperty("user.name"));
		extentReports.setSystemInfo("Java version", System.getProperty("java.version"));


		return extentReports;
		
	}
}
