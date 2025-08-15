package ar.com.bna.digitaltest.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	// public final static int IMPLICIT_WAIT_TIME = 20;
	// public final static int PAGE_lOAD_TIMEOUT = 5;

	public static String getScreenshot(WebDriver driver, String testCaseName) {

		String path = System.getProperty("user.dir") + "//reports//" + testCaseName + System.currentTimeMillis()
				+ ".png";
		try {
			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;

	}

	public static Optional<String> getCuenta(List<WebElement> cuentas, String importe) {
		return cuentas.stream().filter(cuenta -> Double.parseDouble(importe) < formatearMonto(cuenta.getText())).map(WebElement::getText).findFirst();
	}

	public static double formatearMonto(String monto) {
		try {
			return Double.parseDouble(monto.replaceAll("[^\\d,\\.]", "").replace(".", "").replace(",", "."));
		} catch (Exception e) {
			throw new IllegalArgumentException("Monto inválido: " + monto, e);
		}
	}

//	public static double formatearMonto(String monto) {
//
//		return Double.valueOf(monto.split("\\$")[1].replace(".", "").replace(",", ".").trim());
//	}

//	public static String getCuenta(List<WebElement> cuentas, String importe) {
//	return cuentas.stream().filter(s -> Double.valueOf(importe) < formatearMonto(s.getText())).findFirst().get()
//			.getText();
//}

}
