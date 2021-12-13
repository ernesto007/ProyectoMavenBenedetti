package TestUnit;



import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import com.itextpdf.layout.Document;

import BaseSetup.SetupTest;
import CommandTest.ToolTest;
import Dao.DatosExcel;
import Escenarios.EscenarioIngreso;




@RunWith(Parameterized.class)

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRegistro {

	ToolTest creaDoc = new ToolTest();
	DatosExcel excelCont = new DatosExcel("src/test/resources/CtaNewPFAE.xlsx");
	EscenarioIngreso escenarioBitacora = new EscenarioIngreso();
	SetupTest setupTest = new SetupTest();
	Document documento;
	WebDriver driver;
	public String browser;
	String baseUrl;

	@Parameters(name = "Navegador - {0}")
	public static Collection<String> getBrowser() {

		// String[] navegadores = new String[] { "IE", "CH", "FX" };
		String[] navegadores = new String[] { "CH" };
		// String[] navegadores = new String[] { "FX" };
		// convert the student database into list
		List<String> navList = Arrays.asList(navegadores);

		return navList;

	}

	public TestRegistro(String browser) {

		this.browser = browser;

	}

	@Before
	public void setUp() throws Exception {

		int amb = 2;
		String nav = browser;
		if (browser.equals("IE") == true) {
			baseUrl = excelCont.getData(0, amb, 6);
		}
		if (browser.equals("CH") == true) {
			baseUrl = excelCont.getData(0, amb, 6);
		}
		if (browser.equals("CHV") == true) {
			baseUrl = excelCont.getData(0, amb, 6);
		}
		if (browser.equals("FX") == true) {
			baseUrl = excelCont.getData(0, amb, 6);
		}
		if (browser.equals("CHL") == true) {
			baseUrl = excelCont.getData(0, amb, 6);
		}
		if (browser.equals("FXL") == true) {
			baseUrl = excelCont.getData(0, amb, 6);
		}
		driver = setupTest.RunNav(nav, baseUrl);

	}

	@After
	public void tearDown() throws Exception {

		escenarioBitacora.PdfDoc().close();
		driver.close();
		driver.quit();

	}

	@Test
	public void CP01_CuentaNuevaPFAA_ClienteRegistrado() throws Exception {
		documento = creaDoc.pdfComplet(1, 1);
		escenarioBitacora.Bitacora(driver, 1, 1, documento);
		assertEquals(true, escenarioBitacora.ResultadoPrueba());
	}
	@Test
	public void CP02_CuentaNuevaPFAE() throws Exception {
		documento = creaDoc.pdfComplet(1, 2);
		escenarioBitacora.Bitacora(driver, 1, 2, documento);
		assertEquals(true, escenarioBitacora.ResultadoPrueba());
	}
	@Test
	public void CP03_CuentaNuevaPFAE() throws Exception {
		documento = creaDoc.pdfComplet(1, 3);
		escenarioBitacora.Bitacora(driver, 1, 3, documento);
		assertEquals(true, escenarioBitacora.ResultadoPrueba());
	}
	

}




