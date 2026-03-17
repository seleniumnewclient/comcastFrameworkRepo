package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//web driver specific actions keep in this utility
public class WebDriverUtility {
	
	public void waitForPageToLoad(WebDriver driver)
	//in test script i m writing to launch the browser,thats session is available in test script,
	//if we dont pass driver obj ,for which browser i want to wait?
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabOnURL(WebDriver driver,String partialURL)
	{
		Set<String> set = driver.getWindowHandles();  //not index based
		Iterator<String> it = set.iterator(); //take help of iterator to capture the data from set
		
		while(it.hasNext())  //using 
		{
			String windowID = it.next();  //caputure the first windowid 
			driver.switchTo().window(windowID);  //switch 
			
			String actUrl = driver.getCurrentUrl();  //getcurrent url
			if(actUrl.contains(partialURL))    //compare it
			{
				break;
			}
		}
	}
	
	public void switchToTabOnTitle(WebDriver driver,String partialTitle)
	{
		Set<String> set = driver.getWindowHandles();  //not index based
		Iterator<String> it = set.iterator(); //take help of iterator to capture the data from set
		
		while(it.hasNext())  //using 
		{
			String windowID = it.next();  //caputure the first windowid 
			driver.switchTo().window(windowID);  //switch 
			
			String actUrl = driver.getTitle();  //getcurrent url
			if(actUrl.contains(partialTitle))    //compare it
			{
				break;
			}
		}
	}
	
	public void switchToFrame(WebDriver driver ,int index)
	{
	 driver.switchTo().frame(index);	
	}
	
	public void switchToFrameBasedOnNameOrId(WebDriver driver ,String NameID)
	{
	 driver.switchTo().frame(NameID);	
	}
	public void switchToFrame(WebDriver driver ,WebElement element)
	{
	 driver.switchTo().frame(element);	
	}
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void select(WebElement element,String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void select(WebElement element ,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void mousemoveOnElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();;
	}
	
	public void doubleclick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	

	public WebDriver openBrowser(String browserValue)
	{
		WebDriver driver =null;
		if (browserValue.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserValue.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserValue.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}


