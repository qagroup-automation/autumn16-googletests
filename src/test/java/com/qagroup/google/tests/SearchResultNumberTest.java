package com.qagroup.google.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qagroup.google.page.Google;
import com.qagroup.google.page.ResultPage;
import com.qagroup.google.page.StartPage;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

@Features("Search")
public class SearchResultNumberTest {

	private StartPage startPage;
	private ResultPage resultPage;
	private Google google = new Google();

	@BeforeClass
	public void setup() {
		startPage = google.openStartPage();
	}

	@Stories("Result Number Story")
	@Test
	public void testNumberOfSearchResult() {
		resultPage = startPage.searchFor("Hello World!");

		int actualNumber = resultPage.getSearchResultNumber();

		Assert.assertEquals(actualNumber, 10, "The number of found results is incorrect: ");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		google.close();
	}

}
