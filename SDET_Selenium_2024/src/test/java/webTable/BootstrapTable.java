/*
 * Bootstap Table: It is a tale where tr / td tags are not available
 * Instead of them only div tags are there.
 * Also, it dosent have pegination.
 * The rows in this kind of table may be reducing or increasing. 
 */


package webTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapTable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		
		// Select an 'Admin' menu from left side panel
		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']//span[normalize-space()='Admin']")).click();
		
		// To find the number of records
		List<WebElement> rowList = driver.findElements(By.xpath("//div[@role='table']//div[@class='oxd-table-card']"));
		System.out.println("Number of records: " + rowList.size());
		
		
		//div[@class='oxd-table-body']//div[1]//div[2]//div[contains(text(),'FMLName1')] // Incorrect XPath
		//div[@class='oxd-table-body']/child::div[3]/div/div[2] // Correct XPath
		
		
		for(int r = 1; r<=rowList.size(); r++) {
			String userName = driver
					.findElement(
							By.xpath("//div[@class='oxd-table-body']/child::div["+r+"]/div/div[2]"))
					.getText();
			
			String userRole = driver
					.findElement(
							By.xpath("//div[@class='oxd-table-body']/child::div["+r+"]/div/div[3]"))
					.getText();
			
			
			String employeeName = driver
					.findElement(
							By.xpath("//div[@class='oxd-table-body']/child::div["+r+"]/div/div[4]"))
					.getText();
			
			System.out.println(userName + "\t" + userRole + "\t" + employeeName);
		}

	}

}
