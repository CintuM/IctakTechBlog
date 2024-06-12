package com.ictak.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LikeOption
{
		
	WebDriver driver;
	private WebDriverWait wait;
	
	public LikeOption (WebDriver driver)
	{
		this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void likeOptionChecking()
	{
		
        String searchText = "Like";
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
	
	public String getTitle1() throws InterruptedException
	{
        WebElement text = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text()]")));
        return text.getText();
	}

}
	