package com.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.base.TestBase;
import com.pages.AdminPage;
import com.pages.DashboardPage;
import com.pages.LoginPage;

public class AdminPageTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	AdminPage adminPage;
	
	public AdminPageTest() {
		super();
	}
	
	@BeforeMethod
	@Parameters ({"user", "pass"})
	public void setUp(String user, String pass) {
		super.initialize();
		loginPage = new LoginPage();
		dashboardPage = loginPage.validateLogin(user, pass);
		adminPage = dashboardPage.validateAdminPageLink();
	}
	
	@Test
	public void validateValidUserSearchTest(String name) {
		int size = adminPage.validateValidUserSearch(name);
		Assert.assertTrue(size > 0);
	}
	
	@DataProvider
	public void getValidUserData() {
		
	}
}
