package com.qagroup.google.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qagroup.google.page.Google;
import com.qagroup.google.page.ResultPage;
import com.qagroup.google.page.StartPage;

public class SearchResultNumberTest {

	private WebDriver driver;

	private StartPage startPage;
	private ResultPage resultPage;
	private Google google = new Google();

	@BeforeClass
	public void setup() {
		startPage = google.openStartPage();
	}

	@Test
	public void testNumberOfSearchResult() {
		resultPage = startPage.searchFor("Hello World!");

		int actualNumber = resultPage.getSearchResultNumber();

		Assert.assertEquals(actualNumber, 10);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		google.close();
	}

}
