package com.Test.UiPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.Test.Base.Base;
import com.Test.Utils.Utils;

public class Reg extends Base {

	@FindBy(name = "mobile")
	public WebElement Phone;

	@FindBy(name = "email")
	public WebElement Email;

	@FindBy(name = "password")
	public WebElement Password;

	@FindBy(id = "male")
	public WebElement genderMale;

	@FindBy(css = ".register-register-button")
	public WebElement Submit;

	public Reg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void mousehoverandClick(WebElement element) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).click(element).build().perform();
	}

	public Reg clickonSignup() throws IOException {
		String ele1 = Utils.loadPropertyFile(
				System.getProperty("user.dir") + "/ConfigurationFiles/xpathsforRegistration.properties",
				"ele1");
		
		String ele2 = Utils.loadPropertyFile(
				System.getProperty("user.dir") + "/ConfigurationFiles/xpathsforRegistration.properties",
				"ele2");

		WebElement Ele1 = driver.findElement(By.cssSelector(ele1));
		WebElement Ele2 = driver.findElement(By.cssSelector(ele2));
		this.mousehoverandClick(Ele1);
		this.mousehoverandClick(Ele2);

		return PageFactory.initElements(driver, Reg.class);

	}

	public Reg enterSignupdetails() throws IOException {
		Email.sendKeys(Utils.loadPropertyFile(
				System.getProperty("user.dir") + "/ConfigurationFiles/Application.properties",
				"name"));
		Password.sendKeys(Utils.loadPropertyFile(
				System.getProperty("user.dir") + "/ConfigurationFiles/Application.properties",
				"Password"));  
		Phone.sendKeys(Utils.loadPropertyFile(
				System.getProperty("user.dir") + "/ConfigurationFiles/Application.properties",
				"Phone"));    
		genderMale.click();
		Submit.click();
		return PageFactory.initElements(driver, Reg.class);

	}

}
