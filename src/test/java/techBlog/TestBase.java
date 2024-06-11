package techBlog;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	WebDriver driver;
	Properties prop=null;


	public void loadProp() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Eclipse-Workspace\\IctakTechBlog\\IctakTechBlog\\src\\test\\resources\\config.properties");
		prop.load(fis);
	}
	
	@BeforeMethod
	public void setup() throws IOException{
		loadProp();
		driver= new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	public void waitabit() {
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));	
	}
	
}
