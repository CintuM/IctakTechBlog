package com.ictak.pages;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminApprove {
	
WebDriver driver;
private WebDriverWait wait;
	
	public AdminApprove (WebDriver driver)
	{
		this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}
	
	public void actionsClick() throws InterruptedException
	{
        WebElement action = driver.findElement(By.xpath("//p[normalize-space()='Actions']"));
		action.click();
        WebElement pendingApprovalsOption = driver.findElement(By.linkText("Pending Approvals"));
        pendingApprovalsOption.click();

	}
	
	public void approveClick(String newposttitle) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		wait.until(ExpectedConditions.urlContains("http://64.227.132.106/approval"));
		String currentUrl = driver.getCurrentUrl();
		
		if 
			(currentUrl.contains("http://64.227.132.106/approval")) 
		{
			Thread.sleep(5000);
			WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='" + newposttitle + "' ]/following::button[1]")));
			Actions actions = new Actions(driver);
			actions.moveToElement(submit).click().build().perform();
			System.out.println("Clicked on Approve button");
		 } 
			else
			{
		      System.out.println("Approve button clicking failed");
		    }
		 
	}
	
	 public String getAlert() 
	    {
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        return alert.getText();
	    }
	 
	public void approvinghandleAlert() throws InterruptedException 
   {
		try{
		
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();
		} 
		catch (Exception ex) 
			{
        System.out.println("alert: " + ex.getMessage());
        
        }
   }
	
}
