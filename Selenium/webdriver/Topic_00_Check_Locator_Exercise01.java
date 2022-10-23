package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Check_Locator_Exercise01 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void TC_01_empty_data() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.xpath("//div[@class='field_btn']/button[text()='ĐĂNG KÝ']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtFirstname-error']")).getText(),"Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Vui lòng nhập số điện thoại.");
	}

	@Test
	public void TC_02_invalid_email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Tu Thi Tra My");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("123@456@343");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("25632@4t37@4");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("myqui07");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("myqui07");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0934575102");
		driver.findElement(By.xpath("//div[@class='field_btn']/button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");
		
		
		
	}

	@Test
	public void TC_03_incorrect_confirm_email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Tu Thi Tra My");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("tuthitramy02@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("tuthitramy03@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("myqui07");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("myqui07");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0934575102");
		driver.findElement(By.xpath("//div[@class='field_btn']/button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");
		
		
	}
	
	@Test
	public void TC_04_password_3_character() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Tu Thi Tra My");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("tuthitramy02@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("tuthitramy02@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("myqu");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("myqu");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0934575102");
		driver.findElement(By.xpath("//div[@class='field_btn']/button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
		
		
	}
	
	@Test
	public void TC_05_incorrect_confirm_password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Tu Thi Tra My");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("tuthitramy02@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("tuthitramy02@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("myqui07");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("myqui073");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0934575102");
		driver.findElement(By.xpath("//div[@class='field_btn']/button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu bạn nhập không khớp");
		
		
	}

	@Test
	public void TC_06_invalid_phonenumber() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Tu Thi Tra My");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("tuthitramy02@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("tuthitramy02@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("myqui07");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("myqui07");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("1243");
		driver.findElement(By.xpath("//div[@class='field_btn']/button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
		
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("094362");
		driver.findElement(By.xpath("//div[@class='field_btn']/button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại phải từ 10-11 số.");
		
		
		
	}


	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
