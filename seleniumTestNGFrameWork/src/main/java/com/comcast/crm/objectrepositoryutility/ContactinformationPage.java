package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactinformationPage {

	WebDriver driver;         //if it is global i can access this anywhere
	public ContactinformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement conatcedCraetedEdt;
	
	public WebElement getConatcedCraetedEdt() {
		return conatcedCraetedEdt;
	}
	
	@FindBy(name="Delete")
	private WebElement deletEdt;
	public WebElement getDeletEdt() {
		return deletEdt;
	}
	
}
