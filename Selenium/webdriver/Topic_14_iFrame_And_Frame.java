package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_14_iFrame_And_Frame {
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

	}

	public void searchAction() {
		WebElement inputSearch = driver.findElement(By.xpath("//input[@value='Search...']"));
		WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-button']"));
		inputSearch.sendKeys("Selenium");
		searchButton.click();

	}

	public String getEmailRandom() {
		return "test" + rand.nextInt(99) + "@gmail.com";

	}

	@Test
	public void TC_01_Kyna_Iframe() {
		driver.get("https://kyna.vn/");
		//Verify iframe facebook có hiển thị
		Assert.assertTrue(driver.findElement(By.xpath("//iframe[contains(@src,'facebook')]")).isDisplayed());
		System.out.println("Verify iframe facebook already");
		//Switch qua iframe facebook 
		WebElement facebook_IFrame = driver.findElement(By.xpath("//iframe[contains(@src,'facebook')]"));
		driver.switchTo().frame(facebook_IFrame);
		//Verify lượt like ở iframe facebook
		Assert.assertEquals(
				driver.findElement(By.xpath("//a[@title='Kyna.vn']//parent::div//following-sibling::div")).getText(),
				"165K likes");
				System.out.println("Verify iframe facebook like already");
				//Switch về main page
		driver.switchTo().defaultContent();
		// Switch đên iframe chat
		driver.switchTo().frame("cs_chat_iframe");
		//Click button để hiện popup chat
		driver.findElement(
				By.xpath("//div[@class='button_text']//following-sibling::div[contains(@class,'BorderOverlay')]"))
				.click();
				System.out.println("Clicked box chat already");
		// Input nội dung vào chat box
		driver.findElement(
				By.xpath("//div[@class='editing field profile_field']/input[@placeholder='Nhập tên của bạn']"))
				.sendKeys("abcxyz");
		driver.findElement(By
				.xpath("//div[@class='editing field profile_field']/input[@placeholder='Nhập số điện thoại của bạn']"))
				.sendKeys("093445667");
		driver.findElement(By.xpath("//label[text()='Chọn dịch vụ hỗ trợ']")).click();
		Select se = new Select(driver.findElement(By.xpath("//*[@id='serviceSelect']")));
		se.selectByVisibleText("TƯ VẤN TUYỂN SINH");
		driver.findElement(By.xpath("//label[text()='Tin nhắn']/parent::label//following-sibling::textarea"))
				.sendKeys("Thank you so much");
		driver.findElement(By.xpath("//input[@value='Gửi tin nhắn']")).click();
		System.out.println("Send information already");
		//Switch về lại main page
		driver.switchTo().defaultContent();
		// Tìm khóa học Excel
		driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys("Excel");
		driver.findElement(By.xpath("//button[@class='search-button']")).click();
		List<WebElement> courseName = driver.findElements(By.xpath("//div[@class='content']//h4"));
		for(WebElement course:courseName){
			Assert.assertTrue(course.getText().contains("Excel"));


		}

	}

	@Test
	public void TC_02_Netbanking_Frame() {
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		WebElement frame = driver.findElement(By.xpath("//frame[@name='login_page']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//div[text()='Customer ID/ User ID']//parent::div//following-sibling::div//input")).sendKeys("automationtest123");
		driver.findElement(By.xpath("//a[text()='CONTINUE']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Password/ IPIN']")).isDisplayed());

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
