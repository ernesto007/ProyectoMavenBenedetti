package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsPiza {
	public static WebElement element = null;
	int secons = 60;

	// ELEMENTO NOMBRE
	public WebElement ElemetoNombre(WebDriver driver) {
		WebElement elemento = driver.findElement(By.id("FirstName"));
		return elemento;
	}

	public void WaitElemetoNombre(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, secons);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));

	}

	// ELEMENTO APELLIDO
	public WebElement ElementoApellido(WebDriver driver) {
		WebElement elemento = driver.findElement(By.id("LastName"));
		return elemento;
	}

	// ELEMENTO EMAIL
	public WebElement ElementoEmail(WebDriver driver) {
		WebElement elemento = driver.findElement(By.id("emailAddress"));
		return elemento;
	}


	// ELEMENTO TELEFONO
	public WebElement ElementoTelefono(WebDriver driver) {
		WebElement elemento = driver.findElement(By.id("phone"));
		return elemento;
	}
	// ELEMENTO AÑO

		public WebElement ElementoAnio(WebDriver driver) {
			WebElement elemento = driver.findElement(By.xpath("//*[@id=\'page-register\']/div/form/div/div[5]/div/div[2]/div[1]/select"));
			return elemento;
		}
		// ELEMENTO MES //*[@id="page-register"]/div/form/div/div[5]/div/div[2]/div[1]

		public WebElement ElementoMes(WebDriver driver) {
			WebElement elemento = driver.findElement(By.xpath("//*[@id=\'page-register\']/div/form/div/div[5]/div/div[2]/div[2]/select"));
			return elemento;
		}
	// ELEMENTO DIA

	public WebElement ElementoDia(WebDriver driver) {
		WebElement elemento = driver
				.findElement(By.xpath("//*[@id=\'page-register\']/div/form/div/div[5]/div/div[2]/div[3]/select"));
		return elemento;
	}

	

	// ELEMENTO CHECK
	public WebElement ElementoCheck(WebDriver driver) {
		WebElement elemento = driver.findElement(By.xpath(
				"//*[@id=\'page-register\']/div/form/div/div[8]/div[1]/div/label/span"));
		return elemento;
	}

	// ELEMENTO PASS
	public WebElement ElementoPass(WebDriver driver) {
		WebElement elemento = driver.findElement(By.name("password"));
		return elemento;
	}

	// ELEMENTO PASS CONFIRM
	public WebElement ElementoPassConfirm(WebDriver driver) {
		WebElement elemento = driver.findElement(By.name("re_password"));
		return elemento;
	}

	// ELEMENTO CREAR CUENTA dudas
	public WebElement ElementoCrearCuenta(WebDriver driver) {
		WebElement elemento = driver.findElement(By.xpath(
				"//*[@id=\'page-register\']/div/form/div/input"));
		return elemento;
	}
	// ELEMENTO CANCELAR CUENTA
		public WebElement ElementoExistente(WebDriver driver) {
			WebElement elemento = driver.findElement(By.xpath(
					"//*[@id=\'page-register\']/div/form/div/div[2]"));
			return elemento;
		}



	// ELEMENTO CANCELAR CUENTA
	public WebElement ElementoCancelarCuenta(WebDriver driver) {
		WebElement elemento = driver.findElement(By.name(
				"html/body/div[1]/div[3]/div[1]/div/div/div[1]/div/div/div[1]/div/div[4]/form/div/div/ul/li[1]/button"));
		return elemento;
	}

}
