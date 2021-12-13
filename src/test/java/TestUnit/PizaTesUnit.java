package TestUnit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Escenarios.CrearCuenta;

public class PizaTesUnit {
	public static WebElement element = null;
	int secons = 60;


	CrearCuenta procesoCrearCuenta = new CrearCuenta();

	WebDriver driver;

	@Test
	public void CP01_CrearCuenta() throws Exception {
		procesoCrearCuenta.ProcesoCrearCuenta(driver, 1, 1);
		assertEquals(true, procesoCrearCuenta.ResultadoCrearCuenta());
		
	}	
	
	@Test
	public void CP02_CancelarCuenta() throws Exception {
		procesoCrearCuenta.ProcesoCrearCuenta(driver, 1, 2);
		assertEquals(true, procesoCrearCuenta.ResultadoCrearCuenta());
		
		
	}
}
