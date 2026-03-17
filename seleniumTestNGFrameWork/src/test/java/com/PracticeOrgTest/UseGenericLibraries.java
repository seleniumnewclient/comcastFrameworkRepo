package com.PracticeOrgTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseGenericLibraries {

		public static void main(String[] args) {
			String lastName ="preime23"+"eeee";
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			//Navigate and login to CRM
			driver.get("http://49.249.28.218:8888/");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			
			//Navigate to contact and create new contact
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			driver.findElement(By.name("lastname")).sendKeys(lastName);
			driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
			
			//verify the contact
			String headerContactText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerContactText.contains(lastName))
			{
				System.out.println("contians text ==pass==");
			}
			
			

		}

	}

