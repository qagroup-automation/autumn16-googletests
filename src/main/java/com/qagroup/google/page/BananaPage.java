package com.qagroup.google.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BananaPage extends AbstractPage {

	@FindBy(css = ".newsletter-button.yellow-button > .show-newsletter")
	private WebElement yellowButton;

	@FindBy(id = "edit-mergevars-email")
	private WebElement emailInput;

	@FindBy(css = ".submit-button")
	private WebElement submitButton;

	@FindBy(css = ".submit-button.loading")
	private WebElement submitLoading;

	@FindBy(css = ".response-message")
	private WebElement responseMessage;

	public BananaPage(WebDriver driver) {
		super(driver);
	}

	public String subscribeAndGetResponseMessage(String email) {
		yellowButton.click();
		new WebDriverWait(driver, 10).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(emailInput));
		emailInput.sendKeys(email);
		emailInput.submit();
		// submitButton.click();
		JavascriptExecutor.class.cast(driver).executeScript("arguments[0].click();", submitButton);
		return responseMessage.getText();
	}

}
