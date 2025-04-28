package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseClass.BaseClass;

public class HomePage extends BaseClass{

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//div[@Type='text']") WebElement txtuser;
	@FindBy (xpath="//input//div[contains(@class,'text')]") WebElement txtpass ;
	@FindBy (xpath="//span[contains(text()='name')]") WebElement sub ;
	@FindBy (xpath="//span[starts-with(@text='name')]") WebElement dropdown ;
	@FindBy (xpath="//div[text()='name']") WebElement radio ;
	@FindBy (xpath="//input[normalize-space()='text']") WebElement caps;
	@FindBy (xpath="//div[@type='name' and @class='text']") WebElement dd ;
	
	
	public void signup(String name, String pass) {
		txtuser.sendKeys(name);
		txtpass.sendKeys(pass);
		sub.click();
		
		Select slt=new Select(dropdown);
		slt.selectByVisibleText("indian");
		List<WebElement> options= slt.getOptions();
		for(int i=0; i<options.size(); i++) {
			String text=options.get(i).getText();
			if(options.get(i).isEnabled()) {
				System.out.println("enabled"+ text);
			} else {
				System.out.println("disabled"+ text);
			}
		}
		
				
	}
	
	public void verifyTitle() {
		Assert.assertEquals(driver.getTitle(), "store");
		Assert.assertTrue(dd.getText().contains(prop.getProperty("username")));
	}
}
