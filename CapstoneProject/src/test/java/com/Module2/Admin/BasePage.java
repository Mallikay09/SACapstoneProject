package com.Module2.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Encapsulation principle WebDriver actions
	public abstract void clickElement(WebElement ele);

	protected void enterText(WebElement ele1, String text) {
		ele1.sendKeys(text);
	}

	public void addWait() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
