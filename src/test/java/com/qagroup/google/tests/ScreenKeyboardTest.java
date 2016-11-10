package com.qagroup.google.tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScreenKeyboardTest {

	private WebDriver driver;
	private String baseUrl;

	WebElement keyboard;

	@BeforeClass
	public void setup() {
		String pathSeparator = File.separator;
		String pathToDriver = "assets" + pathSeparator + "webdriver" + pathSeparator + "geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", pathToDriver);

		baseUrl = "https://www.google.com";

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void testKeyboardAppearance() {
		driver.get(baseUrl);
		driver.findElement(By.cssSelector("#gs_st0")).click();

		keyboard = driver.findElement(By.id("kbd"));

		Assert.assertTrue(keyboard.isDisplayed());
	}

	@Test(priority = 2)
	public void testKeyboardClose() {
		WebElement keyboardCloseButton = keyboard.findElement(By.cssSelector(".vk-t-btn"));

		keyboardCloseButton.click();

		Assert.assertFalse(keyboard.isDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

}
