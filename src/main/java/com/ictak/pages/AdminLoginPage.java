package com.ictak.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLoginPage
{

	WebDriver driver;
	
	public AdminLoginPage (WebDriver driver)
	{
		this.driver=driver;
	}
	public void setUsername(String uname)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement usrName=driver.findElement(By.xpath("//input[@id='user']"));
		usrName.sendKeys(uname);
	}
	
	public void setPassword(String pass)
	{
	WebElement usrPass=driver.findElement(By.xpath("//input[@id='pwd']"));
	usrPass.sendKeys(pass);
	}
	

	public void loginClick()
	{
		WebElement button = driver.findElement(By.xpath("//button[@id='logbut']"));
		button.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	}

	public String gethomeurl() throws InterruptedException
	{
		Thread.sleep(1000);
        return driver.getCurrentUrl();
	}
	
}

