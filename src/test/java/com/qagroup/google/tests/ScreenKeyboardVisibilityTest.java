package com.qagroup.google.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qagroup.google.page.StartPage;

public class ScreenKeyboardVisibilityTest extends AbstractTest {

	private StartPage startPage;

	@Test
	public void verifyIfScreenKeyboardIsDisplayed() {
		startPage = google.openStartPage();
		Assert.assertFalse(startPage.isScreenKeyboardDisplayed(),
				"\nScreen Keyboard should not be displayed on the start page.\n");
	}
}
