package Escenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import Dao.DaoPiza;
import PageObjects.ElementsPiza;

public class CrearCuenta {

	ElementsPiza elementosPiza = new ElementsPiza();
	DaoPiza excelCont = new DaoPiza("src/test/resources/datosPrueba.xlsx");
	int WAIT = 60;
	String baseUrl = "https://www.pizzahut.com.mx/register";
	Boolean resultadoCrear;

	public void ProcesoCrearCuenta(WebDriver driver, int j, int i) throws Exception {

		String name = excelCont.getData(j, i, 0);
		String apellido = excelCont.getData(j, i, 1);
		String email = excelCont.getData(j, i, 2);	
		String telefono = excelCont.getData(j, i, 3);
		String anio = excelCont.getData(j, i, 4);
		String mes = excelCont.getData(j, i, 5);
		String dia = excelCont.getData(j, i, 6);
		String pass = excelCont.getData(j, i, 7);
		String pasConfirm = excelCont.getData(j, i, 8);
		String check = excelCont.getData(j, i, 9);		
		String creaCuenta = excelCont.getData(j, i, 10);
		String cancelar = excelCont.getData(j, i, 11);
		try {
			ChromeOptions options = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(WAIT, TimeUnit.SECONDS);
			driver.get(baseUrl);
			System.out.println("Paso aqui");
			Thread.sleep(1000);
			Thread.sleep(1000);
			Thread.sleep(1000);
			elementosPiza.ElemetoNombre(driver).click();
			System.out.println("Dio clic");
			elementosPiza.ElemetoNombre(driver).sendKeys(name);
			Thread.sleep(1000);
			elementosPiza.ElementoApellido(driver).clear();
			elementosPiza.ElementoApellido(driver).sendKeys(apellido);
			Thread.sleep(1000);
			elementosPiza.ElementoEmail(driver).clear();
			elementosPiza.ElementoEmail(driver).sendKeys(email);
			Thread.sleep(1000);
		
			elementosPiza.ElementoTelefono(driver).clear();
			elementosPiza.ElementoTelefono(driver).sendKeys(telefono);
			elementosPiza.ElementoTelefono(driver).sendKeys(Keys.TAB);
			Thread.sleep(1000);
			 elementosPiza.ElementoAnio(driver).click();
			 elementosPiza.ElementoAnio(driver).sendKeys(anio);
			 elementosPiza.ElementoAnio(driver).sendKeys(Keys.ENTER);
				Thread.sleep(1000);
			 elementosPiza.ElementoMes(driver).click();
			 elementosPiza.ElementoMes(driver).sendKeys(mes);
			 elementosPiza.ElementoMes(driver).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			// elementosPiza.ElementoMes(driver).click();

			// Thread.sleep(1000);
			
			 elementosPiza.ElementoDia(driver).click();
			// elementosPiza.ElementoDia1(driver).click();
			elementosPiza.ElementoDia(driver).sendKeys(dia);
			 elementosPiza.ElementoDia(driver).sendKeys(Keys.ENTER);
				Thread.sleep(1000);

			// Thread.sleep(1000);
			// elementosPiza.ElementoDia(driver).click();

			// Thread.sleep(1000);
			if (check.equals("si") == true) {
				elementosPiza.ElementoCheck(driver).click();
				Thread.sleep(1000);
			}
			
			elementosPiza.ElementoPass(driver).clear();
			elementosPiza.ElementoPass(driver).sendKeys(pass);

			Thread.sleep(1000);

			elementosPiza.ElementoPassConfirm(driver).clear();
			elementosPiza.ElementoPassConfirm(driver).sendKeys(pasConfirm);
			Thread.sleep(1000);
			
			if(creaCuenta.equals("si")== true)
			{
				elementosPiza.ElementoCrearCuenta(driver).click();
				Thread.sleep(2000);
				
				Thread.sleep(2000);
				resultadoCrear = true;
			}
			
			if(cancelar.equals("si")== true)
			{
				elementosPiza.ElementoCrearCuenta(driver).click();
				Thread.sleep(2000);
				resultadoCrear = false;
				System.out.println("");
			}
			System.out.println("empieza ultima validacion");
			String res = elementosPiza.ElementoExistente(driver).getText();
			
			System.out.println(res);
			
			if (res.equals("Correo ya existente"
					+ "Recuperar contraseña")== true ){
				System.out.println("Prueba con otro correo ese ya se registro");
			}
			Thread.sleep(1000);
	
	
			Thread.sleep(5000);	
			Thread.sleep(5000);
		

			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println("Ocurrio un error " + e);
			resultadoCrear = false;
		} finally {
			if (driver != null) {
				driver.close();
				driver.quit();
			}

		}
	}
	
	
	

	public boolean ResultadoCrearCuenta() {
		return resultadoCrear;
	}

}
