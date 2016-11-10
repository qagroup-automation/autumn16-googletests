package com.qagroup.google.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {

	private WebDriver driver;

	public ResultPage(WebDriver driver) {
		this.driver = driver;
	}

	public int getSearchResultNumber() {
		List<WebElement> resultList = driver.findElements(By.cssSelector(".g"));
		return resultList.size();
	}
}
