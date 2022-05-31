package UtilityPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
	public static String getDataFromExcelSheet(int c,int d) throws IOException, InvalidFormatException
	{
		String path="C:\\Users\\gopsr\\Desktop\\Gopal.xlsx";
		FileInputStream file=new FileInputStream(path);
		Workbook book=WorkbookFactory.create(file);
		Sheet sheet=book.getSheet("Sheet1"); 
		Row row=sheet.getRow(c);
		Cell cell=row.getCell(d);
//		String data=cell.toString();
//		String data1=row.toString();
//		
		String data2=sheet.getRow(d).getCell(c).toString();
		return data2;
		
			} 
		
}
		
	
	
	

