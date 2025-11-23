package testNG_Listener_ExtentReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCasesClass {

	WebDriver driver;

	@BeforeClass
	void setup() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	@Test
	void testLogo() {
		boolean statusLogo = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(statusLogo, true);
	}

	@Test
	void testURL() {
		String url = driver.getCurrentUrl();
		System.out.println("Application URL is:- " + url);
		Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/");
	}

	@Test(dependsOnMethods = { "testURL" })
	void testTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
//		Assert.assertEquals(driver.getTitle(), "OrangeHRM"); // Also valid
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}

}
