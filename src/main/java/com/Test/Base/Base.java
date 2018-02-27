package com.Test.Base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Test.Utils.Utils;

public class Base {
	public static WebDriver driver;

	@BeforeClass
	public static void launchApp() throws IOException {
		String browser_type = Utils.loadPropertyFile(
				System.getProperty("user.dir") + "/ConfigurationFiles/Application.properties",
				"browser_type");
		String url = Utils.loadPropertyFile(
				System.getProperty("user.dir") + "/ConfigurationFiles/Application.properties",
				"url");

		if (browser_type.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer");
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().window().maximize();
		} else if (browser_type.equalsIgnoreCase("chrome"))

		{
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
			driver = new ChromeDriver();
			driver.get(url);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//DIV[@class='desktop-userIconsContainer']")));
		}

		else if (browser_type.equalsIgnoreCase("mozila")) {
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "false");
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
	}

	@AfterClass
	public void End() {
		 {
		 driver.quit();
		}

	}
}
