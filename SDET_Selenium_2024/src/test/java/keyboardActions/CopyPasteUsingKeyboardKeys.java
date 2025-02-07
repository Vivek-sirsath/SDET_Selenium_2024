package keyboardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CopyPasteUsingKeyboardKeys {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://text-compare.com/");
		
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Java Selenium");
		
		Actions act = new Actions(driver);
		
		// Control+A for selecting all text
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		// Control+C for copying selected text
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		// Switching between tabs
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		// Control+V for pasting all copied text
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		String tab2Text = driver.findElement(By.xpath("//textarea[@id='inputText2']")).getText();
		
		System.out.println(tab2Text);
		
	}

}
