package com.qagroup.google.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitForBananasTest extends AbstractTest {

	@Test
	public void testWithWaiter() {
		String responseMessage = google.openBananaSite().subscribeAndGetResponseMessage("test1@gmail.com");

		Assert.assertEquals(responseMessage, "Subscription successful", "\nIncorrect response message:\n");
	}

}
