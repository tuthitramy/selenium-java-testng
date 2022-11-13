package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Button {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Random rand = new Random();
	By signInBtn = By.xpath("//button[@title='Đăng nhập bằng facebook']//preceding-sibling::button[@title='Đăng nhập']");
	




	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();


		

		

		

	}

	@Test
	public void TC_01_() {
		driver.get("https://www.fahasa.com/customer/account/create");
		sleepInSecond(10);
		driver.findElement(By.xpath("//button[text()='Hủy']")).click();
		driver.switchTo().frame("moe-onsite-campaign-635f90b38dd87b080a5f719f");
		
		driver.findElement(By.xpath("//button[@data-id='CLOSE']")).click();
		sleepInSecond(3);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();
		//Verify btn Đăng nhập is disable
		Assert.assertFalse(driver.findElement(signInBtn).isEnabled());
		driver.findElement(By.xpath("//input[@id='login_username']")).sendKeys("0935575103");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("myquynh2021");
		Assert.assertTrue(driver.findElement(signInBtn).isEnabled());
		String background = driver.findElement(signInBtn).getCssValue("background-color");
		String hexacolor = Color.fromString(background).asHex().toUpperCase();
		System.out.println(hexacolor);
		Assert.assertEquals(hexacolor, "#C92127");
		
	

		
		

	
	
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
