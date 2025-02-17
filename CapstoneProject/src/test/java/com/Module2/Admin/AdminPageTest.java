package com.Module2.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Module2.Utility.PropertiesReader;

public class AdminPageTest {
	PropertiesReader prop;
	WebDriver driver;
	LoginPage lp = new LoginPage(driver);
	AdminPage adminPage = new AdminPage(driver);

	@BeforeClass
	public void login() {
		lp.login(prop.getData("username"), prop.getData("password"));
	}

	@BeforeTest
	public void setUp() {
		prop = new PropertiesReader();
		driver = new ChromeDriver();
		driver.get(prop.getData("url"));
		lp.addWait();
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
		adminPage = new AdminPage(driver);
	}

	@Test(priority = 1)
	public void getLeftSideMenuOptions() {
		System.out.println("Left Side Menu Options");
		lp.addWait();
		Assert.assertEquals(adminPage.getOptionsCount(), 12, "Count Not matched. Test Failed!");
		System.out.println("Left side menu count matched to 12.Test Success");
		lp.addWait();
		System.out.println("Click on Admin Option from Left side Menu");
		adminPage.clickElement(adminPage.adminOption);
		lp.addWait();
		System.out.println("Clicked on Admin Option");
		Assert.assertEquals(adminPage.adminHeader.getText(), "Admin", "Failed to launch Admin page!.Test Failed");
		System.out.println("Launched to Admin page Success!.Test Success");
	}

	@Test(priority = 2)
	public void searchByUserName() {
		adminPage.serachTextBox.sendKeys("Admin");
		lp.addWait();
		System.out.println("Search with Employee : Admin");
		adminPage.clickElement(adminPage.searchBtn);
		;
		lp.addWait();
		String output = adminPage.recordFoundHeader.getText();
		System.out.println(output);
		lp.refreshPage();
		lp.addWait();
	}

	@Test(priority = 3)
	public void searchByUserRole() {
		System.out.println("Search Employee with Role :Admin");
		adminPage.searchWithAdminRole();
		System.out.println(adminPage.recordFoundHeader.getText());
		lp.addWait();
		lp.refreshPage();
		lp.addWait();
	}

	@Test(priority = 4)
	public void searchByUserStatus() {
		System.out.println("Search Employee with status :Enabled");
		adminPage.searchWithStatus();
		System.out.println(adminPage.recordFoundHeader.getText());
		lp.addWait();
		lp.refreshPage();
		lp.addWait();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
