package com.Module2.Admin;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends BasePage
{
	WebDriver driver;
	// Initialize page factory
	public AdminPage(WebDriver driver) 
	{
		super(driver);
		 this.driver = driver; 
		 PageFactory.initElements(driver, this);
		 
	}
	/* 
	 * Dashboard and Admin Page Locators
	 */

	// Un order left side list
	@FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper']")
	List<WebElement> menuOptions;

	// Admin option webelement
	@FindBy(xpath = "//span[text()='Admin']")
	WebElement adminOption;

	// Admin page heading
	@FindBy(xpath = "//h6[text()='Admin']")
	WebElement adminHeader;
	
	/*
	 * Admin Page Locators
	 */

	// Search User name text box locator
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement serachTextBox;

	// Search button locator
	@FindBy(xpath = "//button[text()=' Search ']")
	WebElement searchBtn;

	// No. of records in user grid after search
	@FindBy(xpath = "//div[@class='oxd-table-body']")
	List<WebElement> totalRecords;

	// record found header after search
	@FindBy(xpath = "(//span[@class='oxd-text oxd-text--span'])[1]")
	WebElement recordFoundHeader;

	// User role drop down
	@FindBy(xpath = ("(//div[@class='oxd-select-text-input'])[1]"))
	WebElement roledrpdwn;

	// Admin option from drop down
	@FindBy(xpath = "//div[contains(@role,'listbox')]")
	WebElement adminDropdownOption;

	// User status drop down
	@FindBy(xpath = ("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]"))
	WebElement statusdrpdwn;

	//Status drop down option 
	@FindBy(xpath = "//span[text()='Enabled']")
	WebElement statusDropdownOption;

	/*
	 * Actions Methods
	 */
	@Override
	public void clickElement(WebElement ele) {
		ele.click();
		
	}
	public int getOptionsCount() 
	{
		return menuOptions.size();
	}
	
	// Get the no of records
	public int getRecordsCount() 
	{
		return totalRecords.size();
	}

	// Click on role drop down and select admin role
	public void searchWithAdminRole() {
		roledrpdwn.click();
		addWait();
		clickElement(adminDropdownOption);
		addWait();
		clickElement(searchBtn);
		addWait();
	}

	// Click on status drop down and select Enabled status
	public void searchWithStatus() 
	{
		clickElement(statusdrpdwn);
		addWait();
		clickElement(statusDropdownOption);
		addWait();
		clickElement(searchBtn);
		addWait();
	}
}
