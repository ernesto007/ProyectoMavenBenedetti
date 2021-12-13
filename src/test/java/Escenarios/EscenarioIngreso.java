package Escenarios;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


import com.itextpdf.layout.Document;

import CommandTest.ToolTest;
import Dao.DatosExcel;
import PageObjects.PageObjects;


public class EscenarioIngreso {

	PageObjects elementsBitacora = new PageObjects();

	ToolTest creaDoc = new ToolTest();
	DatosExcel excelCont = new DatosExcel("src/test/resources/CtaNewPFAE.xlsx");
	
	String validalong = null;
	
	Boolean resultado;
	Document docPdf = null;
	
	
	public void Bitacora(WebDriver driver, int j, int i, Document documento) throws Exception {

		String casoPrueba = excelCont.getData(j, i, 0);
		String registro = excelCont.getData(j, i, 1);
		String fechaInicial = excelCont.getData(j, i, 2);
		String fechaFinal = excelCont.getData(j, i, 3);
		String rfc = excelCont.getData(j, i, 4);
		String estado = excelCont.getData(j, i, 5);
		String registro2 = excelCont.getData(j, i, 6);
		String rfc2 = excelCont.getData(j, i, 7);
		
		//String cancelaCurp = excelCont.getData(j, i, 12);
	

		docPdf = documento;
		try {
			
			elementsBitacora.WaitRegistro(driver);
			elementsBitacora.registro(driver).click();
			creaDoc.TimeFast();
			creaDoc.ObtenerEvidencia(driver, docPdf, "despligue de tipo de registros como en esta:"+ registro, casoPrueba);
			elementsBitacora.registro(driver).sendKeys(registro);
			elementsBitacora.WaitCalFechaInicial1(driver);
			elementsBitacora.CalfechaInicial1(driver).click();
			creaDoc.TimeFast();
			creaDoc.ObtenerEvidencia(driver, docPdf, "calendario para seleccion de dia:"+ registro, casoPrueba);
			elementsBitacora.CalfechaInicial1(driver).click();
			elementsBitacora.fechaInicial(driver).click();
			elementsBitacora.fechaInicial(driver).sendKeys(fechaInicial);
			elementsBitacora.fechaInicial(driver).sendKeys(Keys.TAB);
			creaDoc.TypeTab();
			elementsBitacora.WaitFechaFinal(driver);
			elementsBitacora.fechaFinal(driver).click();
			elementsBitacora.fechaFinal(driver).sendKeys(fechaFinal);
			elementsBitacora.fechaFinal(driver).sendKeys(Keys.ENTER);
			creaDoc.TimeMedium();
			elementsBitacora.rfc(driver).sendKeys(rfc);
			elementsBitacora.rfc(driver).sendKeys(Keys.ENTER);
			creaDoc.TimeMedium();
			creaDoc.ObtenerEvidencia(driver, docPdf, "ingreso el rango de las fechas y el rfc: "+ rfc, casoPrueba);
			elementsBitacora.WaitEstado(driver);
			elementsBitacora.estado(driver).click();
			elementsBitacora.estado(driver).sendKeys(estado);
			creaDoc.TimeMedium();
			elementsBitacora.WaitbtnBuscar(driver);
			elementsBitacora.btnBuscar(driver).click();
			creaDoc.ObtenerEvidencia(driver, docPdf, "ingreso el estado y da clic en buscar ", casoPrueba);
			creaDoc.ScrollDownFull(driver);
			creaDoc.TimeMedium();
			creaDoc.ObtenerEvidencia(driver, docPdf, "Localizo el registro de bitacora:  "+ rfc, casoPrueba);	
			elementsBitacora.WaitRegistro(driver);
			elementsBitacora.registro(driver).click();
			creaDoc.TimeFast();
			creaDoc.ObtenerEvidencia(driver, docPdf, "despligue de tipo de registros como en esta:"+ registro2, casoPrueba);
			elementsBitacora.registro(driver).sendKeys(registro2); 
			creaDoc.TimeFast();
			elementsBitacora.rfc(driver).sendKeys(rfc2);
			elementsBitacora.rfc(driver).sendKeys(Keys.ENTER);
			elementsBitacora.WaitbtnBuscar(driver);
			elementsBitacora.btnBuscar(driver).click();
			creaDoc.ObtenerEvidencia(driver, docPdf, "Localizo el registro de pistas de auditoria: "+ rfc2 ,casoPrueba);
			creaDoc.ScrollDownFull(driver);
			creaDoc.TimeMedium();
			
resultado = true;
	} catch (Exception e) {

		creaDoc.ObtenerEvidencia(driver, docPdf,
				"se tardo demasiado en cargar o no se encontro el elemento revisar. Error  " + e, casoPrueba);
		resultado = false;
	}

}

public boolean ResultadoPrueba() {
	return resultado;
}

public Document PdfDoc() {

	return docPdf;
}
}



