package Practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException
	{
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\MyNewExcel.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("Data");
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("provide How many Number Of Rows to enter");
		
		int noOfRows=sc.nextInt();
		
        System.out.println("provide How many Number Of Cells to enter");
		
		int noOfCells=sc.nextInt();
		
		for(int r=0; r<=noOfRows; r++)
		{
			XSSFRow currentrow= sheet.createRow(r);
			
			for(int c=0; c<noOfCells; c++)
			{
				XSSFCell cell= currentrow.createCell(c);
				
				cell.setCellValue(sc.next());
			}
		
		}
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("File Created");
	}

}
