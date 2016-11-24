package com.qagroup.google.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qagroup.google.page.Google;
import com.qagroup.google.page.IWebApp;
import com.qagroup.google.page.IWebAppTest;
import com.qagroup.google.page.StartPage;

public class ScreenKeyboardTest implements IWebAppTest {

	private Google google = new Google();

	private StartPage startPage;

	@BeforeClass
	public void setup() {
		startPage = google.openStartPage();
	}

	@Test(priority = 1)
	public void testKeyboardAppearance() {
		startPage.openScreenKeyboard();

		Assert.assertTrue(startPage.isScreenKeyboardDisplayed(),
				"Screen Keyboard should be displayed after click on keyboard icon.");
	}

	@Test(priority = 2)
	public void testKeyboardClose() {
		startPage.closeScreenKeyboard();

		Assert.assertFalse(startPage.isScreenKeyboardDisplayed(),
				"Screen Keyboard should be hidden after click on Close (x) button.");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		google.close();
	}

	@Override
	public IWebApp getTestedApp() {
		return google;
	}

}
