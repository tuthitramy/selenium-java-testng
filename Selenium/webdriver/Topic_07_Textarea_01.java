package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Textarea_01 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstName;
	Random rand = new Random();
	String employeeID = String.valueOf(rand.nextInt(99999));
//	Actions action;
	By EmployeeIDTextbox = By.xpath("//label[text()='Employee Id']//parent::div//following-sibling::div/input");
//	By firstNamePersonal = By.xpath("//input[@name='firstName']");



	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		Random rand = new Random();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
//		String firstNamePersonal;
//		action = new Actions(driver);

		

		firstName = "Test" + "_" + rand.nextInt(99);


//		By employeeIDTextbox = By.xpath(
//				"//div[@class='oxd-input-group__label-wrapper']//following::div//input[@class='oxd-input oxd-input--active']");

	}

	@Test
	public void TC_01_Create_New_Employee() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		sleepInSecond(10);
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
		System.out.println(firstName);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Automation");
//		System.out.println(employeeID);
		sleepInSecond(5);
		driver.findElement(EmployeeIDTextbox).sendKeys(Keys.CONTROL,"a");
		driver.findElement(EmployeeIDTextbox).sendKeys(Keys.BACK_SPACE);
		driver.findElement(EmployeeIDTextbox).sendKeys(employeeID);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		sleepInSecond(10);
//		driver.getCurrentUrl();
//		WebElement firstNamePersonal = driver.findElement(By.xpath("//input[@name='firstName']"));
		driver.findElement(By.xpath("//input[@name='firstName']"));
//		System.out.println(firstName);
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"),firstName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"),"Automation");
		Assert.assertEquals(driver.findElement(EmployeeIDTextbox).getAttribute("value"),employeeID);
		

	
	
	
	}

	@Test

	public void TC_02_() {

	}

	@Test
	public void TC_03_() {

	}

	@Test
	public void TC_04_() {

	}

	@Test
	public void TC_05_() {

	}

	@Test
	public void TC_06_() {

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
