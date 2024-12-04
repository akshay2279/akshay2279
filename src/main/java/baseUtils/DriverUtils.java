package baseUtils;

import java.io.File;

import java.io.IOException;
import java.time.Duration;

import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.android.AndroidDriver;

public class DriverUtils extends BaseClassMobile {
static WebDriver driver = null;

    public static String captureScreenshot(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/src/test/resources/screenshots/" + name + ".jpg";
        File dest = new File(path);
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
    
    public static void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // Scroll up to the top of the page
    public static void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
    }

    // Scroll to a specific element
    public static  void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
	public static void waitforElementToAppear(By findby)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	


//    // Wait for element to be visible
//    public static void waitForElement(WebDriver driver, WebElement element) {
//        new WebDriverWait(driver, 500).until(ExpectedConditions.visibilityOf(element));
//    }
//
//    // Wait for element located by By to be visible
//    public static WebElement waitForElementLocated(WebDriver driver, By by) {
//        return new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(by));
//    }
//
    // Wait for element located by By with timeout
//    public static void waitForElementLocated(WebDriver driver, By locator, Duration timeout) {
//        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
    
//    public static void waitForElement( WebElement element, Duration.ofSeconds(time)) {
//        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
//    }

    // Wait for element with timeout
//    public static void waitForElement( WebElement element, Duration time) {
//        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
//    }
    	
//    	@DataProvider
//    	public static Object[][] dp() throws Exception {
//    	DataFormatter df = new DataFormatter();
//    	FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\com.Hybrid714_TNS\\Excel\\data.xlsx"); 
//    	Workbook wb = WorkbookFactory.create(fis);
//    	Sheet sh = wb.getSheet ("login");
//    	int rows=sh.getLastRowNum();
//    	
//    	String data [][]= new String[rows][2]; 
//    	for(int i=1;i<=rows;i++) {
//    		
//    	Cell c1= sh.getRow(i).getCell(0);        //username
//    	Cell c2 = sh.getRow(i).getCell(1);    //password 
//    	String uname = df.formatCellValue(c1); 
//    	String pass = df.formatCellValue(c2);
//    	data[i-1][0] = uname;
//    	data[i-1][1] = pass;
//
//    	}
//    	return data;
//    	
//    	}
       
    }
    
    
//    public static void accesLinks(WebElement element) {
//    	  List <WebElement> Hyperlink = driver.findElements((By) (element));
//    	  for (WebElement link:Hyperlink) {
//    	   System.out.println(link.getText());
//    	  }
    	 

