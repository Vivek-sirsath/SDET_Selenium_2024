
/*
 * # Alternate Way to getText() method.
 * ------------------------------------
 * 
 * IMPORTANT:- In DoubleClick class getText() method is unable to capture the text in the box.
 * Because in DOM, there is no Text displayed in the DOM.
 * 
 *  getText(): method only capture the inner text of the element.
 *  Inner text is displayed between > and <
 *  
 *  e.g.
 *       <button ondblclick="myFunction1()" xpath="1">INNER TEXT</button>
 * 
 * In this case, alternate way to get the text of web element
 * 
 * getAttribute("attributeOfValue") method.
 * getAttribute() method can capture the text.
 */

package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1200)");
		
		Thread.sleep(5000);
		
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		field1.clear();
		field1.sendKeys("Vivek");
		
		String field1Text = field1.getAttribute("value");
		System.out.println("Field1 Text - " + field1Text);

		WebElement copyTextBtn = driver.findElement(By.xpath("//button[@ondblclick='myFunction1()']"));

		Actions act = new Actions(driver);
		act.moveToElement(copyTextBtn).build().perform();
		
		Thread.sleep(5000);
		
		act.doubleClick(copyTextBtn).perform();
		System.out.println("Clicked on 'Copy Text' button");
		
		Thread.sleep(10000);

		String field2Text = driver.findElement(By.xpath("//input[@id='field2']")).getAttribute("value");
		System.out.println("Field2 Text - " + field2Text);

		if (field1Text.equals("Vivek")) {
			System.out.println("Text copied.");
		}else {
			System.out.println("Text not copied properly...");
		}

	}

}
