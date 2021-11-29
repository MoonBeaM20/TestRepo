package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class DashboardPage extends TestBase{
	@FindBy(id = "menu_admin_viewAdminModule") WebElement adminLink;
	
	void DashBoardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AdminPage validateAdminPageLink() {
		adminLink.click();
		return new AdminPage();
	}
}
