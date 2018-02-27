package com.Automation.Script;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Test.Base.Base;
import com.Test.UiPages.Reg;
import com.Test.Utils.Utils;

public class Registration extends Base {
	public Reg registrationpage = PageFactory.initElements(driver, Reg.class);

	@Test
	public void registrationmethod() {
		try {
			registrationpage = registrationpage.clickonSignup();
			registrationpage = registrationpage.enterSignupdetails();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}