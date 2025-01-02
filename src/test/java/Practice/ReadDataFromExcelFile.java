package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelFile 
{
public static void main(String[] args) throws IOException 
{
	

	FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
	
	XSSFWorkbook workbook= new XSSFWorkbook(file);
	
	XSSFSheet sheet= workbook.getSheet("sheet1");
	
	//XSSFSheet sheet= workbook.getSheetAt(0);       (Alternate way to get sheet)
	
	int TotalRows= sheet.getLastRowNum();
	
	int TotalCells= sheet.getRow(0).getLastCellNum();
	
	System.out.println("Total Rows :"+" "+TotalRows);
	
	System.out.println("Total Cells :"+" "+TotalCells);
	
	for(int r=0; r<=TotalRows; r++)
	{
		XSSFRow CurrentRow= sheet.getRow(r);
		
		for(int c=0; c<TotalCells; c++)
		{
			XSSFCell Cell=CurrentRow.getCell(c);
			
			System.out.print(Cell.toString()+"   ");
				
		}
		System.out.println();
		
	}
	workbook.close();
	file.close();
}
	
}
