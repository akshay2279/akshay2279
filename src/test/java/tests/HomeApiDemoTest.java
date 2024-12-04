package tests;

import org.testng.annotations.Test;

import baseUtils.BaseClassMobile;
import pages.HomeApiDemoApp;





public class HomeApiDemoTest extends BaseClassMobile
{
	
	//AndroidDriver driver;
	//HomePage hp = null;
	//LoginSwagAppPageObject	lp = new LoginSwagAppPageObject( driver);
	//LoginPageSwagApp lps = new LoginPageSwagApp(driver);

	@Test(groups = { "sanity","regression"}, priority = 1)
	public void test01() throws Exception
	{
		
		
	Thread.sleep(2000);
	//lps.enterUsernameSwagApp("standard_user");
	HomeApiDemoApp lps = new HomeApiDemoApp(driver);

	lps.clickLogin();
	}

}
