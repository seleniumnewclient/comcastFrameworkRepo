package com.comcast.crm.baseutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.LogOutPage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {

	protected WebDriver driver;
	public static WebDriver sdriver;
	DataBaseUtility dataBaseUtility = null;
	WebDriverUtility WebDriverUtility = null;
	FileUtility futil = null;
	LoginPage logIn = null;
	LogOutPage logOut = null;

	@BeforeSuite //(groups= {"ST","RT"})
	public void configBS() {
		dataBaseUtility = new DataBaseUtility();
		try {
			dataBaseUtility.getDbConnection("jdbc:mysql://localhost:3306/practice", "root", "root1234");
		} catch (Exception e) {
			System.out.println("db connection is wrong");
		}
	}

	//@Parameters("BROWSER")pass configBC(String browser)
	@BeforeClass  //(groups= {"ST","RT"})   
	public void configBC() throws IOException {
		futil = new FileUtility();
		String browserValue = futil.getDataFromPropertiesFile("browser");

		WebDriverUtility = new WebDriverUtility();

		driver = WebDriverUtility.openBrowser(browserValue);
		sdriver=driver;
	}

	@BeforeMethod //(groups= {"ST","RT"})
	public void configBM() throws IOException {
		 logIn = new LoginPage(driver);

		    String url = futil.getDataFromPropertiesFile("url");
		    String username = futil.getDataFromPropertiesFile("username");
		    String password = futil.getDataFromPropertiesFile("password");

		    driver.get(url);

		    logIn.loginToapp(username, password);
	}

	@AfterMethod //(groups= {"ST","RT"})
	public void configAM() {
		   logOut = new LogOutPage(driver);
		    logOut.logOutFromApp(driver);
	}

	@AfterClass //(groups= {"ST","RT"})
	public void configAC() {
		WebDriverUtility.quitBrowser(driver);
	}

	@AfterSuite   //(groups= {"ST","RT"})
	public void configAS() throws SQLException {
		dataBaseUtility.closeDatabaseConnection();
	}

}
