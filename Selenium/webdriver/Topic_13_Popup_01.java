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
	Random rand;
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
		rand = new Random();
//		String email = "Test" + rand.nextInt(99)+"@gmail.com";

	}

	public String getEmailRandom() {
		Random rand = new Random();
		return "test" + rand.nextInt(99) + "@gmail.com";

	}

	public void searchAction() {
		WebElement inputSearch = driver.findElement(By.xpath("//input[@value='Search...']"));
		WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-button']"));
		inputSearch.sendKeys("Selenium");
//		js.executeScript("window.scrollBy(0,-250)", "");
		searchButton.click();

	}

	@Test
	public void TC_01_ngoaingu24h() {
//		driver.get("https://ngoaingu24h.vn/");
//		By loginPopup = By.xpath("//div[@id='modal-login-v1'][1]");
//		Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
//		driver.findElement(By.xpath("//div[@id='button-login-dialog']//button[text()='Đăng nhập']")).click();
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='button-login-dialog']//button[text()='Đăng nhập']"))
//				.isDisplayed());
//		driver.findElement(By.xpath("//div[@style]//input[@id='account-input']")).sendKeys("automationfc");
//		driver.findElement(By.xpath("//div[@style]//input[@id='password-input']")).sendKeys("automationfc");
//		driver.findElement(By.xpath("//div[@id='modal-login-v1'and @style]//button[text()='Đăng nhập']")).click();
//		Assert.assertEquals(driver
//				.findElement(By.xpath("//div[@id='modal-login-v1'and @style]//div[text()='Tài khoản không tồn tại!']"))
//				.getText(), "Tài khoản không tồn tại!");

	}

	@Test

	public void TC_02_kynaenglish() {
//		driver.get("https://skills.kynaenglish.vn/");
//		sleepInSecond(3);
//		Assert.assertFalse(driver.findElement(By.xpath("//div[@id='k-popup-account-login']")).isDisplayed());
//		driver.findElement(By.xpath("//a[@class='login-btn']")).click();
//		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit' and text()='Đăng nhập']"));
//		js.executeScript("arguments[0].scrollIntoView(true);", loginButton);
//		driver.findElement(By.xpath("//input[@id='user-login']")).sendKeys("automation@gmail.com");
//		driver.findElement(By.xpath("//input[@id='user-password']")).sendKeys("123456");
//		loginButton.click();
//		sleepInSecond(5);
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='password-form-login-message']")).getText(),
//				"Sai tên đăng nhập hoặc mật khẩu");
//		driver.findElement(By.xpath("//button[ @class='k-popup-account-close close']")).click();
//		Assert.assertFalse(driver.findElement(By.xpath("//div[@id='k-popup-account-login']")).isDisplayed());
//
	}

	@Test
	public void TC_03_tiki() {
//		driver.get("https://tiki.vn/");
//		Assert.assertEquals(driver.findElements(By.xpath("//div[@role='dialog']")).size(), 0);
//		driver.findElement(By.xpath("//span[text()='Đăng Nhập / Đăng Ký']")).click();
//		sleepInSecond(5);
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@role='dialog']")).isDisplayed());
//		driver.findElement(By.xpath("//p[@class='login-with-email']")).click();
//		sleepInSecond(5);
//		driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
//		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Email không được để trống']")).getText(), "Email không được để trống");
//		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Mật khẩu không được để trống']")).getText(), "Mật khẩu không được để trống");
//        driver.findElement(By.xpath("//button[@class='btn-close']")).click();
//        sleepInSecond(5);
//        Assert.assertEquals(driver.findElements(By.xpath("//div[@role='dialog']")).size(), 0);

	}

	@Test
	public void TC_04_facebook() {
//		driver.get("https://www.facebook.com/");
//		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
//		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Sign Up']//ancestor::div[@class='_n3']")).isDisplayed());
//		driver.findElement(By.xpath("//div[text()='Sign Up']//parent::div//parent::div//img")).click();
//		sleepInSecond(3);
//		Assert.assertEquals(driver.findElements(By.xpath("//div[text()='Sign Up']//ancestor::div[@class='_n3']")).size(), 0);

	}

	@Test
	public void TC_05_javacodegeeks() {
//		driver.get("https://www.javacodegeeks.com/");
//		sleepInSecond(5);
//		List<WebElement> popupGetTheBooks = driver.findElements(By.xpath("//div[@class='lepopup-popup-container']"));
//		List<WebElement> popupOK = driver
//				.findElements(By.xpath("//div[@class='lepopup-form-inner' and @style='width:526px;height:576px;']"));
//		if (popupGetTheBooks.size() == 1 || popupOK.size() == 1) {
//			if (popupGetTheBooks.size() == 1) {
//				driver.findElement(By.xpath("//input[@autocomplete='email']")).sendKeys(getEmailRandom());
//				driver.findElement(By.xpath("//a[@data-label='Get the Books']")).click();
//				sleepInSecond(10);
//				if (popupOK.size() == 1) {
//					driver.findElement(By.xpath("//input[@autocomplete='email']")).sendKeys(getEmailRandom());
//					driver.findElement(By.xpath("//a[@data-label='OK']")).click();
//					searchAction();
//				} else {
//					searchAction();
//				}
//
//			} else {
//				driver.findElement(By.xpath("//input[@autocomplete='email']")).sendKeys(getEmailRandom());
//				driver.findElement(By.xpath("//a[@data-label='OK']")).click();
//				searchAction();
//
//			}
//		}
//
//		else {
//			driver.findElement(By.xpath("//button[@class='search-button']")).click();
//			String seleniumKeyword = driver.findElement(By.xpath("//article[@class='item-list item_1']//h2//a"))
//					.getText();
//			Assert.assertTrue(seleniumKeyword.contains("Selenium"));
//			searchAction();
//
//		}
	}

	@Test
	public void TC_06_dehieu() {
		driver.get("https://dehieu.vn/");
		sleepInSecond(20);
		WebElement iframe = driver.findElement(By.xpath("//div[@class=' fb_iframe_widget fb_invisible_flow']//iframe"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//div[@class='welcomePageModalSheetContent']//div[@aria-label='đóng']")).click();
		driver.switchTo().defaultContent();
		WebElement popup = driver.findElement(By.xpath("//div[@class='popup-content']"));

		if (popup.isDisplayed()) {

			driver.findElement(By.xpath("//div[@class='popup-content']//button[@class='close']")).click();
			moveToNextStep();
		} else {
			moveToNextStep();
		}

	}

	public void moveToNextStep() {
		driver.findElement(By.xpath("//a[text()='Tất cả khóa học']")).click();
	}

	@AfterClass
	public void afterClass() {
//		 driver.quit();
	}
}
