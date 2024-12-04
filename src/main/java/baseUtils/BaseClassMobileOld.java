package baseUtils;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;


public class BaseClassMobileOld 

{
public  AndroidDriver driver;
	@BeforeTest
      public void setup()
{

   DesiredCapabilities caps = new DesiredCapabilities();
 //   caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
    caps.setCapability("PLATFORM_NAME", "ANDROID");
//    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
//    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M426B/DS");
     caps.setCapability("UDID", "RZCWAOHGVYR");
    caps.setCapability("NEW_COMMAND_TIMEOUT", 60);
    //caps.setCapability(MobileCapabilityType.APP, "");
    //caps.setCapability(MobileCapabilityType.BROWSER_NAME, "CHROME");
    caps.setCapability("appPackage", "com.phonepe.intentsdk.demoapp.uat");
    caps.setCapability("appActivity", "com.phonepe.intentsdk.demoapp.MainActivity");
   // caps.setCapability(MobileCapabilityType.NO_RESET, "false");
    caps.setCapability("NO_RESET", "true");
 
 	try {
		//URL url = new URL("http://127.0.0.0:4723/wd/hub");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		//driver = new AppiumDriver<MobileElement>(url, caps);
		driver = new AndroidDriver(url, caps);
		//?
		
		//driver = new AndroidDriver<MobileElement>(url, caps);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	
}

}
