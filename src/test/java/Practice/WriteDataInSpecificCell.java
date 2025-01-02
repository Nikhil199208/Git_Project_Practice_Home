package Practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataInSpecificCell {

	public static void main(String[] args) throws IOException 
	{
		FileOutputStream file= new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\CellData.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("MySheet");
		
		XSSFRow  row = sheet.createRow(3);
		
		XSSFCell cell = row.createCell(4);
		
		cell.setCellValue("Welcome");
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File Created....");
		
		
		
		
				
				

	}

}
