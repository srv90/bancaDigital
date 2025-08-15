package ar.com.bna.digitaltest.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ar.com.bna.digitaltest.util.ExtentReporter;
import ar.com.bna.digitaltest.util.Utilities;

public class Listeners implements ITestListener {

	ExtentReports extentReports = ExtentReporter.generateExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {

		extentTest = extentReports.createTest(result.getName()).log(Status.INFO, "Execution started: " + result.getTestClass().getName());
		threadLocal.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		threadLocal.get().log(Status.PASS, "TEST PASSED: " + result.getMethod().getMethodName() + 
				           " TIME DURATION: " + (result.getEndMillis() - result.getStartMillis()) + " miliseconds");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		threadLocal.get().log(Status.FAIL, "TEST FAILED: " + result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		threadLocal.get().addScreenCaptureFromPath(Utilities.getScreenshot(driver, result.getName()));

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		threadLocal.get().log(Status.SKIP, "Test skipped: " + result.getThrowable());

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
		/*
		 * try { Desktop.getDesktop().browse(new File(System.getProperty("user.dir") +
		 * "\\reports\\index.html").toURI()); } catch (IOException e) {
		 * e.printStackTrace();
		 */}
}
