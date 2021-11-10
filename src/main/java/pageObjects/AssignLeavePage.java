package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssignLeavePage {
public WebDriver driver;
	
	By employeeName = By.cssSelector("input[name=\"assignleave[txtEmployee][empName]\"]");
	By assignLeaveTile = By.xpath("//span[text()='Assign Leave']");
	By loginButton = By.cssSelector("input[value=LOGIN]");
	By assignButton = By.cssSelector("#assignBtn");
	By leaveTypeDropdown = By.cssSelector("select[name=\"assignleave[txtLeaveType]\"]");
	By viewDetailLink = By.cssSelector("#leaveBalance_details_link");
	By fromDate = By.cssSelector("#assignleave_txtFromDate");
	By toDate = By.cssSelector("#assignleave_txtToDate");
	By okButton = By.cssSelector("#confirmOkButton");
	
	public AssignLeavePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public WebElement getAssignLeaveTile() {
		return driver.findElement(assignLeaveTile);
	}

	public WebElement getEmployeeName() {
		return driver.findElement(employeeName);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
	
	public WebElement getAssignButton() {
		return driver.findElement(assignButton);
	}
	
	public WebElement getLeaveTypeDropdown() {
		return driver.findElement(leaveTypeDropdown);
	}
	
	public WebElement getViewDetailLink() {
		return driver.findElement(viewDetailLink);
	}
	
	public WebElement getFromDate() {
		return driver.findElement(fromDate);
	}

	
	public WebElement getToDate() {
		return driver.findElement(toDate);
	}
	
	public WebElement getOkButton() {
		return driver.findElement(okButton);
	}


}
