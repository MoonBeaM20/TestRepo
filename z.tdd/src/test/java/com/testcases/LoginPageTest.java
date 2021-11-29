package com.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.base.TestBase;
import com.pages.DashboardPage;
import com.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	public LoginPageTest() {
		super();
	}
	
	public void setUp() {
		super.initialize();
		loginPage = new LoginPage();
	}
	@Test
	@Parameters({"user", "pass"})
	public void validateLoginPageTest(String user, String pass) {
		dashboardPage = loginPage.validateLogin(user, pass);
		Assert.assertTrue(dashboardPage != null);
	}
}
