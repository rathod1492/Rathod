package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserBaseClass {
	
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/Browser/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}

	public static WebDriver openFirefox()
	{
		System.setProperty("webdriver.gecko.driver","src/test/resources/Browser/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		return driver;
	}
}
