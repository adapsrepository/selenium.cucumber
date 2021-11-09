package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	By dashBoardTab = By.xpath("//b[normalize-space()='Dashboard']");
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getDashBoardTab() {
		return driver.findElement(dashBoardTab);
	}

}
