package com.ictak.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BlogCreationUser {
	
WebDriver driver;
	
	public BlogCreationUser(WebDriver driver) {
		this.driver=driver;
	}
	
	public void createBlog(String bTitle, String url,String post, String role) {
		WebElement newPost = driver.findElement(By.xpath("//a[text()='New post']"));
		newPost.click();
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
		
		WebElement title = driver.findElement(By.name("P_title"));
		title.sendKeys(bTitle);
		
		WebElement image = driver.findElement(By.name("P_image"));
		image.sendKeys(url);
		
//		WebElement cat = driver.findElement(By.name("p_cat"));
//		cat.click();
//		WebElement selectCat = driver.findElement(By.xpath("//option[text()='PROJECTDEC']"));
//		selectCat.click();
		
		Select dropdown = new Select(driver.findElement(By.name("p_cat")));
		dropdown.selectByVisibleText("PROJECTDEC");
		
		
		WebElement upost = driver.findElement(By.name("p_post"));
		upost.sendKeys(post);
		
		if(role.equalsIgnoreCase("trainer")) {
			WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(submit).click().build().perform();
		}		
		else {
			WebElement submit = driver.findElement(By.xpath("//button[text()='Send for approval']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(submit).click().build().perform();
		}
	}
	
	public boolean pendingApproval() {
		WebElement actions = driver.findElement(By.xpath("(//a[@id='navbarDropdown' and @aria-expanded='false'])[1]"));
		actions.click();
//		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
		WebElement pendingApproval = driver.findElement(By.xpath("//a[text()='Pending Approvals']"));
		pendingApproval.click();
//		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
		try {
			WebElement pendingPost = driver.findElement(By.xpath("//h5[text()='Selenium Tool1']"));
			return true;
		}
		catch (NoSuchElementException e){
			System.out.println("Searched post is not pending for admin's approval !!");
			return false;
		}		
	}
	
	public boolean posts (String role) {
		WebElement home = driver.findElement(By.xpath("(//a[text()='Home'])[1]"));
		home.click();
		if (role.equalsIgnoreCase("Trainer")) {
		try {
			WebElement allPosts = driver.findElement(By.xpath("//h5[text()='Selenium Tools By Trainer']"));
			return false;
		}
		catch (NoSuchElementException e){
			System.out.println("Searched post of trainer is not available without admin's approval !!");
			return true;
		}
		}
		else if (role.equalsIgnoreCase("User")) {
			try {
				WebElement allPosts = driver.findElement(By.xpath("//h5[text()='Selenium Tools By User']"));
				return false;
			}
			catch (NoSuchElementException e){
				System.out.println("Searched post of user is not available without admin's approval !!");
				return true;
			}
		}
		else {
			System.out.println("Error occured in search of pending posts in home module.");
			return false;
		}

		
	}

}
