package com.Test.UiPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Test.Base.Base;
import com.Test.Utils.Utils;

public class Login extends Base {
	
	@FindBy(name = "email")
	public WebElement Email;

	@FindBy(name = "password")
	public WebElement Password;
	
	@FindBy(css = ".login-login-button")
	public WebElement Login;
	
	
	
	public Login(WebDriver driver)
	{
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	public void mousehoverandClick(WebElement element) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).click(element).build().perform();
	}
	
	public Login clickOnLogin() throws IOException
	{
		String ele1 = Utils.loadPropertyFile(
				System.getProperty("user.dir") + "/ConfigurationFiles/xpathsforRegistration.properties",
				"ele1");
		
		WebElement Ele1 = driver.findElement(By.cssSelector(ele1));
				mousehoverandClick(Ele1);
		        clickOnLoginButton();
                return PageFactory.initElements(driver, Login.class);
	}

	public Login enterDetailsForLogin() throws IOException
	{
		Email.sendKeys(Utils.loadPropertyFile(
				System.getProperty("user.dir") + "/ConfigurationFiles/Application.properties",
				"username"));
		Password.sendKeys(Utils.loadPropertyFile(
				System.getProperty("user.dir") + "/ConfigurationFiles/Application.properties",
				"Pass"));  
		Login.click();
		return PageFactory.initElements(driver, Login.class);
	}
	public Login clickOnLoginButton() throws IOException
	{
		String Login = Utils.loadPropertyFile(
				System.getProperty("user.dir") + "/ConfigurationFiles/xpathsforRegistration.properties",
				"Login");
		        driver.findElement(By.xpath(Login)).click();
                return PageFactory.initElements(driver, Login.class);

	}
}
