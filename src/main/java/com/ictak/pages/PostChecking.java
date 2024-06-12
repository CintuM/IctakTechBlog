package com.ictak.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostChecking 
{
	WebDriver driver;
	private WebDriverWait wait;
		
		public PostChecking (WebDriver driver)
		{
			this.driver=driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		}
		
		public void allpostClick() 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
			wait.until(ExpectedConditions.urlContains("http://64.227.132.106/comment"));
			String currentUrl = driver.getCurrentUrl();
			
			if (currentUrl.contains("http://64.227.132.106/comment")) 
			{
	            driver.navigate().to("http://64.227.132.106/admin");
	            wait.until(ExpectedConditions.urlToBe("http://64.227.132.106/admin"));
	            System.out.println("Url  changed to : http://64.227.132.106/admin ");
			}	
			else
			{
		      System.out.println("Url in not changed");
		    }
		}
		
		public void getPostChecking(String wordToCheck1) throws InterruptedException 
		{
	        Thread.sleep(5000);
	        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[normalize-space()='"+ wordToCheck1 +"']")));
	        String actres = submit.getText();
	        if (actres.contains(wordToCheck1)) 
	        {
	            System.out.println("Found post with title '" + wordToCheck1 + "'");
	            
	        } 
	        else 
	        {
	            System.out.println("There no post with title '" + wordToCheck1 + "'");
	        }	      
		}
		
		public String getPostTitle(String wordToCheck1) throws InterruptedException 
		{
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[normalize-space()='"+ wordToCheck1 +"']")));    
		return submit.getText();
		}
	
}
