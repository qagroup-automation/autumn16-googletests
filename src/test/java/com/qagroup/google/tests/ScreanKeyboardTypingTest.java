package com.qagroup.google.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.qagroup.google.page.Google;
import com.qagroup.google.page.IWebApp;
import com.qagroup.google.page.IWebAppTest;
import com.qagroup.google.page.StartPage;

public class ScreanKeyboardTypingTest implements IWebAppTest {

	private Google google = new Google();
	private StartPage startPage;

	@Test
	public void testTypingFromScreenKeyboard() {
		startPage = google.openStartPage();
		startPage.openScreenKeyboard();
		startPage.typeFromScreenKeyboard("привіт");

		Assert.assertEquals(startPage.getSearchInputText(), "привіт", "\nIncorect text in Search input.\n");
	}

	@Override
	public IWebApp getTestedApp() {
		return google;
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		google.close();
	}

}
