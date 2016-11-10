package com.qagroup.google.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage {

	private WebDriver driver;

	public StartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public ResultPage searchFor(String keywords) {
		WebElement searchInput = driver.findElement(By.id("lst-ib"));
		searchInput.sendKeys(keywords);
		driver.findElement(By.name("btnG")).click();
		
		return new ResultPage(driver);
	}
}
