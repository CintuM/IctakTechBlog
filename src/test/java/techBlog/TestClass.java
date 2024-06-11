package techBlog;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ictak.constants.AutomationConstant;
import com.ictak.pages.BlogCreationUser;
import com.ictak.pages.LoginPageAdmin;
import com.ictak.pages.LoginPageUser;

public class TestClass extends TestBase{
	
	String actualResult=null;
	LoginPageAdmin loginAdmin;
	LoginPageUser loginUser;
	BlogCreationUser userBlog;
	
	@Test
	public void TC_ITB_1_1_1() {
		loginAdmin = new LoginPageAdmin(driver);
		actualResult = loginAdmin.safeLanding();
		Assert.assertEquals(actualResult, AutomationConstant.ExpectedHome);
	}
	
	@Test
	public void TC_ITB_1_1_2() {
		loginAdmin = new LoginPageAdmin(driver);
		loginAdmin.locateDownArrow();
		loginAdmin.locateLogin();
		loginAdmin.setEmailId(prop.getProperty("adminUser"));
		loginAdmin.setPassword(prop.getProperty("adminPwd"));
		loginAdmin.loginClick();
		waitabit();
		actualResult=loginAdmin.adminLoginCheck();
		Assert.assertEquals(actualResult, AutomationConstant.AdminLoggedin);
	}
	
	@Test
	public void TC_ITB_1_1_3() throws InterruptedException {
		loginUser = new LoginPageUser(driver);
		loginUser.locateDownArrow();
		loginUser.locateSignUp();
		loginUser.setName(prop.getProperty("username"));
		loginUser.setRole(prop.getProperty("userRole"));
		loginUser.setEmail(prop.getProperty("userEmail"));
		loginUser.setPwd(prop.getProperty("userpwd"));
		System.out.println("Clicking on submit");
		loginUser.SignupClick();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		actualResult = alert.getText();
		Assert.assertEquals(actualResult, AutomationConstant.UserSignUpAlert); 		
	}
	
	@Test
	public void TC_ITB_1_1_4() {
		loginUser = new LoginPageUser(driver);
		loginUser.locateDownArrow();
		loginUser.locateLogin();
		loginUser.setUser(prop.getProperty("uloginName"));
		loginUser.setPassword(prop.getProperty("uloginPwd"));
		loginUser.loginClick();
		waitabit();
		actualResult=loginUser.userLoginCheck();
		Assert.assertEquals(actualResult, AutomationConstant.UserLoggedin);
	}
	
	@Test
	public void TC_ITB_1_1_5() throws InterruptedException {
		loginUser = new LoginPageUser(driver);
		loginUser.locateDownArrow();
		loginUser.locateLogin();
		loginUser.setUser(prop.getProperty("uloginName"));
		loginUser.setPassword(prop.getProperty("uIncorrectPwd"));
		loginUser.loginClick();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		actualResult = alert.getText();
		Assert.assertEquals(actualResult, AutomationConstant.IncorrectLoginPwd);
	}

	@Test
	public void TC_ITB_1_1_6() throws InterruptedException {
		loginAdmin = new LoginPageAdmin(driver);
		loginAdmin.locateDownArrow();
		loginAdmin.locateLogin();
		loginAdmin.setEmailId(prop.getProperty("adminUser"));
		loginAdmin.setPassword(prop.getProperty("uIncorrectPwd"));
		loginAdmin.loginClick();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		actualResult = alert.getText();
		Assert.assertEquals(actualResult, AutomationConstant.IncorrectLoginPwd);
	}
	
	@Test
	public void TC_ITB_1_1_7() {
		loginAdmin = new LoginPageAdmin(driver);
		loginAdmin.locateDownArrow();
		loginAdmin.locateLogin();
		loginAdmin.setEmailId(prop.getProperty("adminUser"));
		loginAdmin.setPassword(prop.getProperty("adminPwd"));
		loginAdmin.loginClick();
		waitabit();
		loginAdmin.adminLogout();
		actualResult = loginAdmin.safeLanding();
		Assert.assertEquals(actualResult, AutomationConstant.ExpectedHome);	
	}
	
	@Test
	public void TC_ITB_1_2_1() throws InterruptedException {
		loginUser = new LoginPageUser(driver);
		loginUser.locateDownArrow();
		loginUser.locateLogin();
		loginUser.setUser(prop.getProperty("uloginName"));
		loginUser.setPassword(prop.getProperty("uloginPwd"));
		loginUser.loginClick();
		waitabit();
		userBlog = new BlogCreationUser(driver);
		userBlog.createBlog(prop.getProperty("bTitle"), prop.getProperty("imageUrl"), prop.getProperty("post"),"user");
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		actualResult = alert.getText();
		Assert.assertEquals(actualResult, AutomationConstant.UserBlogCreationMsg);		
	}
	
	@Test
	public void TC_ITB_1_2_2() throws InterruptedException {
		loginUser = new LoginPageUser(driver);
		loginUser.locateDownArrow();
		loginUser.locateLogin();
		loginUser.setUser(prop.getProperty("tloginName"));
		loginUser.setPassword(prop.getProperty("tloginPwd"));
		loginUser.loginClick();
		waitabit();
		userBlog = new BlogCreationUser(driver);
		userBlog.createBlog(prop.getProperty("bTitle"), prop.getProperty("imageUrl"), prop.getProperty("post"),"trainer");
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		actualResult = alert.getText();
		Assert.assertEquals(actualResult, AutomationConstant.UserBlogCreationMsg);		
	}
	
	@Test
	public void TC_ITB_1_2_3() {
		loginAdmin = new LoginPageAdmin(driver);
		loginAdmin.locateDownArrow();
		loginAdmin.locateLogin();
		loginAdmin.setEmailId(prop.getProperty("adminUser"));
		loginAdmin.setPassword(prop.getProperty("adminPwd"));
		loginAdmin.loginClick();
		waitabit();
		driver.navigate().refresh();
		userBlog = new BlogCreationUser(driver);
		waitabit();
		Boolean result = userBlog.pendingApproval();
		Assert.assertEquals(result, true);
		}
	
	@Test
	public void TC_ITB_1_2_4() {
		loginUser = new LoginPageUser(driver);
		loginUser.locateDownArrow();
		loginUser.locateLogin();
		loginUser.setUser(prop.getProperty("uloginName"));
		loginUser.setPassword(prop.getProperty("uloginPwd"));
		loginUser.loginClick();
		waitabit();
		driver.navigate().refresh();
		userBlog = new BlogCreationUser(driver);
		Boolean result = userBlog.posts("User");
		Assert.assertEquals(result, true);		
	}
	
	@Test
	public void TC_ITB_1_2_5() {
		loginUser = new LoginPageUser(driver);
		loginUser.locateDownArrow();
		loginUser.locateLogin();
		loginUser.setUser(prop.getProperty("tloginName"));
		loginUser.setPassword(prop.getProperty("tloginPwd"));
		loginUser.loginClick();
		waitabit();
		driver.navigate().refresh();
		userBlog = new BlogCreationUser(driver);
		Boolean result = userBlog.posts("Trainer");
		Assert.assertEquals(result, true);		
	}
}
