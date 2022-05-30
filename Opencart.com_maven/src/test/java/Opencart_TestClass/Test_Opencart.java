package Opencart_TestClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Opencart.PageClass.AppHeader_Opencart;
import Opencart.PageClass.Login_OpenCart;

public class Test_Opencart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gopsr\\eclipse-workspace\\SeleniumProject\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
String url="https://demo.opencart.com/index.php?route=account";
driver.get(url);


Login_OpenCart login=new Login_OpenCart(driver);

login.clickOnAccount();
login.clickOnLogin();
login.setEmail();
login.setPassword();
Thread.sleep(2000);
login.clickOnLoginButton();

AppHeader_Opencart a=new AppHeader_Opencart(driver);

a.clickOnDesktop();
a.clickOnMac();

String curl=driver.getCurrentUrl();
String title=driver.getTitle();

if(curl.equals("https://demo.opencart.com/index.php?route=product/category&path=20_27") && title.equals("Mac"))
     {
	         System.out.println("Pass");
      }

else
{
	System.out.println("failed");
}

driver.navigate().back();

a.clickOnLaptop();
a.clickOnWindow();

String cu=driver.getCurrentUrl();
String t2=driver.getTitle();
System.out.println(cu);
System.out.println(t2);
if(cu.equals("https://demo.opencart.com/index.php?route=product/category&path=18_45")&& t2.equals("Windows"))
{
	System.out.println("Test is Pass");
}
else
	
	System.out.println("Test Is Failed");
	}
}
