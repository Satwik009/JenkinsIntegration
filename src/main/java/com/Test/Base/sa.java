package com.Test.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Test.Base.Base;
import com.Test.UiPages.Reg;

public class sa extends Base {

	public sa(final WebDriver driver) {
		Base.driver = driver;
	}

	public void selectDropdown(String value, String Text) {
		Select obj = new Select(driver.findElement(By.name(value)));
		obj.selectByVisibleText(Text);
	}

	public void dragAndDrop(WebElement srcElement, WebElement disElement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(srcElement, disElement);
	}

	// Click webelement using javascript
	// public void clickWebElement() {
	// // WebElement element = ;
	// JavascriptExecutor executor = (JavascriptExecutor) driver;
	// executor.executeScript("arguments[0].click();", element);
	// }

	public void clickWebElementThroughJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
}
