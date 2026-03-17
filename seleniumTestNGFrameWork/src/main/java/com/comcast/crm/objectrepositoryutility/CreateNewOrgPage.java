package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgPage {
	
	WebDriver driver;
	public CreateNewOrgPage(WebDriver driver)
	{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		
	}

	@FindBy(linkText ="Organizations")
	private WebElement organizationEdt;
	

	@FindBy(xpath ="//img[@title='Create Organization...']")
	private WebElement createNewOrganization;


	public WebElement getOrganizationEdt() {
		return organizationEdt;
	}

	public WebElement getCreateNewOrganization() {
		return createNewOrganization;
	}
}

