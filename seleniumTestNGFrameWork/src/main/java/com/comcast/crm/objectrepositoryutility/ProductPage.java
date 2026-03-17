package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createProductEdt;

	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchBtn;

}
