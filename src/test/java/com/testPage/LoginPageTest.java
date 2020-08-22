/**
 * 
 */
package com.testPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.myPages.Homepage;
import com.myPages.LoginPage;


/**
 * @author AritraS
 *
 */


public class LoginPageTest extends BaseTest {
	
	//public Homepage homepage;
	
	public LoginPageTest() throws IOException {
		super();
	}
	
	
	@Test(priority =1)
	public void verifyLoginPageTitleTest(){
		log.info("*****Validating Login Page Title********");		
		String loginTitle = page.getInstance(LoginPage.class).getLoginPageTitile();
		System.out.println(loginTitle);
		Assert.assertEquals(prop.getProperty("loginPageTitle"), loginTitle);
	}
	
	@Test(priority =2)
	public void verifyLoginPageHeaderTest(){
		log.info("*****Validating Login Page Header********");
		String loginHeader = page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println(loginHeader);
		Assert.assertEquals(prop.getProperty("loginPageHeader"),loginHeader);
	}
	
	/*public void verifyLoginTest(){
		page.getInstance(LoginPage.class).doLogin();
	}*/
	
	
	@Test(priority =3)
	public void verifyValidLoginTest(){
		log.info("*****Login the application and landing to Homepage********");
		Homepage homepage = page.getInstance(LoginPage.class)
				.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		String headerHome = homepage.getHomepageHeader();
		System.out.println(headerHome);
		Assert.assertEquals(prop.getProperty("homePageHeader"), headerHome);		
	}
	

}
