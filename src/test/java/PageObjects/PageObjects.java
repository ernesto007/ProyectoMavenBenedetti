package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjects {

	public static WebElement element = null;
	int secons = 60;

	// CAMPO INGRESA USUARIO
		public WebElement Usuario(WebDriver driver) {
			element = driver.findElement(By.id("user"));
			return element;
		}

		// WAIT
		public void WaitUsuario(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));
		}

		// CAMPO SELECCIONA CONTRASEÑA
		public WebElement Contraseña(WebDriver driver) {
			element = driver.findElement(By.id("pass"));
			return element;
		}

		// WAIT
		public void WaitContraseña(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));

		}
		// BOTON LOGIN
		public WebElement BtnLogin(WebDriver driver) {
			element = driver.findElement(By.id("btn-login"));
			return element;
		}

		// WAIT
		public void WaitBtnLogin(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-login")));

		}

		// SELECCIONA TIPO DE REGISTRO
		public WebElement registro(WebDriver driver) {
			element = driver.findElement(By.id("registerType"));
			return element;
		}

		// WAIT
		public void WaitRegistro(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registerType")));
		}

		// SELECCIONA EL CALENDARIO FECHA INICIAL
		public WebElement CalfechaInicial1(WebDriver driver) {
			element = driver
					.findElement(By.xpath("/html/body/div[2]/div[1]/form/fieldset/div[2]/div[1]/div/div/p/span/button"));
			return element;
		}

		// WAIT
		public void WaitCalFechaInicial1(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[2]/div[1]/form/fieldset/div[2]/div[1]/div/div/p/span/button")));

		}

		// SELECCIONA LA FECHA INICIAL
		public WebElement fechaInicial(WebDriver driver) {
			element = driver.findElement(
					By.xpath("/html/body/div[2]/div[1]/form/fieldset/div[2]/div[1]/div/div/p/div/ul/li[2]/span/button[1]"));
			return element;
		}

		// WAIT
		public void WaitFechaInicial(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("/html/body/div[2]/div[1]/form/fieldset/div[2]/div[1]/div/div/p/div/ul/li[2]/span/button[1]")));
		}

		// SELECCIONA EL CALENDARIO FECHA INICIAL
		public WebElement CalfechaInicial2(WebDriver driver) {
			element = driver
					.findElement(By.xpath("/html/body/div[2]/div[1]/form/fieldset/div[2]/div[2]/div/div/p/span/button"));
			return element;
		}

		// WAIT
		public void WaitCalFechaInicial2(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[2]/div[1]/form/fieldset/div[2]/div[2]/div/div/p/span/button")));

		}

		// SELECCIONALA FECHA FINAL
		public WebElement fechaFinal(WebDriver driver) {
			element = driver.findElement(
					By.xpath("/html/body/div[2]/div[1]/form/fieldset/div[2]/div[2]/div/div/p/div/ul/li[2]/span/button[1]"));
			return element;
		}

		// WAIT
		public void WaitFechaFinal(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("/html/body/div[2]/div[1]/form/fieldset/div[2]/div[2]/div/div/p/div/ul/li[2]/span/button[1]")));
		}

		// SELECCIONA EL RFC BITACORA
		public WebElement rfc(WebDriver driver) {
			element = driver.findElement(By.xpath("//*[@id='table_1_filter']/label/input"));
			return element;
		}

		// WAIT
		public void WaitRfc(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='table_1_filter']/label/input")));
		}

		// SELECCIONA EL RFC PISTAS DE AUDITORIA
		public WebElement rfc2(WebDriver driver) {
			element = driver.findElement(By.xpath("// *[@id='table_2_filter']/label/input"));
			return element;
		}

		// WAIT
		public void WaitRfc2(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("// *[@id='table_2_filter']/label/input")));
		}

		// SELECCIONA EL RFC EXCEPCIONES
		public WebElement rfc3(WebDriver driver) {
			element = driver.findElement(By.xpath("//*[@id='table_3_filter']/label/input"));
			return element;
		}

		// WAIT
		public void WaitRfc3(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='table_3_filter']/label/input")));
		}

		// SELECCIONA EL ESTADO
		public WebElement estado(WebDriver driver) {
			element = driver.findElement(By.id("state"));
			return element;
		}

		// WAIT
		public void WaitEstado(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("state")));
		}

		// SELECCIONA EL BOTON CONTINUAR
		public WebElement btnBuscar(WebDriver driver) {
			element = driver.findElement(By.id("singlebutton"));
			return element;
		}

		// WAIT
		public void WaitbtnBuscar(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("singlebutton")));
		}

		// SELECCIONA INE
		public WebElement seleccionIne(WebDriver driver) {
			element = driver.findElement(By.id("radio-ine"));
			return element;
		}

		// WAIT
		public void WaitSeleccionIne(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("radio-ine")));
		}

		// SELECCIONA IFE
		public WebElement seleccionIfe(WebDriver driver) {
			element = driver.findElement(By.id("radio-ife"));
			return element;
		}

		// WAIT
		public void WaitseleccionIfe(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("radio-ife")));
		}

		// SELECCIONA PASAPORTE
		public WebElement seleccionPasaporte(WebDriver driver) {
			element = driver.findElement(By.id("radio-passport"));
			return element;
		}

		// WAIT
		public void WaitseleccionPasaporte(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("radio-passport")));
		}

		// SELECCIONA EL ESTADO CIVIL
		public WebElement estadoCivil(WebDriver driver) {
			element = driver.findElement(By.id("civilStatusSelect"));
			return element;
		}

		// WAIT
		public void WaitEstadoCivil(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("civilStatusSelect")));

		}

		// SELECCIONA LA VIGENCIA EL AÑO
		public WebElement vigenciaAño(WebDriver driver) {
			element = driver.findElement(By.id("validitySelect"));
			return element;
		}

		// WAIT
		public void WaitVigenciaAño(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("validitySelect")));

		}

		// SELECCIONA LA VIGENCIA MENSUAL
		public WebElement vigenciaMes(WebDriver driver) {
			element = driver.findElement(By.id("monthValiditySelect"));
			return element;
		}

		// WAIT
		public void WaitVigenciaMes(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monthValiditySelect")));

		}

		// SELECCIONA LA ULTIMA FECHA DE REGISTRO
		public WebElement FechaUltima(WebDriver driver) {
			element = driver.findElement(By.xpath("//*[@id='table_1']/thead/tr/th[2]"));
			return element;
		}

		// WAIT
		public void WaitFechaUltima(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='table_1']/thead/tr/th[2]")));

		}

		// BOTON DESCARGAR DOCUMENTOS //*[@id="table_1"]/tbody/tr[4]/td[7]/a
		public WebElement BotonDocumentos(WebDriver driver) {
			element = driver.findElement(By.xpath("//*[@id=\'table_1\']/tbody/tr[14]/td[7]/a[1]"));
			return element;
		}

		// WAIT
		public void WaitBotonDocumentos(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id=\'table_1\']/tbody/tr[14]/td[7]/a[1]")));

		}

		// BOTON DESCARGAR DOCUMENTOS ENVIADOS A FABRICA
		public WebElement BotonDocumentosFabrica(WebDriver driver) {
			element = driver.findElement(By.xpath("//*[@id=\'table_1\']/tbody/tr[1]/td[7]/a[2]"));
			return element;
		}

		// WAIT
		public void WaitBotonDocumentosFabrica(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, secons);
			element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'table_1\']/tbody/tr[1]/td[7]/a[2]")));

		}

}
