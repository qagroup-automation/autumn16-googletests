package com.qagroup.google.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qagroup.google.page.StartPage;

public class ScreanKeyboardTypingTest extends AbstractTest {

	private StartPage startPage;

	@Test
	public void testTypingFromScreenKeyboard() {
		startPage = google.openStartPage();
		startPage.openScreenKeyboard();
		startPage.typeFromScreenKeyboard("привіт");

		Assert.assertEquals(startPage.getSearchInputText(), "привіт", "\nIncorect text in Search input.\n");
	}
}
