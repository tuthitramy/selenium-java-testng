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

public class Topic_12_Action {
	WebDriver driver;
//	JavascriptExecutor js;
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
//		js = (JavascriptExecutor) driver;
		sleepInSecond(10);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_jqueryTooltip() {
//		driver.get("https://automationfc.github.io/jquery-tooltip/");
//		action.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
//		sleepInSecond(3);
//		Assert.assertEquals(
//				driver.findElement(By.xpath("//div[@class='ui-tooltip-content' and contains(text(), 'We ask for')]"))
//						.getText(),
//				"We ask for your age only for statistical purposes.");

	}

	@Test

	public void TC_02_myntraPage() {
//		driver.get("http://www.myntra.com/");
//		action.moveToElement(driver.findElement(By.xpath("//a[@data-group='kids']"))).perform();
//		action.click(driver.findElement(By.xpath("//a[text()='Home & Bath']"))).perform();
//		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Kids Home Bath']")).getText(), "Kids Home Bath");

	}

	@Test
	public void TC_03_fahasa() {
		driver.get("https://www.fahasa.com/");
		sleepInSecond(10);
		driver.findElement(By.xpath("//button[text()='Hủy']")).click();	
		driver.switchTo().frame("moe-onsite-campaign-636f25132de2adac4ba9e4d1");
		driver.findElement(By.xpath("//button[@id='close-icon']")).click();
		sleepInSecond(10);
		driver.switchTo().defaultContent();
		action.moveToElement(driver.findElement(By.xpath("//span[@class='icon_menu']"))).perform();
		action.click(driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//a[text()='Kỹ Năng Sống']"))).perform();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.xpath("//strong[text()='Kỹ năng sống']")).getText(), "KỸ NĂNG SỐNG");

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
