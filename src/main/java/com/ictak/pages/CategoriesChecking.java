package com.ictak.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CategoriesChecking {
	
	 private WebDriver driver;
	 private WebDriverWait wait;

	    public CategoriesChecking(WebDriver driver) 
	    {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    }

	    public void categoriesClick() 
	    {
	            WebElement catButton = driver.findElement(By.xpath("//p[normalize-space()='Categories']"));
	            catButton.click();        
	    }
	    
	    public void categoriesChecking(String cname) 
	    {
	        try 
	        {
	          WebElement dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + cname + "']")));
	          dropdownOption.click();
	          System.out.println("Newly added category is displayed on page");
	         
	     } 
	      catch (Exception e) 
	        {
	    	  System.out.println("Newly added category is not displayed on page");
	        }
	    }
	    
	    
	    public String getStitle() 
		{
	        WebElement cTitle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[normalize-space()]")));
	        return cTitle.getText();
		}
}
