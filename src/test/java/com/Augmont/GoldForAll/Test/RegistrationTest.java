package com.Augmont.GoldForAll.Test;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Augmont.GoldForAll.Pages.RegistrationPage;
import com.Augmont.GoldForAll.Utilities.GenericMethods;

public class RegistrationTest {

	GenericMethods gm = new GenericMethods();
	WebDriver driver;
	Properties prop = gm.getProp();
	RegistrationPage obj = new RegistrationPage(driver);

	@BeforeMethod
	public void initializeBrowser() {
		driver = gm.startUP(prop.getProperty("Browsername"), prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1, groups = {"Regression"})
	public void verifyNewUserRegistrationFunctionality() throws InterruptedException {

		try {
			FileInputStream fis = new FileInputStream("./Excel_File/Test_Data.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet("Sheet1");
			
			obj.clickOnCharDhamPopup();
			obj.clickOnSignUpOption();
			Thread.sleep(2);
			obj.enterMobileNumber(prop.getProperty("RegistrationMobNo"));
			Thread.sleep(5);
			obj.clickOnGenerateOTPOption();
			Thread.sleep(2);
			obj.enterFirstName(s.getRow(1).getCell(0).getStringCellValue());
			obj.enterLastName(s.getRow(1).getCell(1).getStringCellValue());
			obj.enterEmailID(s.getRow(1).getCell(2).getStringCellValue());
			obj.clickOnStateDropdown();
			Thread.sleep(5);
			obj.selectStateFromDropdown();
			obj.clickOnCityDropdown();
			Thread.sleep(5);
			obj.selectCityFromDropdown();
			obj.clickOnProceedButtonOnRegistrationPage();
			Thread.sleep(2);
			obj.enterOTP(prop.getProperty("OTP"));
			obj.verifyOTP();
			Thread.sleep(10);
			obj.setSecurityPin(prop.getProperty("SecurityPin"));
			obj.confirmSecurityPin(prop.getProperty("SecurityPin"));
			obj.clickOnProceedButtonOnSecurityPage();
			obj.clickOnSkipOption();
			Thread.sleep(5);
			obj.clickOnUserProfileDropdown();
			obj.clickOnLogoutButton();
			Thread.sleep(2);
			obj.clickOnConfirmOptionOnLogoutPopUp();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void CloseBrowser() {
		driver.quit();

	}
}