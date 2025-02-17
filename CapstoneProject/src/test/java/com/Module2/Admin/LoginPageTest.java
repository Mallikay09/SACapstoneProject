package com.Module2.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Module2.Utility.PropertiesReader;

public class LoginPageTest
{
	WebDriver driver;
	LoginPage lp=new LoginPage(driver);
	PropertiesReader prop;
	AdminPage ap=new AdminPage(driver);
	
	@BeforeTest
	public void setUp()
	{
		prop =new PropertiesReader();
		driver= new ChromeDriver();
		driver.get(prop.getData("url"));
		lp.addWait();
		driver.manage().window().maximize();
		lp=new LoginPage(driver);
	}
	
  @Test(priority = 1)
  public void loginTest() 
  {
	  lp.login(prop.getData("username"), prop.getData("password"));
  }
  
  @Test(priority = 2)
  public void validateUrl()
  {
	  String url=lp.appUrl();
	  Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index","Url not matched.Test Fail!");
	  System.out.println("Url Matched launch success.Test Passed");
  }
  
  @Test(priority = 3)
  public void validateTitle()
  {
	  System.out.println("Page Title: "+lp.appTitle());
	  Assert.assertEquals(lp.appTitle().contains("OrangeHRM"),true,"Title not matched.Test Failed");
	  System.out.println("Title Matched launch success.Test Passed");
  }
  
  @AfterClass
  public void tearDown()
  {
	  if(driver!=null)	  
		  driver.quit();	  
	  else	  
		  System.out.println("Driver is null"); 
  }
}
