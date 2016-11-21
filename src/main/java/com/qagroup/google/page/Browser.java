package com.qagroup.google.page;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public static WebDriver getDriver() {
		String browser = System.getProperty("browser");

		if (browser == null)
			return getFirefoxDriver();

		switch (browser) {
		case "firefox":
			return getFirefoxDriver();
		case "googlechrome":
		case "chrome":
			return getChromeDriver();
		default:
			throw new RuntimeException("\nUnsupported browser: " + browser + "\n");
		}
	}

	private static WebDriver getFirefoxDriver() {
		String pathSeparator = File.separator;
		String pathToDriver = "assets" + pathSeparator + "webdriver" + pathSeparator + "firefox" + pathSeparator
				+ "win64" + pathSeparator + "geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", pathToDriver);

		return new FirefoxDriver();
	}

	private static WebDriver getChromeDriver() {
		String pathSeparator = File.separator;
		String pathToDriver = "assets" + pathSeparator + "webdriver" + pathSeparator + "chrome" + pathSeparator + "win"
				+ pathSeparator + "chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", pathToDriver);

		return new ChromeDriver();
	}
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("os.name"));
	}
}
