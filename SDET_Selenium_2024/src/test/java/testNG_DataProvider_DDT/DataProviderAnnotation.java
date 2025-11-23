package testNG_DataProvider_DDT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAnnotation {

	WebDriver driver;

	@BeforeClass
	void setup() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(dataProvider = "loginData")
	void testLogin(String email, String password) throws InterruptedException {

		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(5000);

		Boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();

		if (status == true) {
			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}

	@AfterClass
	void tearDown() {

		driver.close();
	}

	
	// Two dimensional array means, not only 2 rows and 2 columns.
	// It means n-number of rows and n-number of columns.
	// We can choose specific data based on specific indices respectively.
	@DataProvider(name = "loginData", indices = {0,2,5})
	Object[][] loginData() {

		Object data[][] = 
			{ 
					{ "first@gmail.comm", "pass@first" }, 
					{ "second@gmail.com", "pass@second" },
				    { "vivek.sirsath007@gmail.com", "abc@123" }, 
				    { "forth@gmail.com", "pass@forth" }, 
				    { "fifth@gmail.com", "pass@fifth" },
				    { "sixth@gmail.com", "pass@sixth" },
			};
		return data;
	}

}
