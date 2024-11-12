package com.Module2.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.Module2.Utility.PropertiesReader;

public class LoginPage extends BasePage {
	PropertiesReader prop;

	// Login page constructor to initialize
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * Locators of login page
	 */
	@FindBy(name = "username")
	WebElement uName;

	@FindBy(name = "password")
	WebElement pswrd;

	@FindBy(xpath = "//button[text()=' Login ']")
	WebElement loginBtn;

	/*
	 * Action Methods
	 */

	public void login(String username, String password) {
		enterText(uName, username);
		enterText(pswrd, password);
		clickElement(loginBtn);
		addWait();
	}

	@Override
	// Abstract method
	public void clickElement(WebElement we) {
		we.click();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public String appUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public String appTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void addWait() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
