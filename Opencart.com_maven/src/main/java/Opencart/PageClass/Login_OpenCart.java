package Opencart.PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_OpenCart {
	
	@FindBy(xpath="(//a[@href='https://demo.opencart.com/index.php?route=account/account'])[1]")
	WebElement account;
	
	@FindBy(xpath="(//a[text()='Login'])[1]")
	WebElement login;
			
    @FindBy(xpath="//input[@name='email']")
	WebElement email;
			
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@Type='submit']")
	WebElement loginbutton;
	
	public Login_OpenCart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAccount()
	{
		account.click();
		
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
	
	public void setEmail()
	{
		email.sendKeys("anshchavan528@gmail.com");
	}
	
	public void setPassword()
	{
		password.sendKeys("Akola@123");
	}
			
	public void clickOnLoginButton()
	{
		loginbutton.click();
	}
}
