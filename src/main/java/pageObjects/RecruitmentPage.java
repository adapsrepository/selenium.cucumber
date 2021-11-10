package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecruitmentPage {
public WebDriver driver;
	
	By searchButton = By.cssSelector("#btnSrch");
	By recruitmentTile = By.xpath("//b[text()='Recruitment']");
	By jobTitle = By.cssSelector("#candidateSearch_jobTitle");
	By vacancy = By.cssSelector("#candidateSearch_jobVacancy");
	By hiringManager = By.cssSelector("#candidateSearch_hiringManager");
	By records = By.cssSelector("tbody tr");
	
	public RecruitmentPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public WebElement getRecruitmentTile() {
		return driver.findElement(recruitmentTile);
	}

	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
	}
	
	public WebElement getJobTitle() {
		return driver.findElement(jobTitle);
	}
	
	public WebElement getVacancy() {
		return driver.findElement(vacancy);
	}
	
	public WebElement getHiringManager() {
		return driver.findElement(hiringManager);
	}
	
	public int getRecords() {
		return driver.findElements(records).size();
	}
	
}
