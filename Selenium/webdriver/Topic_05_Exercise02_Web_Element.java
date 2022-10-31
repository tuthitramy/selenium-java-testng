package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	By signUpBtn = By.xpath("//button[text()=\"Sign Up\"]");
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_isDisplay() {
		
//		driver.get("https://login.mailchimp.com/signup/");
		
//		sleepInSecond(3);
		
		//driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Keys.DOWN );
		

		//Step 03: Nhập dữ liệu vào trường PW để check validate
		//Case 01:Nhập lowercase
		 driver.get("https://login.mailchimp.com/signup/");
		 sleepInSecond(3);
//		 driver.findElement(By.xpath("//div[@id='onetrust-close-btn-container']//button[@aria-label='Close']")).click();
		 
		 
		 driver.findElement(passwordTextbox).sendKeys("abc");
		 sleepInSecond(3);

		
		 //Verify steps 01:Verify lowercase character
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		 
		 driver.findElement(passwordTextbox).clear();
		 driver.findElement(passwordTextbox).sendKeys("123");

		 
		 //Verify steps 02:Verify number character
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		 
		 driver.findElement(passwordTextbox).clear();
		 driver.findElement(passwordTextbox).sendKeys("!@#");
//		 sleepInSecond(3);
		 
		//Verify steps 03:Verify special character
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		 
//		 
		 driver.findElement(passwordTextbox).clear();
		 driver.findElement(passwordTextbox).sendKeys("abcxyzuia");
//		 sleepInSecond(3);
//		 
		//Verify steps 04:Verify 9 characters 
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		 
		 
		 driver.findElement(passwordTextbox).clear();
		 driver.findElement(passwordTextbox).sendKeys("abc123@A");
//		 sleepInSecond(3);
		 
//		//Verify steps 01:Verify right password
		 Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		 Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		 Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		 Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
//		 
		 
		 
		
		 
		
		
//		 driver.findElement(signUpBtn).click();

	
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
