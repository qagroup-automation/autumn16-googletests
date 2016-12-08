package com.qagroup.google.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qagroup.google.page.StartPage;

public class ScreenKeyboardTest extends AbstractTest {

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
}
