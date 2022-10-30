package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Exercise02_Web_Element {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	By passwordTextbox = By.xpath("//input[@id='new_password']");
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_isDisplay() {
		By signUpBtn = By.xpath("//button[@id='create-account-enabled']");
//		driver.get("https://login.mailchimp.com/signup/");
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("tuthitramy290397@gmail.com");
		

		//Step 03: Nhập dữ liệu vào trường PW để check validate
		//Case 01:Nhập lowercase
		 driver.get("https://login.mailchimp.com/signup/");
		 sleepInSecond(30);
		 driver.findElement(passwordTextbox).sendKeys("abc");
		 sleepInSecond(3);
		 driver.findElement(signUpBtn).click();
		 sleepInSecond(3);
		
		 //Verify steps 01:
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		
		
				
	
	}
	@Test
	public void TC_02_() {
		
	}
	@Test
	public void TC_03_() {
		
	}
	

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
