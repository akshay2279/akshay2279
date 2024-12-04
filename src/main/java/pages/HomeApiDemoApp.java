package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import baseUtils.BaseClassMobile;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeApiDemoApp extends BaseClassMobile {
	 public AndroidDriver driver;
		// constrcutor
		public HomeApiDemoApp(AndroidDriver driver) {
			//super();
			this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this); //
			//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
	   @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Access'ibility\"]")
	    static WebElement accessibiltyBtn;
	
		@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
		static WebElement txt_password;
	
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"LOGIN\"]")
		static WebElement btn_loginbutton;
	
	
	

	
//		public void enterPasswordSwagApp(String username) {
//			txt_password.clear();
//			txt_password.sendKeys(username);
//		}
//	
		public AccessibiltyPage clickLogin() throws InterruptedException {
			accessibiltyBtn.click();
			return new AccessibiltyPage(driver);

	    }
//		}
	
}

