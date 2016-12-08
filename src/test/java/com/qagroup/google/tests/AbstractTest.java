package com.qagroup.google.tests;

import org.testng.annotations.AfterClass;

import com.qagroup.google.page.Google;
import com.qagroup.google.tools.IWebApp;
import com.qagroup.google.tools.IWebAppTest;

public class AbstractTest implements IWebAppTest {
	protected Google google = new Google();

	@Override
	public IWebApp getTestedApp() {
		return this.google;
	}


	@AfterClass(alwaysRun = true)
	public void tearDown() {
		google.close();
	}
}
