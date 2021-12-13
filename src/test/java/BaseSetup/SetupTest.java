package BaseSetup;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SetupTest {
	
	public static WebDriver driver = null;
	String baseUrl = "https://cdpyme-front-obpymemx-dev.appls.cto2.paas.gsnetcloud.corp/#/";
	String hubWeb2 = "http://192.168.100.140:44444/wd/hub";
	int wait = 60;
	DesiredCapabilities capChrome = DesiredCapabilities.chrome();
	
	public WebDriver RunNav(String nav, String baseUrl) throws Exception {

	WebDriver driver = null;
		if (nav.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (nav.equals("CH")) {
		 DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability("ignore-certificate", true);
		 driver = new RemoteWebDriver(new
			URL("http://180.175.209.107:5557/wd/hub"), cap);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-extensions");
			options.addArguments("--start-maximized");
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
			 driver = new ChromeDriver(options);

		} else if (nav.equals("CHV")) {

			DesiredCapabilities cap = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL(hubWeb2), cap);

		} else if (nav.equals("FX")) {

			// DesiredCapabilities cap = DesiredCapabilities.firefox();
			// cap.setCapability("ignore-certificate", true);
			// driver = new RemoteWebDriver(new
			// URL("http://180.175.209.107:5556/wd/hub"), dc);

			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
			driver = new FirefoxDriver();

		} else if (nav.equals("FXL")) {

			FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true);
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(FirefoxDriver.PROFILE, profile);
			driver = new RemoteWebDriver(new URL(hubWeb2), cap);

		} else if (nav.equals("CHL")) {

			File file = new File("src/test/resources/chromedriver");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL(baseUrl), cap);

		} else {
			throw new IllegalArgumentException("No browser found: " + nav);
		}

		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);

		driver.get(baseUrl);
		
		if (nav.equals("CHL"))
		{
		driver.manage().window().maximize();
		}
		
		if ( nav.equals("CH"))
				{
			driver.manage().window().maximize();
				}
		
		if (nav.equals("IE")) {
			Thread.sleep(3500);
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
			Alert alerta = driver.switchTo().alert();
			Thread.sleep(500);
			alerta.accept();
			Thread.sleep(500);
			alerta.accept();
		}

		return driver;
	}
	

}


