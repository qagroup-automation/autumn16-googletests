package com.qagroup.google.page;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.qatools.allure.annotations.Step;

public class Google implements IWebApp {

	private WebDriver driver;

	private static final String baseUrl = "https://www.google.com.ua/";

	@Step("Open google start page: " + baseUrl)
	public StartPage openStartPage() {
		String pathSeparator = File.separator;
		String pathToDriver = "assets" + pathSeparator + "webdriver" + pathSeparator + "geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", pathToDriver);

		driver = new FirefoxDriver();
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
