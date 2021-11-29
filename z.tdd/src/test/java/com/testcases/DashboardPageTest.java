package com.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.base.TestBase;
import com.pages.AdminPage;
import com.pages.DashboardPage;
import com.pages.LoginPage;

public class DashboardPageTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	AdminPage adminPage;
	
	public DashboardPageTest() {
		super();
	}
	
	@BeforeMethod
	@Parameters({"user", "pass"})
	public void setUp(String user, String pass) {
		super.initialize();
		loginPage = new LoginPage();
		dashboardPage = loginPage.validateLogin(user, pass);
		adminPage = dashboardPage.validateAdminPageLink();
	}
	
	@Test
	
	public void validateAdminPageLinkTest() {
		Assert.assertTrue(adminPage != null);
	}
}
