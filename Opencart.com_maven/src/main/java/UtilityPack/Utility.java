package UtilityPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.io.FileHandler;

public class Utility {
  public static WebDriver driver;
	
	public static void captureScreen(WebDriver driver) throws IOException 
	{
		 
		Date d=new Date();
		
		String Filename=d.toString().replace(":","_" ).replace(" ", "_")+"Test";
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String destinationfile=System.getProperty("user.dir")/Screenshot/"+TestCaseName+".jpfg");
		File dest= new File("test-output\\ScreenShot\\Test"+Filename+".jpeg");
		FileHandler.copy(src, dest);
		
		
	
			}
	public static void getDataFromExcelSheet() throws IOException, InvalidFormatException
	{
		String path="C:\\Users\\gopsr\\Desktop\\Gopal.xlsx";
		File fl=new File(path);
		XSSFWorkbook wb=new  XSSFWorkbook(fl);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		int rowcount=sheet.getLastRowNum();
		int calcount=sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<rowcount;i++)
		{
			XSSFRow currentrow=sheet.getRow(i);
			
			for(int j=0;j<calcount;j++)
			{
				String values=currentrow.getCell(j).toString();
				
				System.out.println(values);
			}
		}
		
	}
	
	
}
