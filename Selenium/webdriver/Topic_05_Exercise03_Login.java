package webdriver;

import java.util.Random;
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

public class Topic_05_Exercise03_Login {
	Random rand;
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	By myAccount_Link = By.xpath("//div[@class='footer-container']//a[@title='My Account']");
	By emailTextbox = By.xpath("//input[@title='Email Address']");
	By passwordTextbox = By.xpath("//input[@title='Password']");
	By loginButton = By.xpath("//button[@title='Login']");
	String emailAddress;
	String firstName, middleName, lastName, fullName, password; 

	
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		rand = new Random();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		emailAddress = "automation" + rand.nextInt(9999) + "@gmail.com";
		firstName ="automation";
		middleName ="middle";
		lastName = "My_test";
		fullName = firstName + " " + middleName + " " + lastName;
		password = "123456";
				

	}

	@Test
	public void TC_01_emptyEmailAndPassword() {

		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(),
				"This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(),
				"This is a required field.");

	}

	@Test

	public void TC_02_invalidEmail() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(myAccount_Link).click();
		driver.findElement(emailTextbox).sendKeys("1234@2324.123");
		driver.findElement(passwordTextbox).sendKeys("123456");
		driver.findElement(loginButton).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(),
				"Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test
	public void TC_03_passwordNotEnough() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(myAccount_Link).click();
		driver.findElement(emailTextbox).sendKeys("tuthitramy290397@gmail.com");
		driver.findElement(passwordTextbox).sendKeys("323");
		driver.findElement(loginButton).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(),
				"Please enter 6 or more characters without leading or trailing spaces.");

	}

	@Test
	public void TC_04_incorrectPassword() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(myAccount_Link).click();
		driver.findElement(emailTextbox).sendKeys("tuthitramy290397@gmail.com");
		driver.findElement(passwordTextbox).sendKeys("12323232");
		driver.findElement(loginButton).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).getText(),
				"Invalid login or password.");

	}

	@Test
	public void TC_05_create_New_Account() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(myAccount_Link).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys(middleName);
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		Assert.assertEquals(driver
				.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).getText(),
				"Thank you for registering with Main Website Store.");
		//Step 06: Verify user được tạo mới với thông tin: Firstname/Lastname/Email hiển thị ở trang Dashboard
		String contactInformationText = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div[@class='box-title']/following-sibling::div")).getText();
		Assert.assertTrue(contactInformationText.contains(fullName));
		Assert.assertTrue(contactInformationText.contains(emailAddress));
		driver.findElement(By.xpath("//span[text()='Account']/parent::a")).click();
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();
		sleepInSecond(10);
		
		//Step 09: Kiểm tra hệ thống Navigate về Homepage sau khi log out thành công
		String strUrl = driver.getCurrentUrl();
		Assert.assertEquals(strUrl,"http://live.techpanda.org/index.php/");

		
 
		
		

	}

	@Test
	public void TC_06_Login_with_valid_infor() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
		driver.findElement(emailTextbox).sendKeys(emailAddress);
		driver.findElement(passwordTextbox).sendKeys(password);
		driver.findElement(loginButton).click();
		String contactInformationText = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div[@class='box-title']/following-sibling::div")).getText();
		Assert.assertTrue(contactInformationText.contains(fullName));
		Assert.assertTrue(contactInformationText.contains(emailAddress));
		
		
		
		

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
