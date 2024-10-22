package com.Augmont.GoldForAll.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Reporter;

import com.Augmont.GoldForAll.Utilities.GenericMethods;

public class DashboardPage {

	GenericMethods gm = new GenericMethods();
	WebDriver driver;

	// Private WebElements

	@FindBy(xpath = "//div[@class='flex pl-4 gap-5']/div[1]/a")
	private WebElement dashboardOption;

	@FindBy(css = "div[class='text-center lg:text-left']>p")
	private WebElement myPortFolio;

	@FindBy(xpath = "//div[@class='flex flex-wrap gap-10 bg-white py-5 px-4 border border-stroke rounded-xl']/div/p[1]")
	private WebElement totalGoldUnderMyPortFolio;

	// constructor

	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// page action methods.

	public void clickOnDashBoardOption() {
		dashboardOption.click();
		Reporter.log("User Successfully Clicked on Dashboard Option");
	}

	public String verifyMyPortFolio() {
		return dashboardOption.getText();
	}

	public String verifyTotalGoldUnderMyPortFolio() {
		return totalGoldUnderMyPortFolio.getText();
	}

}
