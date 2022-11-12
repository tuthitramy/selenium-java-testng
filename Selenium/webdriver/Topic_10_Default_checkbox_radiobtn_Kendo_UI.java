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

public class Topic_10_Default_checkbox_radiobtn_Kendo_UI {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Random rand = new Random();
	By dualCheckboxxpath = By.xpath("//label[text()='Dual-zone air conditioning']//preceding-sibling::input");
	By thirdRaditobtnxpath = By.xpath("//label[text()='2.0 Petrol, 147kW']//preceding-sibling:: input");


	
	
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
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();


	}

	@Test
	public void TC_01_Kendo_UI() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		sleepInSecond(3);
		js.executeScript("window.scrollBy(0,300)", "");
		sleepInSecond(10);
		
		

	}

	@Test

	public void TC_02_SelectAllandverify() {
		// Dùng vòng lặp để duyệt qua và click chọn
//		List<WebElement> allCheckboxes = driver.findElements(By.xpath("//div[@id='example']//input[@type='checkbox']"));
//		for (WebElement checkbox : allCheckboxes) {
//			if (checkbox.isSelected() && checkbox.isEnabled()) {
//				System.out.println(checkbox);
//				checkbox.click();
//				sleepInSecond(1);
//				Assert.assertTrue(!checkbox.isSelected() && checkbox.isEnabled());
//				

//			}

//		}
	}

	@Test
	public void TC_03_ClickandVerifydualCheckbox() {
//		WebElement dualCheckbox = driver.findElement(dualCheckboxxpath);
//		checkToCheckboxOrRadio(dualCheckbox);
//		Assert.assertTrue(dualCheckbox.isSelected());

	}

	@Test
	public void TC_04_uncheckCheckbox() {
//		WebElement dualCheckbox = driver.findElement(dualCheckboxxpath);
//		uncheckToCheckbox(dualCheckbox);
//		Assert.assertFalse(dualCheckbox.isSelected());
	}

	@Test
	public void TC_05_checkToRadioButton() {
		driver.get("http://demos.telerik.com/kendo-ui/styling/radios");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		sleepInSecond(3);
		js.executeScript("window.scrollBy(0,300)", "");
		sleepInSecond(10);
		WebElement thirdRadiobtn = driver.findElement(thirdRaditobtnxpath);
		checkToCheckboxOrRadio(thirdRadiobtn);
		Assert.assertTrue(isElementSelected(thirdRadiobtn));
		checkToCheckboxOrRadio(driver.findElement(By.xpath("//label[text()='2.0 Diesel, 103kW']//preceding-sibling::input")));
		if (isElementSelected(thirdRadiobtn)==true) {
			System.out.println("Radio button is selected");
			
		}
		else {
			checkToCheckboxOrRadio(thirdRadiobtn);
			
		}
	}

	@Test
	public void TC_06_() {

	}

//	public void sleepInSecond(long timeInSecond) {
//		try {
//			Thread.sleep(timeInSecond * 1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
	
//	}
	

	public void checkToCheckboxOrRadio(String xpathLocator) {
//		if (!driver.findElement(By.xpath(xpathLocator)).isSelected()) {
//			driver.findElement(By.xpath(xpathLocator)).click();
//
//		}

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
