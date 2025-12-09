package webTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

//		1) Find total number of rows in table
		// If Web page has multiple tables
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tbody//tr")).size();
		// If web page has single web table
		// int rows2 = driver.findElements(By.tagName("tr")).size();

		System.out.println("Number of rows: " + rows); // 7 // try rows2

//		2) Find total number of columns
		// If Web page has multiple tables
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//tbody//th")).size();
		// If web page has single web table
		// int cols2 = driver.findElements(By.tagName("th")).size();

		System.out.println("Number of columns: " + cols); // 4 // try cols2
		
		Thread.sleep(5000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver ;		
		jse.executeScript("window.scrollBy(0,1300)");
		
		System.out.println("");		

//		3) Read the data from specific row and column (e.g. 5th row and 1st column)
		String r5c1 = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[5]//td[1]")).getText();
		System.out.println(r5c1); // Master in Selenium
		
		System.out.println("");	

//		4) Read data from all the rows and columns
		
		// We can't pass variables directly into XPath, we can do this using small syntax
		// We can't pass String values in XPath, Only index numbers we can pass
		// We can pass dynamically at the index, Syntax: ["+variable+"]
		// "\t" : TABSPACE [Must use Backward Slash]
		// Here, we've parameterized the data into XPath

		System.out.println("BookName" + "\t" + "Author" + "\t" + "Subject" + "\t" + "Price");
		for (int r = 2; r <= rows; r++) {
			for (int c = 1; c < cols; c++) {
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[" + r + "]//td[" + c + "]"))
						.getText();
				System.out.print(value + "\t"); // "\t" : TABSPACE with forward slash
			}
			System.out.println();
		}
		
		System.out.println("");	
		
//		5) Print book names whose author is Mukesh
		
		for (int r = 2; r <= rows; r++) {
			String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr["+r+"]//td[2]")).getText();
			
			if(authorName.equals("Mukesh")) {
				String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr["+r+"]//td[1]")).getText();
				System.out.println(bookName + "\t" + authorName );
			}
		}
		
		System.out.println("");	
		
//		6) Total price of all the books
		
		int total = 0;
		for(int r = 2; r <= rows; r++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr["+r+"]//td[4]")).getText();
			total = total + Integer.parseInt(price); // getText() returns String, so need to convert to int
		}
		System.out.println(total);
		
		driver.close();
	}
	
}
