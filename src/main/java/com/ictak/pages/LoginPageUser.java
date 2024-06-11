package com.ictak.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPageUser {

WebDriver driver;
	
	public LoginPageUser(WebDriver driver) {
		this.driver=driver;
	}
	
	public void locateDownArrow() {
		WebElement downArrow=driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
		downArrow.click();			
	}
		
	public void locateSignUp() {
		WebElement findLogin = driver.findElement(By.xpath("//a[text()='Signup']"));
		findLogin.click();
	}
	
	public void setName(String name) {
		WebElement uname = driver.findElement(By.id("first"));
		uname.sendKeys(name); 
	}
	
	public void setRole(String role) {
		WebElement erole = driver.findElement(By.xpath("//option[text()='user']"));
		erole.click();
	}
	
	public void setEmail(String email) {
		WebElement mail = driver.findElement(By.id("em"));
		mail.sendKeys(email); 
	}
	
	public void setPwd(String pw) {
		WebElement pword = driver.findElement(By.id("pw"));
		pword.clear();
		pword.sendKeys(pw); 
	}
	
	public void SignupClick() {
		WebElement submit = driver.findElement(By.xpath("//button[@id='but']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(submit).click().build().perform();
		
		
	}
	
	public void locateLogin() {
		WebElement findLogin = driver.findElement(By.xpath("//a[text()='Login']"));
		findLogin.click();
	}
	
	public void setUser(String email) {
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
	
	public String userLoginCheck() {
		return driver.findElement(By.xpath("//h2[text()='My Posts']")).getText();
	}
	
}
