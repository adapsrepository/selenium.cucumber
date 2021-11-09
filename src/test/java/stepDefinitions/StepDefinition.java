package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.BaseClass;

import org.junit.runner.RunWith;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class StepDefinition extends BaseClass {
//	LoginPage loginPage = new LoginPage(driver);
//	HomePage homePage = new HomePage(driver);
	
	@Given("^I navigate to Orange HRM page$")
    public void i_navigate_to_orange_hrm_page() throws Throwable {
		driver = initializeBrowser();
//		driver.get(property.getProperty("url"));
		driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("^I click on Login button$")
    public void i_click_on_login_button() throws Throwable {
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.getLoginButton().click();    
    	}

    @Then("^I validate text \"([^\"]*)\" on homepage$")
    public void i_validate_text_something_on_homepage(String text) throws Throwable {
    	HomePage homePage = new HomePage(driver);
    	System.out.println(homePage.getDashBoardTab().getText());
    	Assert.assertEquals(homePage.getDashBoardTab().getText(),text);
    }

    @And("^I enter username \"([^\"]*)\"$")
    public void i_enter_username_something(String username) throws Throwable {
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.getUsername().sendKeys(username);
    }

    @And("^I enter password \"([^\"]*)\"$")
    public void i_enter_password_something(String password) throws Throwable {
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.getPassword().sendKeys(password);
    }

}
