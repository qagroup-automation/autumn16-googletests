package com.qagroup.google.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.allure.annotations.Step;

public class StartPage {

	private WebDriver driver;

	@FindBy(id = "lst-ib")
	private WebElement searchInput;

	@FindBy(name = "btnG")
	private WebElement searchButton;

	public StartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Step("Search for {0}")
	public ResultPage searchFor(String keywords) {
		typeIntoSearchInput(keywords);
		clickSearchButton();
		return new ResultPage(driver);
	}

	@Step("Type [{0}] into Search input")
	private void typeIntoSearchInput(String keywords) {
		searchInput.sendKeys(keywords);
	}

	@Step
	private void clickSearchButton() {
		searchButton.click();
	}
	
	public StartPage and() {
		return this;
	}
}
