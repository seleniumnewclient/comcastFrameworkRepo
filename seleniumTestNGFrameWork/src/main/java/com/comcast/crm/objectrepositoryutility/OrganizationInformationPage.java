package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organizationNameEdt;
	
	@FindBy(xpath="//textarea[@name='ship_street']")
	private WebElement shipAddress;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement saveButton;
	
	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}

	public WebElement getShipAddress() {
		return shipAddress;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void ClickSaveButton()
	{
		saveButton.click();
	}
}
