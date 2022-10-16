package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://www.facebook.com/");

	}
	

	@Test
	public void TC_01_ID() {
//		driver.findElement(By.id("email")).sendKeys("tuthitramy290397@gmail.com");
//		driver.findElement(By.id("pass")).sendKeys("my290397");
//		
//		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?biz=false&cc=VN&continue=https%3A%2F%2Fmail.google.com&dsh=S855692639%3A1665903204836872&flowEntry=SignUp&flowName=GlifWebSignIn&hl=vi&service=mail");
//		driver.findElement(By.id("lastName")).sendKeys("ggg");
//		driver.findElement(By.id("firstName")).sendKeys("Thi Trà Tu 123");
		
	}

	@Test
	public void TC_02_Class() {
//		driver.findElement(By.className("VfPpkd-muHVFf-bMcfAe")).click();
	}

	@Test
	public void TC_03_Name() {
//		driver.findElement(By.name("lastName")).sendKeys("myttt02");
		
	}
	@Test
	public void TC_04_TagName() {
		
	}
	@Test
	public void TC_05_LinkText() {
//		driver.get("https://www.guru99.com/locate-by-link-text-partial-link-text.html");
//		driver.findElement(By.linkText("Verify Element Present, waitFor, andWait in Selenium IDE")).click();
//		driver.findElement(By.linkText("Verify Presence of an Element")).click();
	}
	@Test
	public void TC_06_PartialLinkText() {
		
	}
	@Test
	public void TC_07_Css() {
//		driver.get("https://www.facebook.com/");
//		driver.findElement(By.cssSelector("input#email")).sendKeys("myttt02@gmail.com");
//		driver.findElement(By.cssSelector("input[id='email'")).sendKeys("myttt02@ominext.com");
//		driver.findElement(By.cssSelector("input[name='email'")).sendKeys("myttt02@ominext.com");
		
		
	}
	@Test
	public void TC_08_XPath() {
//		driver.get("https://www.facebook.com/");
//		driver.findElement(By.cssSelector("input#email")).sendKeys("myttt02@gmail.com");
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("myttt02@ominext.com");
		
		
	}
	

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
