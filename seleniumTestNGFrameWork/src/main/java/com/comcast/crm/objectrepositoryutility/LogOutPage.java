package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LogOutPage {

	  @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	    private WebElement profile;

	    public WebElement getProfile() {
		return profile;
	}

	  public WebElement getSignOut() {
		  return signOut;
	  }

		@FindBy(linkText="Sign Out")
	    private WebElement signOut;

	    public LogOutPage(WebDriver driver)
	    {
	        PageFactory.initElements(driver, this);
	    }

	    public void logOutFromApp(WebDriver driver)
	    {
	        WebDriverUtility webUtil = new WebDriverUtility();
	        webUtil.mousemoveOnElement(driver, profile);
	        signOut.click();
	    }

}
