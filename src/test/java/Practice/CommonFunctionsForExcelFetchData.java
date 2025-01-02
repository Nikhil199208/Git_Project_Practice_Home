package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctionsForExcelFetchData {

	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		String filepath= System.getProperty("user.dir")+"\\testdata\\FDcalculatorData.xlsx";
		
		int rows=CommonFunctionsForExcelFetchData.getRowCount(filepath, "sheet1");
		
		for(int r=1; r<=rows; r++)
		{
			String principle=CommonFunctionsForExcelFetchData.getCellData(filepath, "sheet1",r,0 );
			
			String roi= CommonFunctionsForExcelFetchData.getCellData(filepath, "sheet1", r, 1);
			
			String per1=CommonFunctionsForExcelFetchData.getCellData(filepath, "sheet1", r, 2);
			
			String per2=CommonFunctionsForExcelFetchData.getCellData(filepath, "sheet1", r, 3);
			
			String fre=CommonFunctionsForExcelFetchData.getCellData(filepath, "sheet1", r, 4);
			
			String exp_maValue= CommonFunctionsForExcelFetchData.getCellData(filepath, "sheet1", r, 5);
			
			
			driver.findElement(By.xpath("//input[@name='principal']")).sendKeys(principle);
			
			
			
			driver.findElement(By.xpath("//input[@name='interest']")).sendKeys(roi);
		
			
			driver.findElement(By.xpath("//input[@name='tenure']")).sendKeys(per1);
			
			
			Select perDrp = new Select(driver.findElement(By.xpath("//select[@name='tenurePeriod']")));
			
			perDrp.selectByVisibleText(per2);
			
			
           Select FrequencyDrp = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			
           FrequencyDrp.selectByVisibleText(fre);
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//div[@class='CTR PT15']//a[1]")).click();
			
			//validation
			
			String act_mavalue=driver.findElement(By.xpath("//span[@name='resp_matval']/strong")).getText();
			
			if(Double.parseDouble(act_mavalue)==Double.parseDouble(exp_maValue))
			{
				System.out.println("Test Passed");
				
				CommonFunctionsForExcelFetchData.SetCellData(filepath, "sheet1", r, 7, "Passed");
				CommonFunctionsForExcelFetchData.FillGreenColour(filepath, "sheet1", r, 7);
			}
			else
			{
				System.out.println("Test Failed");
				
				CommonFunctionsForExcelFetchData.SetCellData(filepath, "sheet1", r, 7, "Failed");
				CommonFunctionsForExcelFetchData.FillRedColour(filepath, "sheet1", r, 7);
				
			}
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//div[@class='CTR PT15']//a[2]")).click();	
			
		}
		
		driver.quit();
	}
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
		
	}
	
	public static int getCellCount(String xlfile, String xlsheet,int rownum) throws IOException
	{
		fi= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	public static String getCellData(String xlfile, String xlsheet, int rownum, int cellnum) throws IOException
	{
	fi= new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row= ws.getRow(rownum);
	cell= row.getCell(cellnum);
	
	String data = null;
	try
	{
		//data=cell.toString();
		DataFormatter formatter= new DataFormatter();
		
		data=formatter.formatCellValue(cell);	
	}
	
	catch(Exception e)
	{
		
	}
	
	wb.close();
	fi.close();
	return data;
	}
	
	public static void SetCellData(String xlfile, String xlsheet, int rownum, int cellnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		
		wb=new XSSFWorkbook(fi);
		
		ws=wb.getSheet(xlsheet);
		
		row=ws.getRow(rownum);
		
		cell=row.createCell(cellnum);
		
		cell.setCellValue(data);
		
		fo= new FileOutputStream(xlfile);
		
		wb.write(fo);
		wb.close();
		
		fi.close();
		fo.close();
		
	}
	
	public static void FillGreenColour(String xlfile,String xlsheet, int rownum,int cellnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		
		wb = new XSSFWorkbook(fi);
		
		ws= wb.getSheet(xlsheet);
		
		row= ws.getRow(rownum);
		
		cell=row.getCell(cellnum);
		
		style=wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		fo= new FileOutputStream(xlfile);
		
		wb.write(fo);
		
		wb.close();
		fi.close();
		fo.close();
	}
	
	public static void FillRedColour(String xlfile,String xlsheet, int rownum, int cellnum) throws IOException
	{
		fi= new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		
		row=ws.getRow(rownum);
		
		cell=row.getCell(cellnum);
		
		style=wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		fo= new FileOutputStream(xlfile);
		
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
	
}
