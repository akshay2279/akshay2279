package baseUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

public class BaseClassMobile 

{
 protected static AndroidDriver driver = null;
 
	//LoginSwagAppPageObject	lp = new LoginSwagAppPageObject( driver);

	@BeforeTest
	 public void setup() throws MalformedURLException
		{
			UiAutomator2Options options = new UiAutomator2Options();
			options.setPlatformName("Android");
			options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
			options.setDeviceName("RZCWA0HGVYR");
			//options.setApp("C:\\Users\\Lenovo\\eclipse-workspace\\AndroidDemoIshaProject\\src\\test\\resources\\UATDemoPhonePeApp.apk");
//			options.setAppActivity("com.phonepe.intentsdk.demoapp.uat");
//			options.setAppPackage("com.phonepe.intentsdk.demoapp.MainActivity");
			//options.NO_RESET_OPTION
			options.setNoReset(false);

			options.setAppPackage("io.appium.android.apis");
			options.setAppActivity("io.appium.android.apis.ApiDemos");
			
			//URL = "http://127.0.0.1:4723";
			// driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
			 driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);

		        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

				//PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	       // AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		}
//	@Test
//	public void test01() throws Exception
//	{
//	Thread.sleep(1000);
//	//lp.validLogin01();
//	}
	
	 public static void scrollToElement(AndroidDriver driver, String text) {
	  
	    	
		 driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
		            ".scrollIntoView(new UiSelector().text(\"" + text + "\"));")).click(); 
	      
//	      driver.findElementByAndroidUIAutomator(
//	            "new UiScrollable(new UiSelector().scrollable(true))" +
//	            ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"
//	        );
	    }  
	 
	 public static Point getCenterElement (Point location, Dimension dim) {
			return new Point(location.getX() + dim.getWidth()/2, location.getY()+ dim.getHeight() / 2);
			
		}
		
			public static void doubleTap (AndroidDriver driver, WebElement element){
			//Perform a double tap action
			Point location = element.getLocation();
			Dimension size = element.getSize();
			Point centerofelement
			= getCenterElement (location, size);
			PointerInput touchaction1 = new PointerInput(PointerInput.Kind.TOUCH,"fingertouch1"); 
			Sequence seq = new Sequence (touchaction1, 1)
			.addAction(touchaction1.createPointerMove(Duration. ZERO, PointerInput.Origin.viewport(), centerofelement)) 
			.addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg())) 
			.addAction(new Pause(touchaction1, Duration.ofMillis (5000)))
			.addAction(touchaction1.createPointerUp (PointerInput.MouseButton.LEFT.asArg())) 
			.addAction (new Pause(touchaction1, Duration.ofMillis (5880)))
			.addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			driver.perform(Collections.singletonList (seq)); 
			System.out.println("-----Double tap Execution complete-------");
			
	    }
			
			public static void longPress (AndroidDriver driver, WebElement element){
				//Perform a double tap action
				Point location = element.getLocation();
				Dimension size = element.getSize();
				Point centerofelement
				= getCenterElement (location, size);
				PointerInput touchaction1 = new PointerInput(PointerInput.Kind.TOUCH,"fingertouch1"); 
				Sequence seq = new Sequence (touchaction1, 1)
				.addAction(touchaction1.createPointerMove(Duration. ZERO, PointerInput.Origin.viewport(), centerofelement)) 
				.addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg())) 
				.addAction(new Pause(touchaction1, Duration.ofSeconds (3)))
				.addAction(touchaction1.createPointerUp (PointerInput.MouseButton.LEFT.asArg())) ;
//			
				driver.perform(Collections.singletonList (seq)); 
				System.out.println("-----LongPress Execution complete-------");
				
		    }
}


