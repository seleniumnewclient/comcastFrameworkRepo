package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	WebDriver driver;         //if it is global i can access this anywhere
	public CreateNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="firstname")
	private WebElement firstNameEdt;
	
	public WebElement getFirstNameEdt() {
		return firstNameEdt;
	}

	@FindBy(name="lastname")
	private WebElement lastNameEdt;

	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement saveEdt;

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveEdt() {
		return saveEdt;
	}
}
