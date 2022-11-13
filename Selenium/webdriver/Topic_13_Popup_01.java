package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Topic_13_Popup_01 {
	WebDriver driver;
	JavascriptExecutor js;
	String projectPath = System.getProperty("user.dir");
	Random rand = new Random();
	Actions action;

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
		js = (JavascriptExecutor) driver;
		sleepInSecond(10);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_ngoaingu24h() {
		driver.get("https://ngoaingu24h.vn/");
		By loginPopup = By.xpath("//div[@id='modal-login-v1'][1]");
		Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
		driver.findElement(By.xpath("//div[@id='button-login-dialog']//button[text()='Đăng nhập']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='button-login-dialog']//button[text()='Đăng nhập']"))
				.isDisplayed());
		driver.findElement(By.xpath("//div[@style]//input[@id='account-input']")).sendKeys("automationfc");
		driver.findElement(By.xpath("//div[@style]//input[@id='password-input']")).sendKeys("automationfc");
		driver.findElement(By.xpath("//div[@id='modal-login-v1'and @style]//button[text()='Đăng nhập']")).click();
		Assert.assertEquals(driver
				.findElement(By.xpath("//div[@id='modal-login-v1'and @style]//div[text()='Tài khoản không tồn tại!']"))
				.getText(), "Tài khoản không tồn tại!");
		
	}

	@Test

	public void TC_02_kynaenglish() {
		driver.get("https://skills.kynaenglish.vn/");
		sleepInSecond(3);
		Assert.assertFalse(driver.findElement(By.xpath("//div[@id='k-popup-account-login']")).isDisplayed());
		driver.findElement(By.xpath("//a[@class='login-btn']")).click();
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit' and text()='Đăng nhập']"));
		js.executeScript("arguments[0].scrollIntoView(true);", loginButton);
		driver.findElement(By.xpath("//input[@id='user-login']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id='user-password']")).sendKeys("123456");
		loginButton.click();
		sleepInSecond(5);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='password-form-login-message']")).getText(),
				"Sai tên đăng nhập hoặc mật khẩu");
		driver.findElement(By.xpath("//button[ @class='k-popup-account-close close']")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//div[@id='k-popup-account-login']")).isDisplayed());

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

	@AfterClass
	public void afterClass() {
//		 driver.quit();
	}
}
