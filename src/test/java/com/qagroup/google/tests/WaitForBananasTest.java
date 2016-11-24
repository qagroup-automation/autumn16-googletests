package com.qagroup.google.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qagroup.google.page.Google;
import com.qagroup.google.page.IWebApp;
import com.qagroup.google.page.IWebAppTest;

public class WaitForBananasTest implements IWebAppTest {
	Google google = new Google();

	@Test
	public void testWithWaiter() {
		String responseMessage = google.openBananaSite().subscribeAndGetResponseMessage("test1@gmail.com");

		Assert.assertEquals(responseMessage, "Subscription successful", "\nIncorrect response message:\n");
	}

	@Override
	public IWebApp getTestedApp() {
		return google;
	}
}
