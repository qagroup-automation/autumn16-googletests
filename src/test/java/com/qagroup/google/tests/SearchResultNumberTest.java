package com.qagroup.google.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qagroup.google.page.ResultPage;
import com.qagroup.google.page.StartPage;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

@Features("Search")
public class SearchResultNumberTest extends AbstractTest {

	private StartPage startPage;
	private ResultPage resultPage;

	@BeforeMethod
	public void setup() {
		startPage = google.openStartPage();
	}

	@Stories("Result Number Story")
	@Test(dataProvider = "dataProvider")
	public void testNumberOfSearchResult(String query) {
		resultPage = startPage.searchFor(query);
		int actualNumber = resultPage.getSearchResultNumber();

		Assert.assertEquals(actualNumber, 10, "The number of found results is incorrect: ");
	}

	@DataProvider(name = "dataProvider")
	public Object[][] data() {
		return new Object[][] { { "Hello World!" }, { "911" }, { "selenium ide" } };
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		google.close();
	}

}
