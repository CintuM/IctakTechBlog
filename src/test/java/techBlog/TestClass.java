package techBlog;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.ictak.constants.AutomationConstant;
import com.ictak.pages.BlogCreationUser;
import com.ictak.pages.LoginPageAdmin;
import com.ictak.pages.LoginPageTrainer;
import com.ictak.pages.LoginPageUser;

public class TestClass extends TestBase{
	
	String actualResult=null;
	LoginPageAdmin loginAdmin;
	LoginPageUser loginUser;
	BlogCreationUser userBlog;
	LoginPageTrainer tesobj=null;

	///////// START OF CINTU'S TESTCASES /////////////////
	
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
		Assert.assertEquals(actualResult, AutomationConstant.IncorrectLoginPassword);
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
		Assert.assertEquals(actualResult, AutomationConstant.IncorrectLoginPassword);
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
	
	///////// END OF CINTU'S TESTCASES /////////////////
	
	////////// START OF NEETHU'S TESTCASES //////////
	
	@Test(priority=1)
	  public void TC_ITB_3_1_1() throws InterruptedException 
	  {
		  tesobj=new LoginPageTrainer(driver);
		  tesobj.locatedownarrow();
		  tesobj.locatesignup();
	      tesobj.setusername(prop.getProperty("username"));
		  tesobj.setRole(prop.getProperty("userRole"));
		  tesobj.setUndergraduates(prop.getProperty("degree"));
		  tesobj.setemailid(prop.getProperty("emailid"));
		  tesobj.setpassword(prop.getProperty("password"));
		  tesobj.submit(); 
		  actualResult=tesobj.getAlert();
			tesobj.handleAlert();
		  Assert.assertEquals(actualResult, AutomationConstant.TrainerSignUpAlert);
		  Thread.sleep(5000);
	}
	  
	  @Test(priority=2)
	  public void TC_ITB_3_1_2() throws InterruptedException 
	  {
		  tesobj=new LoginPageTrainer(driver);
		  tesobj.locatedownarrowu();
		  tesobj.locatesignupu();
	      tesobj.setusernameu(prop.getProperty("username1"));
		  tesobj.setRoleu(prop.getProperty("userRole"));
		  tesobj.setUndergraduate(prop.getProperty("degree"));
		  tesobj.setemailidu(prop.getProperty("emailid1"));
		  tesobj.setpasswordu(prop.getProperty("password1"));
		  tesobj.submitu();
			//tesobj.handleAlert();
			actualResult=tesobj.getAlert();
			Assert.assertEquals(actualResult, AutomationConstant.TrainerwithundergraduatesignupAlert);
		  Thread.sleep(5000);
	}
	  @Test(priority=3)
	  public void TC_ITB_3_1_3() throws InterruptedException 
	  {
		  tesobj=new LoginPageTrainer(driver);
		  tesobj.locatedownarrowp();
		  tesobj.locatesignupp();
	      tesobj.setusernamep(prop.getProperty("username2"));
		  tesobj.setRolep(prop.getProperty("userRole"));
		  tesobj.setphd(prop.getProperty("degreen"));
		  tesobj.setemailidp(prop.getProperty("emailid2"));
		  tesobj.setpasswordp(prop.getProperty("password2"));
		  tesobj.submitp();
		  actualResult=tesobj.getAlert();
		  Assert.assertEquals(actualResult, AutomationConstant.TrainerwithPHDsignupAlert);
	 		tesobj.handleAlert();
	 		Thread.sleep(5000);
		  
	}

