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

	public BananaPage openBananaSite() {
		driver = Browser.getDriver();
		driver.get("http://ch.my-dev2.org/en-US/node/154");

		return new BananaPage(driver);
	}

	public OrangeLoginPage openOrangeLoginPage() {
		System.setProperty("browser", "chrome");
		driver = Browser.getDriver();
		
		driver.get("https://enterprise-demo.orangehrmlive.com/symfony/web/index.php/auth/login");
		return new OrangeLoginPage(driver);
	}

	public File makeScreenshot() {
		return TakesScreenshot.class.cast(this.driver).getScreenshotAs(OutputType.FILE);
	}
}
