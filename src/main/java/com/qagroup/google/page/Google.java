package com.qagroup.google.page;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;

public class Google implements IWebApp {

	private WebDriver driver;

	private static final String baseUrl = "https://www.google.com.ua/";

	@Step("Open google start page: " + baseUrl)
	public StartPage openStartPage() {
		driver = Browser.getDriver();
		driver.get(baseUrl);

		return new StartPage(driver);
	}

	public void close() {
		if (this.driver != null)
			this.driver.quit();
		this.driver = null;
	}

	public File makeScreenshot() {
		return TakesScreenshot.class.cast(this.driver).getScreenshotAs(OutputType.FILE);
	}
}
