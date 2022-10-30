package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Exercise_Web_Element {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	By emailTextBox = By.xpath("//input[@id='mail']");
	By ageUnder18CheckBox = By.xpath("//input[@id='under_18']");
	By eduTextBox = By.xpath("//textarea[@id='edu']");
	By nameUser5 = By.xpath("//h5[text()='Name: User5']");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_isDisplay() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		if (driver.findElement(emailTextBox).isDisplayed()) {
			driver.findElement(emailTextBox).sendKeys("Automation Testing");
			System.out.println("Email TextBox is displayed");
		} else {
			System.out.println("Email TextBox is not displayed");
		}
		if (driver.findElement(ageUnder18CheckBox).isDisplayed()) {
			driver.findElement(ageUnder18CheckBox).click();
			System.out.println("Age Checkbox is displayed");
		} else {
			System.out.println("Age Checkbox is not displayed");

		}
		if (driver.findElement(eduTextBox).isDisplayed()) {
			driver.findElement(eduTextBox).sendKeys("Automation Testing");
			System.out.println("Education TextBox is displayed");
		} else {
			System.out.println("Education Checkbox is not displayed");

		}
		if (driver.findElement(nameUser5).isDisplayed()) {
			System.out.println("Name:User5 text is not displayed");
		} else {
			System.out.println("Name:User5 text is not displayed");

		}

	}

	@Test
	public void TC_01_isEnable() {
		// Step 01: Truy cập vào trang
		driver.get("https://automationfc.github.io/basic-form/index.html");

		// Step 02:Kiểm tra các phần từ có Enable
		if (driver.findElement(emailTextBox).isEnabled()) {
			driver.findElement(emailTextBox).sendKeys("Automation Testing");
			System.out.println("Email TextBox is enabled");
		} else {
			System.out.println("Email TextBox is disabled");
		}

		if (driver.findElement(ageUnder18CheckBox).isEnabled()) {
			System.out.println("Age Checkbox is enabled");
		} else {
			System.out.println("Age Checkbox is disabled");
		}

		if (driver.findElement(eduTextBox).isEnabled()) {
			System.out.println("Education Checkbox is enabled");
		} else {
			System.out.println("Education Checkbox is disabled");
		}

		if (driver.findElement(By.xpath("//select[@id='job1']")).isEnabled()) {
			System.out.println("Job Role 01 is enabled");
		} else {
			System.out.println("Job Role 01 is disabled");

		}

		if (driver.findElement(By.xpath("//select[@id='job2']")).isEnabled()) {
			System.out.println("Job Role 02 is enabled");
		} else {
			System.out.println("Job Role 02 is disabled");

		}

		if (driver.findElement(By.xpath("//input[@id='development']")).isEnabled()) {
			System.out.println("Interest Development Checkbox is enabled");
		} else {
			System.out.println("Interest Development Checkbox is disabled");

		}

		if (driver.findElement(By.xpath("//input[@id='slider-1']")).isEnabled()) {
			System.out.println("Slider 01 is enabled");
		} else {
			System.out.println("Slider 01 is disabled");

		}

		// Step 03: Kiểm tra các phần tử có Disale
		if (driver.findElement(By.xpath("//input[@type='password']")).isEnabled()) {
			System.out.println("Password Textbox is enabled");
		} else {
			System.out.println("Password Textbox is disabled");

		}

		if (driver.findElement(By.xpath("//input[@id='radio-disabled']")).isEnabled()) {
			System.out.println("This radio button is enabled");
		} else {
			System.out.println("This radio button is disabled");

		}

		if (driver.findElement(By.xpath("//textarea[@name='user_bio']")).isEnabled()) {
			System.out.println("Biography Textbox is enabled");
		} else {
			System.out.println("Biography Textbox is disabled");

		}

		if (driver.findElement(By.xpath("//select[@name='user_job3']")).isEnabled()) {
			System.out.println("Job Role 03 is enabled");
		} else {
			System.out.println("Job Role 03 is disabled");

		}

		if (driver.findElement(By.xpath("//input[@id='check-disbaled']")).isEnabled()) {
			System.out.println("Interest checkbox is enabled");
		} else {
			System.out.println("Interest checkbox is disabled");

		}

		if (driver.findElement(By.xpath("//input[@id='slider-2']")).isEnabled()) {
			System.out.println("Slider 02 is enabled");
		} else {
			System.out.println("Slider 02 is disabled");

		}

	}

	@Test
	public void TC_03_isSelected() {
		// Step 01: Truy cập vào trang
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Step 02: Click chọn 
		driver.findElement(ageUnder18CheckBox).click();
		driver.findElement(By.xpath("//input[@id='java']")).click();
		
		//Step 03: Check isSelected đã chọn ở Steps 02	
		
		if (driver.findElement(ageUnder18CheckBox).isSelected()) {
			System.out.println("Under 18 Checkbox is selected");
		} else {
			System.out.println("Under 18 Checkbox is not selected");

		}
		
		if (driver.findElement(By.xpath("//input[@id='java']")).isSelected()) {
			System.out.println("JAVA Checkbox is selected");
		} else {
			System.out.println("JAVA Checkbox is not selected");

		}
		//Step 04: Click bỏ chọn checkbox JAVA
		driver.findElement(By.xpath("//input[@id='java']")).click();
		//Step 05: Kiểm tra phần tử đã được bỏ chọn
		if (driver.findElement(By.xpath("//input[@id='java']")).isSelected()) {
			System.out.println("JAVA Checkbox is selected");
		} else {
			System.out.println("JAVA Checkbox is not selected");

		}
		

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
