package com.Augmont.GoldForAll.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Reporter;

import com.Augmont.GoldForAll.Utilities.GenericMethods;

public class RegistrationPage {

	GenericMethods gm = new GenericMethods();
	WebDriver driver;

	// Private WebElements

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement charDhamPopup;

	@FindBy(xpath = "//a[@class='hidden lg:block xl:block text-14 text-darkgunmetal']")
	private WebElement signUpOption;

	@FindBy(xpath = "//input[@id='mobileNumber']")
	private WebElement mobileNumberTextField;

//	@FindBy(xpath = "//input[@id='value']")
//	private WebElement captchaTextField;

	@FindBy(css = "button[type='submit']")
	private WebElement generateOTPOption;

	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstNameTextField;

	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastNameTextField;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailIDTextField;

	@FindBy(id = "pn_id_8")
	private WebElement stateDropdown;

	@FindBy(xpath = "//div[@class='p-dropdown-items-wrapper']/ul/p-dropdownitem[2]")
	private WebElement selectState;

	@FindBy(id = "pn_id_10")
	private WebElement City_DistrictDropdown;

	@FindBy(xpath = "//div[@class='p-dropdown-items-wrapper']/ul/p-dropdownitem[2]")
	private WebElement selectCity;

	@FindBy(xpath = "//span[text()='Proceed']")
	private WebElement proceedButtonOnRegistrationPage;

	@FindBy(css = "body > app-root:nth-child(2) > div:nth-child(1) > app-verify-otp:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > app-form:nth-child(3) > form:nth-child(1) > div:nth-child(1) > app-field:nth-child(1) > div:nth-child(1) > div:nth-child(1) > app-input-otp:nth-child(1) > div:nth-child(1) > p-inputotp:nth-child(1) > input:nth-child(1)")
	private WebElement enterOtpField;

	@FindBy(xpath = "//span[text()='Verify OTP']")
	private WebElement verifyOTPButton;

	@FindBy(xpath = "//body/app-root/div[@class='overflow-y-auto lg:overflow-hidden']/app-verify-pin[@class='ng-star-inserted']/div[@class='lg:flex xl:flex']/div[1]")
	private WebElement setSecurityPin;

	@FindBy(xpath = "body > app-root:nth-child(2) > div:nth-child(1) > app-verify-pin:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > app-form:nth-child(3) > form:nth-child(1) > div:nth-child(2) > app-field:nth-child(1) > div:nth-child(1) > div:nth-child(1) > app-input-otp:nth-child(1) > div:nth-child(1) > p-inputotp:nth-child(1) > input:nth-child(1)")
	private WebElement confirmSecurityPin;

	@FindBy(css = "div[class='col-span-12 ng-star-inserted'] button")
	private WebElement proceedButtonOnSecurityPinPage;

	@FindBy(css = "app-button[label='Skip']")
	private WebElement skipOption;

	@FindBy(css = "div[class='ng-star-inserted']>button")
	private WebElement userProfileDropdown;

	@FindBy(xpath = "//div[@class='flex justify-center mt-12 ng-star-inserted']/app-button[2]/p-button/button")
	private WebElement confirmOptionOnLogoutPopup;

	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement logoutButton;

	// constructor

	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// page action methods.

	public void clickOnCharDhamPopup() {
		charDhamPopup.click();
		Reporter.log("User Successfully Clicked on Char-Dham Pop-up");
	}

	public void clickOnSignUpOption() {
		signUpOption.click();
		Reporter.log("User Successfully Clicked on SignUp Option");
	}

	public void enterMobileNumber(String mobileNumber) {
		mobileNumberTextField.sendKeys(mobileNumber);
		Reporter.log("User Successfully Entered Mobile Number");
	}

	public void clickOnGenerateOTPOption() {
		gm.waitForVisibilityOfElement(driver, 10, generateOTPOption);
		generateOTPOption.click();
		Reporter.log("User Successfully Clicked on Generate OTP Option");
	}

	public void enterFirstName(String firstName) {
		firstNameTextField.sendKeys(firstName);
		Reporter.log("User Successfully Entered First Name");
	}

	public void enterLastName(String lastName) {
		lastNameTextField.sendKeys(lastName);
		Reporter.log("User Successfully Entered Last Name");
	}

	public void enterEmailID(String email) {
		emailIDTextField.sendKeys(email);
		Reporter.log("User Successfully Entered Email ID Name");
	}

	public void clickOnStateDropdown() {
		stateDropdown.click();
		Reporter.log("User Successfully Clicked on State Dropdown");
	}

	public void selectStateFromDropdown() throws InterruptedException {
		Thread.sleep(5);
		stateDropdown.click();
		Reporter.log("User Successfully Selected the State from State Dropdown");
	}

	public void clickOnCityDropdown() {
		City_DistrictDropdown.click();
		Reporter.log("User Successfully Clicked on City Dropdown");
	}

	public void selectCityFromDropdown() throws InterruptedException {
		Thread.sleep(5);
		selectCity.click();
		Reporter.log("User Successfully Selected the City from City Dropdown");
	}

	public void clickOnProceedButtonOnRegistrationPage() {
		proceedButtonOnRegistrationPage.click();
		Reporter.log("User Successfully Clicked on Proceed Button Registration Page");
	}

	public void enterOTP(String otp) {
		enterOtpField.sendKeys(otp);
		Reporter.log("User Successfully Entered OTP");
	}

	public void verifyOTP() {
		verifyOTPButton.click();
		Reporter.log("User Verified the Entered OTP Sucessfully");
	}

	public void setSecurityPin(String securityPin) {
		setSecurityPin.sendKeys(securityPin);
		Reporter.log("User Successfully Set the Security PIN");
	}

	public void confirmSecurityPin(String SecurityPin) {
		confirmSecurityPin.sendKeys(SecurityPin);
		Reporter.log("User Successfully Confirm the Security PIN");
	}

	public void clickOnProceedButtonOnSecurityPage() {
		proceedButtonOnSecurityPinPage.click();
		Reporter.log("User Successfully Clicked on Proceed Button on Security PIN Page");
	}

	public void clickOnSkipOption() {
		skipOption.click();
		Reporter.log("User Successfully Clicked on Skip Personal Question Option");
	}

	public void clickOnUserProfileDropdown() {
		userProfileDropdown.click();
		Reporter.log("User Successfully Clicked on User Profile Option");
	}

	public void clickOnConfirmOptionOnLogoutPopUp() {
		confirmOptionOnLogoutPopup.click();
		Reporter.log("User Successfully Clicked on Confirm Option On Logout Pop-up");

	}

	public void clickOnLogoutButton() {
		logoutButton.click();
		Reporter.log("User Successfully Clicked on Logout Button");

	}

}
