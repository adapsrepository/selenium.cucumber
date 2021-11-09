package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public Properties property;
	@SuppressWarnings("deprecation")
	public WebDriver initializeBrowser() throws IOException {
		property = new Properties();
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		property.load(fi);
		
		//it will get the browser property from mvn command when we use mvn command - mvn test -Dbrowser=chrome
		String browser = System.getProperty("browser");
		
		//it will get the property from properties file
		//String browser = property.getProperty("browser");
		
		System.out.println(browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.driver", "C:\\selenium-drivers\\chromedriver.exe"); 
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
