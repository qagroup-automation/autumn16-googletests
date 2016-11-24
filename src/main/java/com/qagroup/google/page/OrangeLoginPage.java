package com.qagroup.google.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeLoginPage {
	private WebDriver driver;
	
	@FindBy(id = "txtUsername")
	 private WebElement username;

	 @FindBy(id = "txtPassword")
	 private WebElement password;

	 @FindBy(id = "btnLogin")
	 private WebElement loginButton;

	public OrangeLoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public OrangeHomePage loginAs(UserModel user) {
		username.sendKeys(user.getUsername());
		password.sendKeys(user.getPassword());
		loginButton.click();
		return new OrangeHomePage(driver);
	}
	
	
}
