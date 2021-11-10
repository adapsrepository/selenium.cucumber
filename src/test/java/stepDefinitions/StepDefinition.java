package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.AssignLeavePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RecruitmentPage;
import resources.BaseClass;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
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
		Thread.sleep(5000);
	}

	@Then("^I validate text \"([^\"]*)\" on homepage$")
	public void i_validate_text_something_on_homepage(String text) throws Throwable {
		HomePage homePage = new HomePage(driver);
		System.out.println(homePage.getDashBoardTab().getText());
		Assert.assertEquals(homePage.getDashBoardTab().getText(), text);
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

	@And("^I click on Assign leave tile$")
	public void i_click_on_assign_leave_tile() throws Throwable {
//		driver = initializeBrowser();
		AssignLeavePage al = new AssignLeavePage(driver);
		al.getAssignLeaveTile().click();
	}

	@And("^I select value \"([^\"]*)\" from Employee name auto suggest dropdown in assign leave page$")
	public void i_select_value_something_from_employee_name_auto_suggest_dropdown(String strArg1) throws Throwable {
		AssignLeavePage al = new AssignLeavePage(driver);
		al.getEmployeeName().sendKeys(strArg1);
		al.getEmployeeName().sendKeys(Keys.TAB);
	}

	@And("^I select value \"([^\"]*)\" from leave type dropdown in assign leave page$")
	public void i_select_value_something_from_leave_type_dropdown(String strArg1) throws Throwable {
		AssignLeavePage al = new AssignLeavePage(driver);
		Select dropdown = new Select(al.getLeaveTypeDropdown());
		dropdown.selectByVisibleText(strArg1);
	}

	@And("^I click on view details link and validate pop up data in assign leave page$")
	public void i_click_on_view_details_link_and_validate_pop_up_data() throws Throwable {
		AssignLeavePage al = new AssignLeavePage(driver);
		al.getViewDetailLink().click();
		String window = driver.getWindowHandle();
		System.out.println("window: " + window);
		driver.switchTo().window(window);
		driver.findElement(By.cssSelector("div[id='balance_details'] input[id='closeButton']")).click();
	}

	@And("^I select date from From Date date picker in assign leave page$")
	public void i_select_date_from_from_date_date_picker() throws Throwable {
		AssignLeavePage al = new AssignLeavePage(driver);
		al.getFromDate().click();
		al.getFromDate().sendKeys("2021-12-01");
		al.getFromDate().sendKeys(Keys.ENTER);
	}

	@And("^I select date from To Date date picker in assign leave page$")
	public void i_select_date_from_to_date_date_picker() throws Throwable {
		AssignLeavePage al = new AssignLeavePage(driver);
		al.getToDate().clear();
		al.getToDate().click();
		al.getToDate().sendKeys("2021-12-02");
		al.getToDate().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	@And("^I click on assign button in assign leave page$")
	public void i_click_on_assign_button() throws Throwable {
		AssignLeavePage al = new AssignLeavePage(driver);
		al.getAssignButton().click();
	}

	@And("^I click on Ok button in assign leave page$")
	public void i_click_on_ok_button() throws Throwable {
		AssignLeavePage al = new AssignLeavePage(driver);
		String window = driver.getWindowHandle();
		System.out.println("window: " + window);
		driver.switchTo().window(window);
		al.getOkButton().click();
	}

	@And("^I click on Recruitment tab$")
	public void i_click_on_recruitment_tab() throws Throwable {
		RecruitmentPage rp = new RecruitmentPage(driver);
		rp.getRecruitmentTile().click();
	}

	@And("^I click on Search button in recruitment page$")
	public void i_click_on_search_button_in_recruitment_page() throws Throwable {
		RecruitmentPage rp = new RecruitmentPage(driver);
		rp.getSearchButton().click();
	}
	
	@Then("^I validate search results retreive \"([^\"]*)\" records in recruitment page$")
    public void i_validate_search_results_retreive_something_records_in_recruitment_page(String strArg1) throws Throwable {
		RecruitmentPage rp = new RecruitmentPage(driver);
		int records = Integer.parseInt(strArg1);
		System.out.println(rp.getRecords());
		Assert.assertTrue(rp.getRecords() > records);
    }
	
	@And("^I select value (.+) from job title dropdown in recruitment page$")
    public void i_select_value_from_job_title_dropdown_in_recruitment_page(String jobtitle) throws Throwable {
		RecruitmentPage rp = new RecruitmentPage(driver);
		Select dropdown = new Select(rp.getJobTitle());
		dropdown.selectByVisibleText(jobtitle);
		Thread.sleep(2000);
    }
	
	@And("^I select value (.+) from vacancy dropdown in recruitment page$")
    public void i_select_value_from_vacancy_dropdown_in_recruitment_page(String vacancy) throws Throwable {
		RecruitmentPage rp = new RecruitmentPage(driver);
		Select dropdown = new Select(rp.getVacancy());
		dropdown.selectByVisibleText(vacancy);
		Thread.sleep(2000);
    }

    @And("^I select value (.+) from hiring manager dropdown in recruitment page$")
    public void i_select_value_from_hiring_manager_dropdown_in_recruitment_page(String hiringmanager) throws Throwable {
    	RecruitmentPage rp = new RecruitmentPage(driver);
		Select dropdown = new Select(rp.getHiringManager());
		dropdown.selectByVisibleText(hiringmanager);
		Thread.sleep(2000);
    }
    
    @Then("^I validate search results retreive (.+) records for specific search in recruitment page$")
    public void i_validate_search_results_retreive_records_for_specific_search_in_recruitment_page(String records) throws Throwable {
    	RecruitmentPage rp = new RecruitmentPage(driver);
		int rows = Integer.parseInt(records);
		System.out.println(rp.getRecords());
		Assert.assertTrue(rp.getRecords() > rows);
    }

	@After
	public void tearDown() {
		driver.close();
	}

}
