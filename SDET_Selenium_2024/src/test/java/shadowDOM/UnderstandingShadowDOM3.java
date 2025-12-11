package shadowDOM;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnderstandingShadowDOM3 {

	public static void main(String[] args) throws InterruptedException, AWTException{
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://books-pwakit.appspot.com/");
		
		String bookName = "Jurassic Park";
		
		// Enter search text in search box
		SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		shadow.findElement(By.cssSelector("#input")).sendKeys(bookName);
		
		// Press ENTER button
		Robot rob = new Robot();  // AWTException @ this line
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000);
		
		// Traverse through SHADOW DOM until the element.
		SearchContext shadow0 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(2000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("book-explore[class='_page']")).getShadowRoot();
		Thread.sleep(2000);		
		// section:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > book-item:nth-child(1)
		SearchContext shadow2 = shadow1.findElement(By.cssSelector("section:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > book-item:nth-child(1)")).getShadowRoot();
		Thread.sleep(2000);	
		
		// Retrieve name of the book.
		String title = shadow2.findElement(By.cssSelector(".title")).getText();
		
		// Validate the search content
		if (title.contains(bookName)) {
			System.out.println("Book found....");
		} else {
			System.out.println("Book not found...!");
		}
		
		System.out.println("Book Title:- " + title);
		
		if (driver != null) {
            driver.quit();
        }

	}

}
