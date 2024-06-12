package com.ictak.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPageTrainer {
            WebDriver driver;
            private WebDriverWait wait;
  public LoginPageTrainer(WebDriver driver) 
  {
	  this.driver=driver;
	  this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
  }
         //valid credential   
  public void locatedownarrow()
  {
	  WebElement downArrow=driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
	  downArrow.click();
  }
  public void locatesignup()
  {
	  WebElement signup=driver.findElement(By.xpath("//a[text()='Signup']"));
	  signup.click();
  }
  
  public void setusername(String name)
  {
	  WebElement uname=driver.findElement(By.id("first"));
	  uname.sendKeys(name);
  }
  public void setRole(String role)
 {
	  WebElement erole=driver.findElement(By.xpath("//option[text()='trainer']"));
	  erole.click();
 } 
  public void setUndergraduates(String ungrad)
  {
 	  WebElement ungrade=driver.findElement(By.xpath("//option[text()='UNDER GRADUATE']"));
 	  ungrade.click();
  } 
  public void setemailid(String mailid)
  {
	  WebElement emailid=driver.findElement(By.id("em"));
	  emailid.sendKeys(mailid);
  }
  public void setpassword(String pass)
  {
	  WebElement password=driver.findElement(By.id("pw"));
	  password.sendKeys(pass);
  }
  public void loginClick()
  {
	  WebElement loginbutton=driver.findElement(By.xpath("//button[@type='submit']"));
	  loginbutton.click();
  }
  public void submit()
  {
	  WebElement submt=driver.findElement(By.id("but"));
	  submt.click();
  }
  public String getAlert() 
  {
      Alert alert = wait.until(ExpectedConditions.alertIsPresent());
      return alert.getText();
  }
  public void handleAlert() 
  {
//	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//    System.out.println(alert.getText());
//     alert.accept();
	  try{
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        System.out.println(alert.getText());
	        alert.accept();
			} 
			catch (Exception ex) 
				{
	        System.out.println("alert: " + ex.getMessage());
	        
	        }
  }
  //signup with trainer undergraduate 
 public void locatedownarrowu()
 {
  WebElement downArrow=driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
  downArrow.click();
 }
  public void locatesignupu()
  {
	  WebElement signup=driver.findElement(By.xpath("//a[text()='Signup']"));
	  signup.click();
  }
  
  public void setusernameu(String name)
  {
	  WebElement uname=driver.findElement(By.id("first"));
	  uname.sendKeys(name);
  }
  public void setRoleu(String role)
 {
	  WebElement erole=driver.findElement(By.xpath("//option[text()='trainer']"));
	  erole.click();
 } 
  public void setUndergraduate(String ungrad)
  {
 	  WebElement ungrade=driver.findElement(By.xpath("//option[text()='UNDER GRADUATE']"));
 	  ungrade.click();
  } 
  public void setemailidu(String mailid)
  {
	  WebElement emailid=driver.findElement(By.id("em"));
	  emailid.sendKeys(mailid);
  }
  public void setpasswordu(String pass)
  {
	  WebElement password=driver.findElement(By.id("pw"));
	  password.sendKeys(pass);
  }
  public void submitu()
  {
	  WebElement submt=driver.findElement(By.id("but"));
	  submt.click();
  }
//signup with PHD
  public void locatedownarrowp()
  {
	  WebElement downArrow=driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
	  downArrow.click();
  }
  public void locatesignupp()
  {
	  WebElement signup=driver.findElement(By.xpath("//a[text()='Signup']"));
	  signup.click();
  }
  
  public void setusernamep(String name)
  {
	  WebElement uname=driver.findElement(By.id("first"));
	  uname.sendKeys(name);
  }
  public void setRolep(String role)
 {
	  WebElement erole=driver.findElement(By.xpath("//option[text()='trainer']"));
	  erole.click();
 } 
  public void setphd(String phd)
  {
 	  WebElement phdd=driver.findElement(By.xpath("//option[text()='POST GRADUATE']"));
 	  phdd.click();
  } 
  public void setemailidp(String mailid)
  {
	  WebElement emailid=driver.findElement(By.id("em"));
	  emailid.sendKeys(mailid);
  }
  public void setpasswordp(String pass)
  {
	  WebElement password=driver.findElement(By.id("pw"));
	  password.sendKeys(pass);
  }
  public void submitp()
  {
	  WebElement submt=driver.findElement(By.id("but"));
	  submt.click();
  }
  
  //signup with blank password
  public void locatedownarrow1()
 {
	  WebElement downArrow=driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
	  downArrow.click();
  }
  public void locatesignup1()
  {
	  WebElement signup=driver.findElement(By.xpath("//a[text()='Signup']"));
	  signup.click();
  }
  public void setusername1(String name)
  {
	  WebElement uname=driver.findElement(By.id("first"));
	  uname.sendKeys(name);
  }
  public void setRole1(String role)
 {
	  WebElement erole=driver.findElement(By.xpath("//option[text()='trainer']"));
	  erole.click();
 } 
  public void setUndergraduate1(String ungrad)
  {
 	  WebElement ungrade=driver.findElement(By.xpath("//option[text()='UNDER GRADUATE']"));
 	  ungrade.click();
  } 
  public void setemailid1(String mailid)
  {
	  WebElement emailid=driver.findElement(By.id("em"));
	  emailid.sendKeys(mailid);
  }
   public void setpassword1(String pass)
   {
 	  WebElement password=driver.findElement(By.id("pw"));
 	  password.sendKeys(pass);
   }
   public void submit1()
   {
 	  WebElement submt=driver.findElement(By.id("but"));
 	  submt.click();
   }
 //signup with password(nouppercase)
   public void locatedownarrow2()
   {
 	  WebElement downArrow=driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
 	  downArrow.click();
   }
   public void locatesignup2()
   {
 	  WebElement signup=driver.findElement(By.xpath("//a[text()='Signup']"));
 	  signup.click();
   }
   public void setusername2(String name)
   {
 	  WebElement uname=driver.findElement(By.id("first"));
 	  uname.sendKeys(name);
   }
   public void setRole2(String role)
  {
 	  WebElement erole=driver.findElement(By.xpath("//option[text()='trainer']"));
 	  erole.click();
  } 
   public void setUndergraduate2(String ungrad)
   {
  	  WebElement ungrade=driver.findElement(By.xpath("//option[text()='UNDER GRADUATE']"));
  	  ungrade.click();
   } 
   public void setemailid2(String mailid)
   {
 	  WebElement emailid=driver.findElement(By.id("em"));
 	  emailid.sendKeys(mailid);
   }
    public void setpassword2(String pass)
    {
  	  WebElement password=driver.findElement(By.id("pw"));
  	  password.sendKeys(pass);
    }
    public void submit2()
    {
  	  WebElement submt=driver.findElement(By.id("but"));
  	  submt.click();
    }
  //signup with password(nolowercase)
    public void locatedownarrow3()
    {
  	  WebElement downArrow=driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
  	  downArrow.click();
    }
    public void locatesignup3()
    {
  	  WebElement signup=driver.findElement(By.xpath("//a[text()='Signup']"));
  	  signup.click();
    }
    public void setusername3(String name)
    {
  	  WebElement uname=driver.findElement(By.id("first"));
  	  uname.sendKeys(name);
    }
    public void setRole3(String role)
   {
  	  WebElement erole=driver.findElement(By.xpath("//option[text()='trainer']"));
  	  erole.click();
   } 
    public void setUndergraduate3(String ungrad)
    {
   	  WebElement ungrade=driver.findElement(By.xpath("//option[text()='UNDER GRADUATE']"));
   	  ungrade.click();
    } 
    public void setemailid3(String mailid)
    {
  	  WebElement emailid=driver.findElement(By.id("em"));
  	  emailid.sendKeys(mailid);
    }
     public void setpassword3(String pass)
     {
   	  WebElement password=driver.findElement(By.id("pw"));
   	  password.sendKeys(pass);
     }
     public void submit3()
     {
   	  WebElement submt=driver.findElement(By.id("but"));
   	  submt.click();
     }
   //signup with password(nonumber)
     public void locatedownarrow4()
     {
   	  WebElement downArrow=driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
   	  downArrow.click();
     }
     public void locatesignup4()
     {
   	  WebElement signup=driver.findElement(By.xpath("//a[text()='Signup']"));
   	  signup.click();
     }
     public void setusername4(String name)
     {
   	  WebElement uname=driver.findElement(By.id("first"));
   	  uname.sendKeys(name);
     }
     public void setRole4(String role)
    {
   	  WebElement erole=driver.findElement(By.xpath("//option[text()='trainer']"));
   	  erole.click();
    } 
     public void setUndergraduate4(String ungrad)
     {
    	  WebElement ungrade=driver.findElement(By.xpath("//option[text()='UNDER GRADUATE']"));
    	  ungrade.click();
     } 
     public void setemailid4(String mailid)
     {
   	  WebElement emailid=driver.findElement(By.id("em"));
   	  emailid.sendKeys(mailid);
     }
      public void setpassword4(String pass)
      {
    	  WebElement password=driver.findElement(By.id("pw"));
    	  password.sendKeys(pass);
      }
      public void submit4()
      {
    	  WebElement submt=driver.findElement(By.id("but"));
    	  submt.click();
      }
    //signup with blank username
      public void locatedownarrow5()
      {
    	  WebElement downArrow=driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
    	  downArrow.click();
      }
      public void locatesignup5()
      {
    	  WebElement signup=driver.findElement(By.xpath("//a[text()='Signup']"));
    	  signup.click();
      }
      public void setusername5(String name)
      {
    	  WebElement uname=driver.findElement(By.id("first"));
    	  uname.sendKeys(name);
      }
      public void setRole5(String role)
      {
     	  WebElement erole=driver.findElement(By.xpath("//option[text()='trainer']"));
     	  erole.click();
      } 
       public void setUndergraduate5(String ungrad)
       {
      	  WebElement ungrade=driver.findElement(By.xpath("//option[text()='UNDER GRADUATE']"));
      	  ungrade.click();
       } 
       public void setemailid5(String mailid)
       {
     	  WebElement emailid=driver.findElement(By.id("em"));
     	  emailid.sendKeys(mailid);
       }
        public void setpassword5(String pass)
        {
      	  WebElement password=driver.findElement(By.id("pw"));
      	  password.sendKeys(pass);
        }
      public void submit5()
      {
    	  WebElement submt=driver.findElement(By.id("but"));
    	  submt.click();
      }
    //signup with username special characters
      public void locatedownarrow6()
      {
    	  WebElement downArrow=driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
    	  downArrow.click();
      }
      public void locatesignup6()
      {
    	  WebElement signup=driver.findElement(By.xpath("//a[text()='Signup']"));
    	  signup.click();
      }
      public void setusername6(String name)
      {
    	  WebElement uname=driver.findElement(By.id("first"));
    	  uname.sendKeys(name);
      }
      public void setRole6(String role)
      {
     	  WebElement erole=driver.findElement(By.xpath("//option[text()='trainer']"));
     	  erole.click();
      } 
       public void setUndergraduate6(String ungrad)
       {
      	  WebElement ungrade=driver.findElement(By.xpath("//option[text()='UNDER GRADUATE']"));
      	  ungrade.click();
       } 
       public void setemailid6(String mailid)
       {
     	  WebElement emailid=driver.findElement(By.id("em"));
     	  emailid.sendKeys(mailid);
       }
        public void setpassword6(String pass)
        {
      	  WebElement password=driver.findElement(By.id("pw"));
      	  password.sendKeys(pass);
        }
      public void submit6()
      {
    	  WebElement submt=driver.findElement(By.id("but"));
    	  submt.click();
      }
    //signup with no emailid
      public void locatedownarrow7()
      {
    	  WebElement downArrow=driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
    	  downArrow.click();
      }
      public void locatesignup7()
      {
    	  WebElement signup=driver.findElement(By.xpath("//a[text()='Signup']"));
    	  signup.click();
      }
      public void setusername7(String name)
      {
    	  WebElement uname=driver.findElement(By.id("first"));
    	  uname.sendKeys(name);
      }
      public void setRole7(String role)
      {
     	  WebElement erole=driver.findElement(By.xpath("//option[text()='trainer']"));
     	  erole.click();
      } 
       public void setUndergraduate7(String ungrad)
       {
      	  WebElement ungrade=driver.findElement(By.xpath("//option[text()='UNDER GRADUATE']"));
      	  ungrade.click();
       } 
      public void setemailid7(String mailid)
      {
    	  WebElement emailid=driver.findElement(By.id("em"));
    	  emailid.sendKeys(mailid);
      }
      public void setpassword7(String pass)
      {
    	  WebElement password=driver.findElement(By.id("pw"));
    	  password.sendKeys(pass);
      }
      
      public void submit7()
      {
    	  WebElement submt=driver.findElement(By.id("but"));
    	  submt.click();
      }
      // signup with password not enough length
      public void locatedownarrow8()
      {
    	  WebElement downArrow=driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
    	  downArrow.click();
      }
      public void locatesignup8()
      {
    	  WebElement signup=driver.findElement(By.xpath("//a[text()='Signup']"));
    	  signup.click();
      }
      public void setusername8(String name)
      {
    	  WebElement uname=driver.findElement(By.id("first"));
    	  uname.sendKeys(name);
      }
      public void setRole8(String role)
      {
     	  WebElement erole=driver.findElement(By.xpath("//option[text()='trainer']"));
     	  erole.click();
      } 
       public void setUndergraduate8(String ungrad)
       {
      	  WebElement ungrade=driver.findElement(By.xpath("//option[text()='UNDER GRADUATE']"));
      	  ungrade.click();
       } 
      public void setemailid8(String mailid)
      {
    	  WebElement emailid=driver.findElement(By.id("em"));
    	  emailid.sendKeys(mailid);
      }
       public void setpassword8(String pass)
       {
     	  WebElement password=driver.findElement(By.id("pw"));
     	  password.sendKeys(pass);
       }
       public void submit8()
       {
     	  WebElement submt=driver.findElement(By.id("but"));
     	  submt.click();
       }
       //login with invalid password
       public void locatedownarrow9()
       {
     	  WebElement downArrow=driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
     	  downArrow.click();
       }
       public void locatelogin()
       {
     	  WebElement login=driver.findElement(By.xpath("//a[text()='Login']"));
     	  login.click();
       }
       public void setemailid9(String mailid)
       {
     	  WebElement emailid=driver.findElement(By.id("em"));
     	  emailid.sendKeys(mailid);
       }
        public void setpassword9(String pass)
        {
      	  WebElement password=driver.findElement(By.id("pw"));
      	  password.sendKeys(pass);
        }
       public void loginClick1()
       {
     	  WebElement loginbutton=driver.findElement(By.xpath("//button[@type='submit']"));
     	  loginbutton.click();
       }
       
}

