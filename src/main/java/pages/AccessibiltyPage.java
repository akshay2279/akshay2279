package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import baseUtils.BaseClassMobileOld;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class AccessibiltyPage 
{
	public AndroidDriver driver;
	public  AccessibiltyPage(AndroidDriver driver)
	{
		super();
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //
		//PageFactory.initElements(driver, this);	
	}
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Accessibility Node Querying\"]")
	WebElement accessibiltyNodeQueryingBtn;
	
	public ViewsPage accessibilty01() throws Exception
	{
		accessibiltyNodeQueryingBtn.click();
		driver.navigate().back();
		driver.navigate().back();

		return new ViewsPage(driver);
		
}
}
