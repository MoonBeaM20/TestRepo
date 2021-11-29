package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPage extends TestBase{
	@FindBy(id = "txtUsername") WebElement username;
	@FindBy(id = "txtPassword") WebElement password;
	@FindBy(name = "Submit") WebElement loginBtn;
	@FindBy(id = "spanMessage") WebElement errorMsg;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public DashboardPage validateLogin(String user, String pass) {
		username.clear();
		username.sendKeys(user);
		password.clear();
		password.sendKeys(pass);
		loginBtn.submit();
		
		return new DashboardPage();
	}
}
