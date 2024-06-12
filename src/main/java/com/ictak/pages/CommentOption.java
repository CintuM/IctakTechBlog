package com.ictak.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommentOption 

{

	WebDriver driver;
	private WebDriverWait wait;
	
	public CommentOption (WebDriver driver)
	{
		this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void commentOptionChecking()
	{
        String searchText = "Comment";
        WebElement bodyElement = driver.findElement(By.tagName("body"));
        String bodyText = bodyElement.getText();
        if (bodyText.contains(searchText)) 
        	{
            System.out.println( searchText + "Fond" );
        	} 
        else 
        	{
        		System.out.println("There is no option for: " + searchText);
        	}
		}
		
	public String getTitle2()
	{
        WebElement text = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text()]")));
		return text.getText();

	}
}
	