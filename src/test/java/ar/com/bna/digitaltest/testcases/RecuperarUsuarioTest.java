package ar.com.bna.digitaltest.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ar.com.bna.digitaltest.pages.LoginPage1;
import ar.com.bna.digitaltest.pages.RecuperarUsuarioPage;

public class RecuperarUsuarioTest extends BaseTest {



	@Test(priority = 1)
	public void verifyTitle() {
		Assert.assertEquals("Home banking", super.getPageThread().get().getInstance(RecuperarUsuarioPage.class).getPageTitle());
	}

	@Test(priority = 2)
	public void verifyHeader() {
		Assert.assertEquals("Recuperar usuario", super.getPageThread().get().getInstance(RecuperarUsuarioPage.class).getLoginPageHeader());

	}

	@Test(priority = 3)
	public void enterNoDataAndSubmmit() {
		RecuperarUsuarioPage recuperarUsuarioPage = super.getPageThread().get().getInstance(LoginPage1.class).getRecuperarUsuario();
		recuperarUsuarioPage.click();
		Assert.assertEquals(recuperarUsuarioPage.getErrorMensajeObligatorio(), "Este campo es obligatorio.");

	}

	@Test(priority = 4, description = "Valida que no se pueda ingresar un formato erróneo")
	public void enterWrongFormat() {
		RecuperarUsuarioPage recuperarUsuarioPage = super.getPageThread().get().getInstance(LoginPage1.class).getRecuperarUsuario();
		recuperarUsuarioPage.enterCuilCuit(super.getTestDataProperties().getProperty("invalidCuitCuil"));
		recuperarUsuarioPage.click();
		Assert.assertEquals(recuperarUsuarioPage.getErrorMensajeFormato(), "El CUIT/CUIL ingresado no es válido");

	}	
	
	@Test(priority = 5)
	public void enterNonexistentCuitCuil() {
		RecuperarUsuarioPage recuperarUsuarioPage = super.getPageThread().get().getInstance(LoginPage1.class).getRecuperarUsuario();
		recuperarUsuarioPage.enterCuilCuit(super.getTestDataProperties().getProperty("cuitCuilInexistente"));
		recuperarUsuarioPage.click();
		Assert.assertEquals(recuperarUsuarioPage.getErrorMensajeCuitCuilInexistente(), "No hemos podido procesar tu solicitud");

	}
	
	
}
