package dropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Url opened");

		// Login
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		System.out.println("Login Successfull");
		Thread.sleep(2000);

		// Click on PIM menu
		driver.findElement(By.xpath("//aside[@class='oxd-sidepanel']//li[2]")).click(); // PIM Menu
		System.out.println("Clicked on PIM menu");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//aside[@class='oxd-sidepanel']//li[2]")).click();
		
		driver.navigate().refresh();

		// Click on dropdown
		driver.findElement(By.xpath(
				"//div[6]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]"))
				.click();
		System.out.println("Clicked on dropdown");
		
		// Select option from dropdown
		driver.findElement(By.xpath("//div[@role='listbox']//div[19]")).click();
		System.out.println("QA ENGINEER option selected from dropdown");
		System.out.println("Hidden dropdown handled successfully");

	}

}
