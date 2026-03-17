package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;         //if it is global i can access this anywhere
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(linkText = "Contacts")
	private WebElement contactsEdt;
	
	@FindBy(xpath ="//img[@title='Create Contact...']")
	private WebElement createNewEdt;
	
	public WebElement getContactsEdt() {
		return contactsEdt;
	}

	public WebElement getCreateNewEdt() {
		return createNewEdt;
	}

	

}
