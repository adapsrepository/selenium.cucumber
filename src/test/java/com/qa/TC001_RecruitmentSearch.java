package com.qa;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.BaseClass;

public class TC001_RecruitmentSearch extends BaseClass{
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	void initilize() throws IOException {
		driver = initializeBrowser();
		log.info("Driver is initiated...");
		driver.get(property.getProperty("url"));
		log.info("Navigated to baseUrl");
	}

	@Test
	public void loginValidation() throws IOException, InterruptedException {
		
		
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		
		
		loginPage.getUsername().sendKeys(property.getProperty("username"));
		loginPage.getPassword().sendKeys(property.getProperty("password"));
		loginPage.getLoginButton().click();
		Thread.sleep(5000);
		System.out.println(homePage.getDashBoardTab().getText());
		Assert.assertEquals(homePage.getDashBoardTab().getText(), "Dashboard");
		Assert.assertTrue(homePage.getDashBoardTab().isDisplayed());
		log.info("Validated Dashborad on home page");
	}
	
	@AfterTest
	void tearDown() {
		driver.close();
	}
}
