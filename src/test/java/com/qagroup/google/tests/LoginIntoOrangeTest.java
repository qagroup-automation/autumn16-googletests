package com.qagroup.google.tests;

import static com.qagroup.google.page.UserData.SYSTEM_ADMINISTRATOR;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qagroup.google.page.OrangeHomePage;
import com.qagroup.google.page.OrangeLoginPage;
import com.qagroup.google.page.UserModel;;

public class LoginIntoOrangeTest extends AbstractTest {

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
}
