package com.qagroup.google.tools;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Browser {

	public static WebDriver getDriver() {
		String browser = System.getProperty("browser");

		if (browser == null) {
			return getFirefoxDriver();
		}

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
		String runMobile = System.getProperty("platform", "desktop");
		if (runMobile.equals("android"))
			return getChromeDriverOnAndroid();

		String pathSeparator = File.separator;
		String pathToDriver = "assets" + pathSeparator + "webdriver" + pathSeparator + "chrome" + pathSeparator + "win"
				+ pathSeparator + "chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", pathToDriver);

		return new ChromeDriver();
	}

	private static WebDriver getChromeDriverOnAndroid() {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.2");
		// capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android
		// Emulator");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy A3");
		// capabilities.setCapability(AndroidMobileCapabilityType.AVD,
		// "Nexus_5X_API_25_x86");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
		System.out.println("CAPABILITIES: " + capabilities);

		AndroidDriver<MobileElement> driver = null;
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
		return driver;
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("os.name"));
	}
}
