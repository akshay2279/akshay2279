package tests;

import org.testng.annotations.Test;

import baseUtils.BaseClassMobile;
import baseUtils.BaseClassMobileOld;
import io.appium.java_client.android.AndroidDriver;
import pages.AccessibiltyPage;


public class AccessibiltyTest extends BaseClassMobile
{
	
	//AndroidDriver driver;
	//HomePage hp = null;

	@Test(groups = { "sanity","regression"}, priority = 3)
	public void test01() throws Exception
	{
		AccessibiltyPage	hp = new AccessibiltyPage( driver);

	Thread.sleep(3000);
	hp.accessibilty01();
	}

}
