package Dao;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DatosExcel {
	
	
	private XSSFWorkbook wb;
	private XSSFSheet sheet1;

	public DatosExcel(String excelPath) {
		try {
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getData(int sheetNumber, int row, int column) {
		sheet1 = wb.getSheetAt(sheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	public void EscribeCelda(int sheetNumber, int row, int column, String dato, String excelPath) throws Exception {
		try {
			FileInputStream file = new FileInputStream(new File(excelPath));

			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet2 = workbook.getSheetAt(sheetNumber);
			Cell celda = null;

			celda = sheet2.getRow(row).getCell(column);
			XSSFRichTextString texto = new XSSFRichTextString(dato);
			celda.setCellValue(texto);

			FileOutputStream elFichero = new FileOutputStream(excelPath);

			workbook.write(elFichero);

			elFichero.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}


