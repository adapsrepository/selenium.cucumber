package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By username = By.xpath("//input[@id='txtUsername']");
	By password = By.xpath("//input[@id='txtPassword']");
	By loginButton = By.xpath("//input[@id='btnLogin']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getUsername() {
		return driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}

}
