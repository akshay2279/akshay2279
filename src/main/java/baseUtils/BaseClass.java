package baseUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utilities.PropertyUtils;

public class BaseClass {

	public static WebDriver driver =null;
	public static ExtentReports report= null;
	public static ExtentSparkReporter spark=null;
	public static ExtentTest test=null;
	
	Logger log = Logger.getLogger(BaseClass.class);
	
	public void initialization()throws Exception {
		
		System.out.println("Reading property file for browser");// console
		log.info("Reading property file for browser");// file 
		
		String browserName= PropertyUtils.readProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(PropertyUtils.readProperty("url"));
		
	}
	
//	public void waitforElementToAppear(By findby)
//	{
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
//	}
	
	public void reportInit() {
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReports.html");
		report.attachReporter(spark);
	}
	
	public void sendKeysWebElement(WebElement ele, String text)
	{
	}
	
	public void screenshotUtils() throws IOException
	{
		 // Taking a screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the destination file path
        File destinationFile = new File("path/to/save/screenshot.png");

        // Copy the screenshot to the destination file
        Files.copy(screenshot.toPath(), destinationFile.toPath());

        System.out.println("Screenshot saved to: " + destinationFile.getAbsolutePath());

	}
	
	public void mouseHover()
	{
        // Locate the element to hover over
       // WebElement elementToHover = driver.findElement(By.id("hoverElementId"));

        // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform the hover action
      //  actions.moveToElement(elementToHover).perform();

        // Optionally, you can perform additional actions like clicking on a sub-element
        WebElement subElement = driver.findElement(By.id("subElementId"));
        actions.moveToElement(subElement).click().perform();
	}
	
	public void click(WebDriver driver, WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();

	}
	
	
	
    @AfterSuite 
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
}