	  @Test(priority=4)
	  public void TC_ITB_3_1_4() throws InterruptedException 
	  {
		  tesobj=new LoginPageTrainer(driver);
		  tesobj.locatedownarrow1();
		  tesobj.locatesignup1();
	      tesobj.setusername1(prop.getProperty("username3"));
		  tesobj.setRole1(prop.getProperty("userRole"));
		  tesobj.setUndergraduate1(prop.getProperty("degree"));
		  tesobj.setemailid1(prop.getProperty("emailid3"));
		  tesobj.setpassword1(prop.getProperty("blankpassword"));
		  tesobj.submit1();
		  actualResult=tesobj.getAlert();
		  Assert.assertEquals(actualResult, AutomationConstant.BlankPassword);
	 		tesobj.handleAlert();
	System.out.println("Incorrect Password");
	Thread.sleep(5000);
	}
	  @Test(priority=5)
	  public void TC_ITB_3_1_5() throws InterruptedException 
	  {
		  tesobj=new LoginPageTrainer(driver);
		  tesobj.locatedownarrow2();
		  tesobj.locatesignup2();
	      tesobj.setusername2(prop.getProperty("username4"));
		  tesobj.setRole2(prop.getProperty("userRole"));
		  tesobj.setemailid2(prop.getProperty("emailid4"));
		  tesobj.setUndergraduate2(prop.getProperty("degree"));
		  tesobj.setpassword2(prop.getProperty("nouppercasepassword"));
		  tesobj.submit2();
		  actualResult=tesobj.getAlert();
		  Assert.assertEquals(actualResult, AutomationConstant.Passwordwithnouppercase);
	 		tesobj.handleAlert();
	 		Thread.sleep(5000);
	}
	  @Test(priority=6)
	  public void TC_ITB_3_1_6() throws InterruptedException 
	  {
		  tesobj=new LoginPageTrainer(driver);
		  tesobj.locatedownarrow3();
		  tesobj.locatesignup3();
	      tesobj.setusername3(prop.getProperty("username5"));
		  tesobj.setRole3(prop.getProperty("userRole"));
		  tesobj.setemailid3(prop.getProperty("emailid5"));
		  tesobj.setpassword3(prop.getProperty("nolowercasepassword"));
		  tesobj.submit3();
		  actualResult=tesobj.getAlert();
		  AssertJUnit.assertEquals(actualResult, AutomationConstant.Passwordwithnolowercase);
	 		tesobj.handleAlert();
	 		Thread.sleep(5000);
	}
	  @Test(priority=7)
	  public void TC_ITB_3_1_7() throws InterruptedException 
	  {
		  tesobj=new LoginPageTrainer(driver);
		  tesobj.locatedownarrow4();
		  tesobj.locatesignup4();
	      tesobj.setusername4(prop.getProperty("username6"));
		  tesobj.setRole4(prop.getProperty("userRole"));
		  tesobj.setemailid4(prop.getProperty("emailid6"));
		  tesobj.setpassword4(prop.getProperty("nonumberpassword"));
		  tesobj.submit4();
		  actualResult=tesobj.getAlert();
		  Assert.assertEquals(actualResult, AutomationConstant.Passwordwithnonumber);
	 		tesobj.handleAlert();
	 		Thread.sleep(5000);
	}
	  @Test(priority=8)
	  public void TC_ITB_3_1_8() throws InterruptedException 
	  {
		  tesobj=new LoginPageTrainer(driver);
		  tesobj.locatedownarrow5();
		  tesobj.locatesignup5();
	      tesobj.setusername5(prop.getProperty("blankusername"));
		  tesobj.setRole5(prop.getProperty("userRole"));
		  tesobj.setemailid5(prop.getProperty("emailid7"));
		  tesobj.setpassword5(prop.getProperty("password7"));
		  tesobj.submit5();
		  actualResult=tesobj.getAlert();
		  Assert.assertEquals(actualResult, AutomationConstant.BlankUsername);
	 		//tesobj.handleAlert();
	 		Thread.sleep(5000);
	}
	  @Test(priority=9)
	  public void TC_ITB_3_1_9() throws InterruptedException 
	  {
		  tesobj=new LoginPageTrainer(driver);
		  tesobj.locatedownarrow6();
		  tesobj.locatesignup6();
	      tesobj.setusername6(prop.getProperty("specialchar"));
		  tesobj.setRole6(prop.getProperty("userRole"));
		  tesobj.setemailid6(prop.getProperty("emailid8"));
		  tesobj.setpassword6(prop.getProperty("password8"));
		  tesobj.submit6();
		  actualResult=tesobj.getAlert();
		  Assert.assertEquals(actualResult, AutomationConstant.Trainerusernamewithspecialchar);
	 		tesobj.handleAlert();
	 		Thread.sleep(5000);
	}
	  @Test(priority=10)
	  public void TC_ITB_3_1_10() throws InterruptedException 
	  {
		  tesobj=new LoginPageTrainer(driver);
		  tesobj.locatedownarrow7();
		  tesobj.locatesignup7();
	      tesobj.setusername7(prop.getProperty("username7"));
		  tesobj.setRole7(prop.getProperty("userRole"));
		  tesobj.setemailid7(prop.getProperty("blankemailid"));
		  tesobj.setpassword7(prop.getProperty("password9"));
		  tesobj.submit7();
		  actualResult=tesobj.getAlert();
		  Assert.assertEquals(actualResult, AutomationConstant.Blankemail);
	 		Thread.sleep(5000);
	}
	  @Test(priority=11)
	  public void TC_ITB_3_1_11() throws InterruptedException 
	  {
		  tesobj=new LoginPageTrainer(driver);
		  tesobj.locatedownarrow8();
		  tesobj.locatesignup8();
	      tesobj.setusername8(prop.getProperty("username8"));
		  tesobj.setRole8(prop.getProperty("userRole"));
		  tesobj.setemailid8(prop.getProperty("emailid9"));
		  tesobj.setpassword8(prop.getProperty("shortpassword"));
		  tesobj.submit8();
		  actualResult=tesobj.getAlert();
		  Assert.assertEquals(actualResult, AutomationConstant.Passwordnotenoughlength);
	 		tesobj.handleAlert();
	 		Thread.sleep(5000);
	}
	  @Test(priority=12)
	  public void TC_ITB_3_1_12() throws InterruptedException 
	  {
		  tesobj=new LoginPageTrainer(driver);
		  tesobj.locatedownarrow9();
		  tesobj.locatelogin();
	      tesobj.setemailid9(prop.getProperty("emailid10"));
		  tesobj.setpassword9(prop.getProperty("wrongpassword"));
		  tesobj.loginClick1();
		  actualResult=tesobj.getAlert();
		  Assert.assertEquals(actualResult, AutomationConstant.IncorrectLoginPwd);
	 		tesobj.handleAlert();
	 		Thread.sleep(5000);
	  }
}
