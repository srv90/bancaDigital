package ar.com.bna.digitaltest.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ar.com.bna.digitaltest.pages.LoginPage1;
import ar.com.bna.digitaltest.pages.LoginPage2;

public class Login1Test extends BaseTest {



	@Test(priority = 1)
	public void verifyTitle() {

		Assert.assertEquals(super.getTestDataProperties().getProperty("title"), 
				 super.getPageThread().get().getInstance(LoginPage1.class).getPageTitle());
	}

	@Test(priority = 2)
	public void verifyHeader() {
		Assert.assertEquals(super.getTestDataProperties().getProperty("header"),
				 super.getPageThread().get().getInstance(LoginPage1.class).getLoginPageHeader());
	}

	@Test(priority = 3)
	public void enterUsernameAndVerifyAvatarImage() {
		LoginPage1 loginPage1 = super.getPageThread().get().getInstance(LoginPage1.class);
		loginPage1.enterUsername(super.getTestDataProperties().getProperty("invalidUsername"));
		LoginPage2 loginPage2 = loginPage1.getLoginPage2();
		Assert.assertTrue(loginPage2.avatarIsDisplayed(), "La imagen del avatar no está desplegada");

	}
	

	

	
	
}
