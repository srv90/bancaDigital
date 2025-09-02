package ar.com.bna.digitaltest.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int MAX_RETRY_COUNT = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < MAX_RETRY_COUNT) {
			retryCount++;
			System.out.println("Se ejecuta nuevamente el caso : " + result.getName() + ", intento: " + retryCount);
			return true;
		}
		return false;
	}

		

	public boolean retry2(ITestResult result) {
		if (retryCount < MAX_RETRY_COUNT) {
			retryCount++;
			System.out.println("Se ejecuta nuevamente el caso : " + result.getName() + ", intento: " + retryCount);
			return true;
		}
		return false;
	}
}
