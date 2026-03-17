package com.PracticeOrgTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.objectrepositoryutility.ContactinformationPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class SampleContact extends BaseClass {

	// read the data from excelFile
	ExcelUtility excelUtility = new ExcelUtility();
	JavaUtility jlib = new JavaUtility();
	WebDriverUtility wutil = new WebDriverUtility();

	@Test(groups="ST")
	public void SampleContactTest() throws EncryptedDocumentException, IOException {

		String lastName = excelUtility.getDataFromExcel("TSData", 1, 1) + jlib.getRandomNumber();

		// click on create contact
		HomePage hp = new HomePage(driver);
		hp.getContactsEdt().click();
		hp.getCreateNewEdt().click();

		// create and save the contact
		CreateNewContactPage createNew = new CreateNewContactPage(driver);
		createNew.getLastNameEdt().sendKeys(lastName);
		createNew.getSaveEdt().click();

		// verify the create contacted test
		ContactinformationPage contactInfo = new ContactinformationPage(driver);
		String actLastName = contactInfo.getConatcedCraetedEdt().getText();

		if (actLastName.contains(actLastName)) {
			System.out.println("=== pass ===");
		} else {
			System.out.println("==fail==");
		}
	}

	@Test(groups="RT")
	public void SampleContactwithFirstNameTest() throws EncryptedDocumentException, IOException {
		String lastName = excelUtility.getDataFromExcel("TSData", 1, 1) + jlib.getRandomNumber();
		String firstName = excelUtility.getDataFromExcel("TSData", 1, 2) + jlib.getRandomNumber();

		// click on create contact
		HomePage hp = new HomePage(driver);
		hp.getContactsEdt().click();
		hp.getCreateNewEdt().click();

		// create and save the contact
		CreateNewContactPage createNew = new CreateNewContactPage(driver);
		WebElement firstNameElement = createNew.getFirstNameEdt();
		firstNameElement.click();
		firstNameElement.sendKeys(firstName);
		createNew.getLastNameEdt().sendKeys(lastName);
		createNew.getSaveEdt().click();

		// verify the create contacted test
		ContactinformationPage contactInfo = new ContactinformationPage(driver);
		String actLastName = contactInfo.getConatcedCraetedEdt().getText();

		if (actLastName.contains(lastName)) {
			System.out.println("=== pass ===");
		} else {
			System.out.println("==fail==");
		}
		contactInfo.getDeletEdt();
		System.out.println("deleted");
	}

}
