package com.ictak.pages;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CategoriesAdding {

    private WebDriver driver;
    private WebDriverWait wait;

    public CategoriesAdding(WebDriver driver) 
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void addCategoriesClick() 
    {
       wait.until(ExpectedConditions.urlContains("http://64.227.132.106/admin"));
       String currentUrl = driver.getCurrentUrl();
       if 
        (currentUrl.contains("http://64.227.132.106/admin")) 
       {
        WebElement button1 = driver.findElement(By.xpath("//p[normalize-space()='Actions']"));
        button1.click();
        WebElement pendingApprovalsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add/Remove category']")));
        pendingApprovalsLink.click();
        } 
       		else 
       		{
       			System.out.println("Error: URL not changed to : http://64.227.132.106/admin ");
       		}
    }

    public void setCategories(String cat)
    {
        WebElement catName = driver.findElement(By.xpath("//input[@placeholder='Enter new category name']"));
        catName.sendKeys(cat);
    }

    public void addClick() 
    {
        WebElement addButton = driver.findElement(By.xpath("/html/body/app-root/app-category/div/form/button"));
        addButton.click();
    }

    public String getAlert() 
    {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }
    
    public void categoriesAddinghandleAlert() 
    {
    	
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    String actualAlertMessage = alert.getText();
    alert.accept();
   // System.out.println("alert: " + ex.getMessage());
    }
    
    
}

