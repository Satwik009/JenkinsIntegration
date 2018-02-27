package com.Automation.Script;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Test.Base.Base;
import com.Test.UiPages.Login;

public class Login_Logout extends Base {
	
	public Login loginPage = PageFactory.initElements(driver, Login.class); ;
	
	@Test
	public void loginLogout()
	{
				try {
					loginPage = loginPage.clickOnLogin();
					loginPage = loginPage.enterDetailsForLogin();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
