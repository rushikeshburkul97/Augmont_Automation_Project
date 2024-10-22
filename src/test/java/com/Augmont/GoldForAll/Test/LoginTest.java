package com.Augmont.GoldForAll.Test;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Augmont.GoldForAll.Pages.LoginPage;
import com.Augmont.GoldForAll.Pages.RegistrationPage;
import com.Augmont.GoldForAll.Utilities.GenericMethods;

public class LoginTest {

	GenericMethods gm = new GenericMethods();
	WebDriver driver;
	Properties prop = gm.getProp();
	RegistrationPage obj = new RegistrationPage(driver);
	LoginPage obj1 = new LoginPage(driver);

	@BeforeMethod
	public void initializeBrowser() {
		driver = gm.startUP(prop.getProperty("Browsername"), prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 2, groups = {"Regression"})
	public void verifyNewUserRegistrationFunctionality() throws InterruptedException {
		

		obj.clickOnCharDhamPopup();
		obj.clickOnSignUpOption();
		Thread.sleep(2);
		obj.enterMobileNumber(prop.getProperty("LoginMobNo"));
		Thread.sleep(5);
		obj.clickOnGenerateOTPOption();
		Thread.sleep(2);
		obj.enterOTP(prop.getProperty("OTP"));
		obj.verifyOTP();
		obj1.enterSecurityPin(prop.getProperty("SecurityPin"));
		obj.clickOnProceedButtonOnSecurityPage();
		obj.clickOnSkipOption();

		String goldRateOnHomePage = obj1.verifyGoldRateOnHomePage();
		System.out.println(goldRateOnHomePage);
		Reporter.log("Gold Rate on Home Page is =" + goldRateOnHomePage);

		String silverRateOnHomePage = obj1.verifySilverRateOnHomePage();
		System.out.println(silverRateOnHomePage);
		Reporter.log("Gold Rate on Home Page is =" + silverRateOnHomePage);

		obj.clickOnUserProfileDropdown();
		Thread.sleep(2);
		obj1.clickOnMyProfileOption();

		Thread.sleep(2);
		String userPhoneNumber = obj1.verifyUserPhoneNumber();
		Assert.assertEquals(userPhoneNumber, " +91 - 9325745751 ", "Phone Number Is not verified Sucessfully");
		Reporter.log("User Successfully Added Phone Number While Registration");

		String userEmailID = obj1.verifyUserEmailID();
		Assert.assertEquals(userEmailID, " rushikeshburkul11@gmail.com ", "Email ID Is not verified Sucessfully");
		Reporter.log("User Successfully Added Email ID While Registration");

		obj.clickOnUserProfileDropdown();
		obj.clickOnLogoutButton();
		obj.clickOnConfirmOptionOnLogoutPopUp();

		
	}

	@AfterMethod
	public void CloseBrowser() {
		driver.quit();

	}
}