package com.Augmont.GoldForAll.Test;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Augmont.GoldForAll.Pages.DashboardPage;
import com.Augmont.GoldForAll.Pages.LoginPage;
import com.Augmont.GoldForAll.Pages.RegistrationPage;
import com.Augmont.GoldForAll.Utilities.GenericMethods;

public class DashboardTest {

	GenericMethods gm = new GenericMethods();
	WebDriver driver;
	Properties prop = gm.getProp();
	RegistrationPage obj = new RegistrationPage(driver);
	LoginPage obj1 = new LoginPage(driver);
	DashboardPage obj2 = new DashboardPage(driver);

	@BeforeMethod
	public void initializeBrowser() {
		driver = gm.startUP(prop.getProperty("Browsername"), prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 3, groups = {"Regression"})
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

		obj2.clickOnDashBoardOption();
		String myPortFolio = obj2.verifyMyPortFolio();
		Assert.assertEquals(myPortFolio, "₹0.00 ", "My PortFolio is not Captured");
		Reporter.log("My PortFolio is =" + myPortFolio);

		String totalGoldUnderMyPortFolio = obj2.verifyTotalGoldUnderMyPortFolio();
		Assert.assertEquals(totalGoldUnderMyPortFolio, "0.0000g", "Total Gold Under My PortFolio is not Captured");
		Reporter.log("Total Gold Under My PortFolio is =" + totalGoldUnderMyPortFolio);

		obj.clickOnUserProfileDropdown();
		obj.clickOnLogoutButton();
		obj.clickOnConfirmOptionOnLogoutPopUp();

	}

	@AfterMethod
	public void CloseBrowser() {
		driver.quit();

	}
}