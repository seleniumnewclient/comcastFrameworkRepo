package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInformationPage {
	WebDriver driver;
	public OrgInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindAll({ @FindBy(xpath="//span[@class='dvHeaderText']"), @FindBy(xpath="//tr//td//span[@class='dvHeaderText']")})
	private WebElement actualOrgName;
	
	public WebElement getActualOrgName() {
		return actualOrgName;
	}

}
