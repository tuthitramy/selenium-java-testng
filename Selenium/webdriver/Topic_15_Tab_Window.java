package webdriver;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_15_Tab_Window {
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

	public void switchToExpectWindow(String expectedPageTitle) {
		Set<String> allWindowsIDs = driver.getWindowHandles();
		// Chạy từng id của windows
		for (String id : allWindowsIDs) {
			driver.switchTo().window(id);

			// Verify title của từng id:
			String actualPageTitle = driver.getTitle();
			if (actualPageTitle.equals(expectedPageTitle)) {
				break;

			}

		}

	}
	public void clickToNewLink(String xpathLocator){
		WebElement element = driver.findElement(By.xpath(xpathLocator));
		element.click();

	}

	public void scrollToViewElement(String xpathLocator){
		WebElement Element = driver.findElement(By.xpath(xpathLocator));
		js.executeScript("arguments[0].scrollIntoView();", Element);
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

	@Test
	public void TC_01_Automationfc_Page() {

		driver.get("https://automationfc.github.io/basic-form/index.html");
		String parentPagetitle = driver.getTitle();
		WebElement Element = driver.findElement(By.xpath("//legend[text()='Window']"));

		// Scroll into Google element
		js.executeScript("arguments[0].scrollIntoView();", Element);

		// Di chuyển đến Google
		clickToNewLink("//a[text()='GOOGLE']");
		sleepInSecond(5);
		switchToExpectWindow("GOOGLE");
		sleepInSecond(5);
		Assert.assertEquals(driver.getTitle(), "Google");

		switchToExpectWindow(parentPagetitle);

		clickToNewLink("//a[text()='FACEBOOK']");
		switchToExpectWindow("FACEBOOK");
		Assert.assertEquals(driver.getTitle(),"Facebook – log in or sign up");
		driver.findElement(By.xpath("//a[@role='button' and text()='Create New Account']")).click();
		sleepInSecond(10);

		switchToExpectWindow(parentPagetitle);

		clickToNewLink("//a[text()='TIKI']");
		switchToExpectWindow("Tiki");
		Assert.assertEquals(driver.getTitle(), "Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("abcxyz");

		driver.close();
		switchToExpectWindow("Facebook");
		driver.close();
		switchToExpectWindow("google");
		driver.close();
		switchToExpectWindow(parentPagetitle);
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/index.html");





	}

	@Test

	public void TC_02_Kyna_Page() {

		driver.get("https://kyna.vn/");
		String parentPagetitle= driver.getTitle();
		WebElement Element = driver.findElement(By.xpath("//h4[text()='Kết nối với Kyna']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		clickToNewLink("//second[text()='hotro@kyna.vn']//ancestor::ul//following-sibling::div/a[contains(@href,'facebook')]");
		clickToNewLink("//second[text()='hotro@kyna.vn']//ancestor::ul//following-sibling::div/a[contains(@href,'youtube')]");
		clickToNewLink("//a[contains(@href ,'CustomWebsiteDisplay')]");
		clickToNewLink("//a[contains(@href ,'WebDetails')]");
	}

	@Test
	public void TC_03_Techpanda() {
		driver.get("http://live.techpanda.org/");
		String parentPagetitle= driver.getTitle();
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		//Add sản phẩm để compare
		driver.findElement(By.xpath("//a[@title='Sony Xperia']/parent::h2//following-sibling::div[@class='actions']/ul/li[2]/a[text()='Add to Compare']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "The product Sony Xperia has been added to comparison list.");
		driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/parent::h2//following-sibling::div[@class='actions']/ul/li[2]/a[text()='Add to Compare']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "The product Samsung Galaxy has been added to comparison list.");

		//Click to Compare button and switch to
		driver.findElement(By.xpath("//button[@title='Compare']")).click();
		switchToExpectWindow("Products Comparison List - Magento Commerce");




		//Switch qua cửa sổ mới
		scrollToViewElement("//span[text()='Description']");
		sleepInSecond(5);
		driver.findElement(By.xpath("//span[text()='Close Window']")).click();
		//Switch lại main page
		switchToExpectWindow(parentPagetitle);
		driver.findElement(By.xpath("//a[text()='Clear All']")).click();
		sleepInSecond(5);

        //Accept Alert
		driver.switchTo().alert().accept();
		sleepInSecond(5);

		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']")).getText(),"The comparison list was cleared.");


	}

	@Test
	public void TC_04_Cambridge_Page() {
		driver.get("https://dictionary.cambridge.org/vi/");
		sleepInSecond(5);
		driver.findElement(By.xpath("//i//following-sibling::span[text()='Đăng nhập']")).click();

		//Switch qua cửa sổ mới
		switchToExpectWindow("Login");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Email *']/following-sibling::span")).getText(), "This field is required");
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Password *']/following-sibling::span")).getText(), "This field is required");
        // Nhập dữ liệu vào Email and PW
		driver.findElement(By.xpath("//input[@placeholder='Email *']")).sendKeys("automationfc.com@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys("Automation000***");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		sleepInSecond(5);

		switchToExpectWindow("Cambridge Dictionary");
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Automation FC']")).isDisplayed());



	}

	@Test
	public void TC_05_() {
	}

	@Test
	public void TC_06_() {
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
