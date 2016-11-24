package com.qagroup.google.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qagroup.google.page.Google;
import com.qagroup.google.page.IWebApp;
import com.qagroup.google.page.IWebAppTest;
import com.qagroup.google.page.OrangeHomePage;
import com.qagroup.google.page.OrangeLoginPage;
import com.qagroup.google.page.UserModel;
import static com.qagroup.google.page.UserData.SYSTEM_ADMINISTRATOR;;

public class LoginIntoOrangeTest implements IWebAppTest {

	private Google google = new Google();
	private OrangeLoginPage loginPage;
	private UserModel user;
	private OrangeHomePage homePage;

	@Test
	public void testLogin() {
		user = SYSTEM_ADMINISTRATOR;
		loginPage = google.openOrangeLoginPage();
		homePage = loginPage.loginAs(user);

		Assert.assertEquals(homePage.getLoggedUserRole(), user.getRole());
	}

	@Override
	public IWebApp getTestedApp() {
		return google;
	}

}
