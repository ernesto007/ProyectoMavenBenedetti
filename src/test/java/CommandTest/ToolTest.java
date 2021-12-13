package CommandTest;



import static java.awt.event.InputEvent.BUTTON1_MASK;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

import Dao.DatosExcel;



public class ToolTest {

	public static final String LOGO = "src/test/resources/logo2.png";
	public static final String captura = "src/test/resources/img/Captura.png";
	DatosExcel excelCont = new DatosExcel("src/test/resources/CtaNewPFAE.xlsx");

	public Document createPdf(FileOutputStream dest, String version, String casoPrueba, String cicloP, String historia,
			String tester, String sprint) throws IOException {
		// Initialize PDF writer

		Calendar fecha = new GregorianCalendar();
		int año = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		PdfWriter writer = new PdfWriter(dest);
		writer.setCompressionLevel(9);
		// Initialize PDF document
		PdfDocument pdf = new PdfDocument(writer);

		PageSize ps = PageSize.A4;
		// Initialize document
		Document document = new Document(pdf, ps);
		// footer.onEndPage(writer,document);

		PdfFont bold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
		PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);

		Image image = new Image(ImageDataFactory.create(LOGO));

		image.scaleAbsolute(100, 25);

		// TABLA DEL ENCABEZADO
		Table table = new Table(3);
		Style noBorder = new Style().setBorder(Border.NO_BORDER);
		table.addHeaderCell(new Cell().add("Evidencia: " + historia).addStyle(noBorder)).setFont(font).setFontSize(10)
				.setFontColor(Color.GRAY);

		table.addHeaderCell(new Cell().add(image).addStyle(noBorder));

		table.addHeaderCell(new Cell().add("Sprint: " + sprint).addStyle(noBorder));
		table.addHeaderCell(new Cell().add("Fecha Actual: " + dia + "/" + (mes + 1) + "/" + año).addStyle(noBorder));
		table.addHeaderCell(new Cell().add("").addStyle(noBorder));
		table.addHeaderCell(new Cell().add("Tipo de Prueba: Automatizada").addStyle(noBorder));
		document.add(table);

		Paragraph pdots1 = new Paragraph(
				"_______________________________________________________________________________________").setFont(bold)
						.setFontColor(Color.RED);
		document.add(pdots1);

		Text title = new Text("CONTROL DE VERSIONES").setFont(bold).setFontSize(10);
		Paragraph texto = new Paragraph().add(title);
		texto.setTextAlignment(TextAlignment.CENTER);
		document.add(texto);

		// TABLA DE CONTROL DE CAMBIOS
		Table table3 = new Table(4);
		Cell ver = new Cell().add("Versión");
		ver.setBackgroundColor(Color.RED).setFontColor(Color.WHITE).setFontSize(10).setFont(font)
				.setTextAlignment(TextAlignment.CENTER);
		table3.addCell(ver);
		Cell rc = new Cell().add("Responsable del Cambio");
		rc.setBackgroundColor(Color.RED).setFontColor(Color.WHITE).setFontSize(10).setFont(font);
		table3.addCell(rc);
		Cell cc = new Cell().add("Causa del Cambio");
		cc.setBackgroundColor(Color.RED).setFontColor(Color.WHITE).setFontSize(10).setFont(font);
		table3.addCell(cc);
		Cell fc = new Cell().add("Fecha del Cambio");
		fc.setBackgroundColor(Color.RED).setFontColor(Color.WHITE).setFontSize(10).setFont(font);
		table3.addCell(fc);
		table3.addCell(new Cell().add(version)).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(Color.WHITE)
				.setFontColor(Color.BLACK).setFontSize(10).setFont(font);
		table3.addCell(new Cell().add(tester)).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(Color.WHITE)
				.setFontColor(Color.BLACK).setFontSize(10).setFont(font);
		table3.addCell(new Cell().add("Creaccion del Documento")).setTextAlignment(TextAlignment.CENTER)
				.setBackgroundColor(Color.WHITE).setFontColor(Color.BLACK).setFontSize(10).setFont(font);
		table3.addCell(new Cell().add(dia + "-" + (mes + 1) + "-" + año)).setTextAlignment(TextAlignment.CENTER)
				.setBackgroundColor(Color.WHITE).setFontColor(Color.BLACK).setFontSize(10).setFont(font);
		document.add(table3);

		Text title2 = new Text("1.1 Caso de Prueba:").setFont(bold);
		Paragraph texto2 = new Paragraph().add(title2).setFontSize(10);
		document.add(texto2);

		Paragraph Descrip = new Paragraph().add(casoPrueba).setFont(font);
		document.add(Descrip);

		Text title3 = new Text("1.2 Ciclo de pruebas:").setFont(bold);
		Paragraph texto3 = new Paragraph().add(title3);
		document.add(texto3);

		Paragraph Descrip1 = new Paragraph().add(cicloP).setFont(font);
		document.add(Descrip1);

		Text title4 = new Text("1.3 Historia de Usuario probada:").setFont(bold);
		Paragraph texto4 = new Paragraph().add(title4);
		document.add(texto4);

		Paragraph Descrip2 = new Paragraph().add(historia).setFont(font);
		document.add(Descrip2);

