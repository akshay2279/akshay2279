package tests;

import org.testng.annotations.Test;

import baseUtils.BaseClassMobile;
import baseUtils.BaseClassMobileOld;
import io.appium.java_client.android.AndroidDriver;
import pages.AccessibiltyPage;
import pages.ViewsPage;


public class ViewTest extends BaseClassMobile
{
	
	//AndroidDriver driver;
	//HomePage hp = null;

	@Test(groups = { "sanity"}, priority = 2)
	public void viewtest01() throws Exception
	{
		ViewsPage	vp = new ViewsPage( driver);

	Thread.sleep(3000);
	vp.views();;
	}

}
