package Opencart_TestClass;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Browser.BrowserBaseClass;
import Opencart.PageClass.AppHeader_Opencart;
import Opencart.PageClass.Login_OpenCart;
import UtilityPack.Utility;

public class VerificationOfApplication {
	WebDriver driver;
	AppHeader_Opencart a;
	Login_OpenCart login;
	String data;
	@Parameters("browsername")
	@BeforeTest
	public void launchBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver= BrowserBaseClass.openChromeBrowser();
		}
		
		if(browser.equals("Firefox"))
		{
			driver= BrowserBaseClass.openFirefox();
		}
		
	}
	@BeforeClass
	public void objectOfPOMClass()
	{
		 a=new AppHeader_Opencart(driver);
		 login=new Login_OpenCart(driver);
	}
	
	@BeforeMethod
	public void loginApplication() throws InvalidFormatException, IOException
	
	{
		Utility.getDataFromExcelSheet(0,0);
		
		String url="https://demo.opencart.com/index.php?route=account";
		driver.get(url);
		 login=new Login_OpenCart(driver);

		login.clickOnAccount();
		login.clickOnLogin();
		login.setEmail(data);
		login.setPassword();
		
		login.clickOnLoginButton();
	}
	
	@Test
	public void verifyDesktopTab()
	{
		 a=new AppHeader_Opencart(driver);
		a.clickOnDesktop();
		a.clickOnMac();

		String curl=driver.getCurrentUrl();
		String title=driver.getTitle();
		Assert.assertEquals("https://demo.opencart.com/index.php?route=product/category&path=20_27", curl);
		Assert.assertEquals("Mac",  title);

		
		
		}
	
	@Test
	public void verifyText()
	{
		String ftr="mac";
		Assert.assertEquals("Mac", ftr );
	}
	
	@AfterMethod
	public void capture(ITestResult result) throws IOException 
	{
		if(ITestResult.FAILURE==result.getStatus())
		
			Utility.captureScreen(driver);
		
	}
	
	
	@AfterClass
	public void m2()
	{
		System.out.println("dvdbb");

	}
	
}
	
	


