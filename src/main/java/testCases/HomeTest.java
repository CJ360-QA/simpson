package testCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.HomePage;

public class HomeTest extends BaseClass{

	
	//@Parameters ({"url", "browser"})
	@Test
	public void t1() {
		HomePage hp=new HomePage();
		hp.signup(prop.getProperty("username"), prop.getProperty("password"));
		hp.verifyTitle();
	}
	
}
