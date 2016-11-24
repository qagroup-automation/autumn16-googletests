package com.qagroup.google.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrangeHomePage {

	private WebDriver driver;

	public OrangeHomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getLoggedUserRole() {
		return null;
	}

}
