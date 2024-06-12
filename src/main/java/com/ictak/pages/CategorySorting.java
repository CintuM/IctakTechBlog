package com.ictak.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategorySorting 
{

	private WebDriver driver;
	private WebDriverWait wait;

	 public CategorySorting(WebDriver driver) 
	   {
	     this.driver = driver;
	     this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   }

	public void categoryClick() 
		{
			WebElement category = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='Categories']")));
			category.click();

		}
	
	public void testclick(String cname) 
    {
          WebElement dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+cname+"']")));
          dropdownOption.click();
     
     } 
	
	public String categoryChecking(String wordToCheck) throws InterruptedException
		{
	        Thread.sleep(5000);
	        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[normalize-space()='"+ wordToCheck+"']")));
	        String actres = submit.getText();
	        if (actres.contains(wordToCheck)) {
	            System.out.println("The word '" + wordToCheck + "' is present on the page.");
	        } else {
	            System.out.println("The word '" + wordToCheck + "' is not present on the page.");
	        }

	        return actres;
		}
		
	public String getTitle(String wordToCheck)
	{
    WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[normalize-space()='"+ wordToCheck+"']")));    
	return submit.getText();
	}
}