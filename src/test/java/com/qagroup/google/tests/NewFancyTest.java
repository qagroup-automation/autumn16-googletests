package com.qagroup.google.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qagroup.google.page.ResultPage;

public class NewFancyTest extends AbstractTest {

	private ResultPage resultPage;

	@Test
	public void testSearchButton() {
		resultPage = google.openStartPage().searchFor("hello");
		Assert.assertNotNull(resultPage);
	}
}
