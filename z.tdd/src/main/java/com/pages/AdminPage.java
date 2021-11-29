package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class AdminPage extends TestBase{
	@FindBy(id = "searchSystemUser_userName") WebElement searchBox;
	@FindBy(id = "searchBtn") WebElement searchBtn;
	@FindBy(id = "resetBtn") WebElement resetBtn;
	
	public AdminPage() {
		PageFactory.initElements(driver, this);
	}
	
	public int validateValidUserSearch(String name) {
		searchBox.clear();
		searchBox.sendKeys(name);
		searchBtn.click();
		int size = driver.findElements(By.xpath("//td[contains(.,"+ name +")]")).size();
		
		return size;
	}
}
