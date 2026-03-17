package com.PracticeOrgTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateOrgTestUsingPomTechinque {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		
		//login to app
		//i should write this in all class so create constructor (500 pages 500 lines)
	//	LoginPage lp = PageFactory.initElements(driver, LoginPage.class);  //init at runtime to we should pass the session id and pom classs page
		LoginPage lp = new LoginPage(driver);
	//	lp.loginToapp("admin", "admin");
		
		//step-2 navigation to Organization module
		
		//step-3 click on "create Organization" button
		
		//step-4 enter all the details and create new 
		
		//step verify header 
		
	}
	
}