		return document;

	}

	public void ObtenerEvidencia(WebDriver driver, Document doc, String Texto, String casoPrueba) throws Exception {

		TimeFast();
		String fileImge = "src/test/resources/img/Captura_" + casoPrueba + ".jpg";
		PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("src/test/resources/img/Captura_" + casoPrueba + ".jpg"));
		Image foto = new Image(ImageDataFactory.create(fileImge));
		foto.scaleToFit(500, 500);
		foto.setHorizontalAlignment(HorizontalAlignment.CENTER);
		Paragraph Descrip = new Paragraph().add(Texto.toUpperCase()).setFontSize(9).setFont(font);
		doc.add(Descrip);
		doc.add(foto);

	}

	public void Descripcion(Document doc, String Texto) throws Exception {
		PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
		Paragraph Descrip = new Paragraph().add(Texto.toUpperCase()).setFontSize(9).setFont(font);
		doc.add(Descrip);
		TimeFast();
	}

	public void DescripcionSin(Document doc, String Texto) throws Exception {
		PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
		Paragraph Descrip = new Paragraph().add(Texto.toUpperCase()).setFontSize(9).setFont(font);
		doc.add(Descrip);
	}

	public void LoadFile(WebDriver driver) {

		WebElement element = driver.findElement(By.xpath("//input[@name='file_1']"));
		LocalFileDetector detector = new LocalFileDetector();
		String path = "D://test66T.txt";
		File f = detector.getLocalFile(path);
		((RemoteWebElement) element).setFileDetector(detector);
		element.sendKeys(f.getAbsolutePath());
	}

		
	public Document pdfComplet(int j, int i) throws IOException {
		Document documento=null;
	String ciclo = excelCont.getData(0, 1, 0);
	String historia = excelCont.getData(0, 1, 1);
	String tester = excelCont.getData(0, 1, 2);
	String sprint = excelCont.getData(0, 1, 3);
	String version = excelCont.getData(0, 1, 4);
	String casoPrueba = excelCont.getData(j, i, 0);

	Calendar fecha = new GregorianCalendar();
	int año = fecha.get(Calendar.YEAR);
	int mes = fecha.get(Calendar.MONTH);
	int dia = fecha.get(Calendar.DAY_OF_MONTH);
	int hora = fecha.get(Calendar.HOUR);
	int minuto = fecha.get(Calendar.MINUTE);
	int segundo = fecha.get(Calendar.SECOND);

	FileOutputStream dest = new FileOutputStream("src/test/resources/reportes/" + casoPrueba + "_" + "_" + dia
			+ (mes + 1) + año + "_" + hora + minuto + segundo + ".pdf");
	documento = createPdf(dest, version, casoPrueba, ciclo, historia, tester, sprint);
	return documento;
	}
	

	public void TimeFast() throws Exception {

		Thread.sleep(750);

	}

	public void TimeMedium() throws Exception {

		Thread.sleep(1500);

	}

	public void TimeHight() throws Exception {

		Thread.sleep(300000);

	}

	public void Timeload() throws Exception {

		Thread.sleep(10000);

	}

	public String LetrasRamdon() {

		Random r = new Random();

		char c = (char) (r.nextInt(26) + 'a');
		char b = (char) (r.nextInt(26) + 'a');
		String letras = "a" + c + b;
		return letras;
	}

	public Integer NumRamdon() {
		// note a single Random object is reused here
		Random randomGenerator = new Random();

		int randomInt = randomGenerator.nextInt(100);

		return randomInt;
	}

	public void ScrollTopMedium(WebDriver driver) throws Exception {

		((JavascriptExecutor) driver).executeScript("scroll(1500,0)");
		TimeFast();
	}

	public void ScrollDown(WebDriver driver) throws Exception {

		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		TimeFast();
	}

	public void ScrollDownMedium(WebDriver driver) throws Exception {

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		TimeFast();
	}

	public void ScrollDownFull(WebDriver driver) throws Exception {

		((JavascriptExecutor) driver).executeScript("scroll(0,1500)");
		TimeFast();
	}

	public void TimeOutPyme(WebDriver driver) throws Exception {

		Thread.sleep(601000);
	}

	public String ArchivoCarga(String fileLoad) throws Exception {

		File file = new File("src\\test\\resources\\carga\\" + fileLoad);
		String absolutePath = file.getAbsolutePath();
		return absolutePath;
	}


	 public void Paste(String fileLoad) throws Exception {

         File file = new File("src\\test\\resources\\carga\\" + fileLoad);

         String absolutePath = file.getAbsolutePath();

         StringSelection stringSelection = new StringSelection(absolutePath);
         Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
         clipboard.setContents(stringSelection, stringSelection);

         Robot robot = new Robot();
         robot.keyPress(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);
   }

	 public void PageUp() throws Exception {

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
		}

		public void PageDwon() throws Exception {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}

		public void TypeTab() throws Exception {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		}
		
		public void TypeEnter() throws Exception {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}

		public void TypeExit() throws Exception{
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_F4);
			
			
		}
		public void ClicIzquierdo() throws Exception{
			Robot robot = new Robot();
			robot.mousePress(BUTTON1_MASK);
			robot.mouseRelease(BUTTON1_MASK);
		}
		

}

