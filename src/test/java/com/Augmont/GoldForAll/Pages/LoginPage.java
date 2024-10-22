package com.Augmont.GoldForAll.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Reporter;

import com.Augmont.GoldForAll.Utilities.GenericMethods;

public class LoginPage {

	GenericMethods gm = new GenericMethods();
	WebDriver driver;

	// Private WebElements

	@FindBy(css = "input[fdprocessedid='zfe1a6']")
	private WebElement securityTextField;

	@FindBy(css = "li[aria-label='My Profile']")
	private WebElement myProfileOption;

	@FindBy(xpath = "//div[@class='bg-sheengold-cosmiclatte fixed w-full top-[100px] z-30']/div/app-rate/div/div[1]/span")
	private WebElement goldRateOnHomePage;

	@FindBy(xpath = "//div[@class='bg-sheengold-cosmiclatte fixed w-full top-[100px] z-30']/div/app-rate/div/div[2]/span")
	private WebElement silverRateOnHomePage;

	@FindBy(xpath = "//div[text()=' +91 - 9325745751 ']")
	private WebElement userPhoneNumber;

	@FindBy(xpath = "//div[text()=' rushikeshburkul11@gmail.com ']")
	private WebElement userEmailID;

	// constructor

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// page action methods.

	public void enterSecurityPin(String securityPin) {
		securityTextField.sendKeys(securityPin);
		Reporter.log("User Successfully Entered Security Pin");
	}

	public void clickOnMyProfileOption() {
		myProfileOption.click();
		Reporter.log("User Successfully Clicked on My Profile Option");
	}

	public String verifyGoldRateOnHomePage() {
		return goldRateOnHomePage.getText();
	}

	public String verifySilverRateOnHomePage() {
		return silverRateOnHomePage.getText();
	}

	public String verifyUserPhoneNumber() {
		return userPhoneNumber.getText();
	}

	public String verifyUserEmailID() {
		return userEmailID.getText();
	}
}
