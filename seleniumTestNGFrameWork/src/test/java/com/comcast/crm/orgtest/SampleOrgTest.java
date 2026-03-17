package com.comcast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrgPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;

public class SampleOrgTest extends BaseClass {

	// generic utilities
	ExcelUtility excelUtility = new ExcelUtility();
	JavaUtility jlib = new JavaUtility();
	WebDriverUtility wutil = new WebDriverUtility();

	@Test(groups="ST")
	public void CreateOrgTest() throws EncryptedDocumentException, IOException {
		// click on create new organization
		CreateNewOrgPage createNewOrg = new CreateNewOrgPage(driver);
		createNewOrg.getOrganizationEdt().click();
		createNewOrg.getCreateNewOrganization().click();

		String orgName = excelUtility.getDataFromExcel("TSData", 4, 1) + jlib.getRandomNumber();
		String shipAddress = excelUtility.getDataFromExcel("TSData", 4, 2);
		
		// create new organization
		OrganizationInformationPage orgNew = new OrganizationInformationPage(driver);
		orgNew.getOrganizationNameEdt().sendKeys(orgName);
		orgNew.getShipAddress().sendKeys(shipAddress);
		orgNew.getSaveButton().click();

		// verify orgname
/*		OrgInformationPage orginfo = new OrgInformationPage(driver);
		String actualOrganizationName = orginfo.getActualOrgName().getText();
		if (actualOrganizationName.contains(orgName)) {
			System.out.println("=== pass ===");
		} else {
			System.out.println("==fail==");
		}
 */
	}

}
