package pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseUtils.BaseClassMobile;
import baseUtils.BaseClassMobileOld;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class ViewsPage 
{
	public AndroidDriver driver;
	public  ViewsPage(AndroidDriver driver)
	{
		super();
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //
		//PageFactory.initElements(driver, this);	
	}
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Views\"]")
	WebElement viewsBtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"WebView2\"]")
	List<WebElement> WebView;
	
	@AndroidFindBy(xpath="	//android.widget.TextView[@content-desc=\"Expandable Lists\"]")
	WebElement expandableListsBtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")
	WebElement customAdaptorBtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"People Names\"]")
	WebElement peopleNamesBtn;
	
	
	public void views() throws Exception
	{
		viewsBtn.click();
		
		expandableListsBtn.click();
		customAdaptorBtn.click();
		BaseClassMobile.longPress(driver, peopleNamesBtn);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

		BaseClassMobile.doubleTap(driver, viewsBtn);
		
		BaseClassMobile.scrollToElement(driver, "WebView2");
		
}
}
