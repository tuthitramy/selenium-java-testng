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

public class Topic_11_Custom_checkbox_radiobtn_Kendo_UI2 {
	WebDriver driver;
	JavascriptExecutor js;
	String projectPath = System.getProperty("user.dir");
	Random rand = new Random();
//	JavascriptExecutor js = (JavascriptExecutor) driver;

	

	
	
	
	
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
		js = (JavascriptExecutor) driver;
		sleepInSecond(10);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_customRadio() {
		
		driver.get("https://material.angular.io/components/radio/examples");
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;		
		WebElement elementScroll = driver.findElement(By.xpath("//label[text()='Pick your favorite season']"));
		js.executeScript("arguments[0].scrollIntoView(true);", elementScroll);
		sleepInSecond(10);
		WebElement summerLabel = driver.findElement(By.xpath("//span[text()=' Summer ']"));
		WebElement summerButton = driver.findElement(By.xpath("//input[@value='Summer']"));
		checkToCheckboxOrRadio(summerLabel);
		checkToCheckboxOrRadio(driver.findElement(By.xpath("//span[text()=' Spring ']")));
//		Assert.assertTrue(summerButton.isSelected());
		if(summerButton.isSelected()==true) {
			System.out.println("This radio button is selected");
			
		}
		else {
			checkToCheckboxOrRadio(summerLabel);
			
		}




	}

	@Test

	public void TC_02_customCheckbox() {
		driver.get("https://material.angular.io/components/checkbox/examples");
		
		WebElement elementScroll = driver.findElement(By.xpath("//h2[text()='Checkbox configuration']"));
		js.executeScript("arguments[0].scrollIntoView(true);", elementScroll);
		WebElement checkedCheckboxLabel = driver.findElement(By.xpath("//span[text()='Checked']"));
		WebElement checkedCheckboxinput = driver.findElement(By.xpath("//span[text()='Checked']//preceding-sibling::span//child::input"));
		WebElement interderminateCheckbox = driver.findElement(By.xpath("//span[text()='Indeterminate']"));
		WebElement interderminateCheckboxinput = driver.findElement(By.xpath("//span[text()='Checked']//preceding-sibling::span//child::input"));
		checkToCheckboxOrRadio(checkedCheckboxLabel);
		checkToCheckboxOrRadio(interderminateCheckbox);
		Assert.assertTrue(isElementSelected(checkedCheckboxinput));
		Assert.assertTrue(isElementSelected(interderminateCheckboxinput));
		
		uncheckToCheckbox(interderminateCheckbox);
		uncheckToCheckbox(interderminateCheckboxinput);
//		Assert.assertFalse(isElementSelected(checkedCheckboxinput));
//		Assert.assertFalse(isElementSelected(interderminateCheckboxinput));
		
		
		
		
		
		
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

	public void checkToCheckboxOrRadio(String xpathLocator) {
		if (!driver.findElement(By.xpath(xpathLocator)).isSelected()) {
			driver.findElement(By.xpath(xpathLocator)).click();

		}

	}

	public void checkToCheckboxOrRadio(WebElement element) {
		if (!element.isSelected()) {
			element.click();
		}

	}

	public void uncheckToCheckbox(String xpathLocator) {
		if (driver.findElement(By.xpath(xpathLocator)).isSelected()) {
			driver.findElement(By.xpath(xpathLocator)).click();

		}
	}

	public void uncheckToCheckbox(WebElement element) {
		if (element.isSelected()) {
			element.click();
		}

	}

	public boolean isElementSelected (WebElement element) {
		return element.isSelected();
		
	}

	@AfterClass
	public void afterClass() {
//		 driver.quit();
	}
}
