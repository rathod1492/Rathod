package Opencart.PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppHeader_Opencart {
	
	@FindBy(xpath="(//a[@class='dropdown-toggle'])[2]")
	
	WebElement desktoptab;
	
	@FindBy(xpath="//a[text()='Mac (1)']")
	WebElement mac;
	
	@FindBy(xpath="(//a[@class='dropdown-toggle'])[3]")
	
	WebElement laptop;
	
@FindBy(xpath="//a[text()='Windows (0)']")
	
	WebElement win;
	
	public AppHeader_Opencart(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnDesktop()
	{
		desktoptab.click();
	}
	
	public void clickOnMac()
	{
		mac.click();
	}
	
	public void clickOnLaptop()
	{
		laptop.click();
	}
	
	public void clickOnWindow()
	{
		win.click();
		
	}

}
