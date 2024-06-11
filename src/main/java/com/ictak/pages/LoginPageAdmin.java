package com.ictak.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageAdmin {

	WebDriver driver;
	
	public LoginPageAdmin(WebDriver driver) {
		this.driver=driver;
	}
	
	public String safeLanding() {
		WebElement home = driver.findElement(By.xpath("//h2[text()='WELCOME TO ICTAK TECH BLOG']"));
		return home.getText();
	}
	
	public void locateDownArrow() {
		WebElement downArrow=driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
		downArrow.click();			
	}
	
	public void locateLogin() {
		WebElement findLogin = driver.findElement(By.xpath("//a[text()='Login']"));
		findLogin.click();
	}
	
	public void locateSignUp() {
		WebElement findLogin = driver.findElement(By.xpath("//a[text()='Signup']"));
		findLogin.click();
	}
	
	public void setEmailId(String email) {
		WebElement user = driver.findElement(By.id("user"));
		user.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		WebElement pword = driver.findElement(By.id("pwd"));
		pword.clear();
		pword.sendKeys(pwd);
	}
	
	public void loginClick() {
		driver.findElement(By.xpath("//button[@id='logbut']")).click();
	}
	
	public String adminLoginCheck() {
		return driver.findElement(By.xpath("//h2[text()='All Posts']")).getText();
	}
	
	public void adminLogout() {
		WebElement logout=driver.findElement(By.xpath("//a[text()='logout']"));
		logout.click();
		
	}
}
