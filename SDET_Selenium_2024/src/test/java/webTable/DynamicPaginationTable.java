package webTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class DynamicPaginationTable {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/");

		Thread.sleep(5000);

		WebElement usernameTextBox = driver.findElement(By.xpath("//input[@id='input-username']"));
		usernameTextBox.clear();
		usernameTextBox.sendKeys("demo");

		WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id='input-password']"));
		passwordTextBox.clear();
		passwordTextBox.sendKeys("demo");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		// Click on 'Customers' main menu
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();

		// To find the number of pages
		// We have to capture the text value and we have to store in string
		// div[contains(text(),'Pages')]
		String text = driver.findElement(By.xpath("//div[contains(text(),'Pages')]")).getText();

		// [text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1)] will return
		// String
		// To convert String to Integer we've to use 'Integer.parseInt()'
		int total_pages = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
		System.out.println(total_pages);

		// To read the data from the table
		// To find total number of rows
		int noOfRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr"))
				.size();
		System.out.println("Number of Rows: " + noOfRows);

		for (int r = 1; r <= noOfRows; r++) {
			String customerName = driver
					.findElement(
							By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[2]"))
					.getText();
			String eMail = driver
					.findElement(
							By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[3]"))
					.getText();
			String dateAdded = driver
					.findElement(
							By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[5]"))
					.getText();

			System.out.println(customerName + "\t" + eMail + "\t" + dateAdded); // Must use forward slash in TABSPACE
		}

		// To iterate the pages
		// (int p=1; p<=total_pages; p++) will take lot time bcoz more pages are there
		// For this, we'll take only 5 pages
		for (int p = 1; p <= 5; p++) {

			if (p > 1) {
				WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()=" + p + "]"));
				active_page.click();
				Thread.sleep(2000);
			}

		}

	}
}
