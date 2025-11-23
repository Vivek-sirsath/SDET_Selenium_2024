package shadowDOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnderstandingShadowDOM1 {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dev.automationtesting.in/shadow-dom");
		
		// Finding 1st shadow element
//		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
//		Thread.sleep(2000);
//		Get the text of 1st shadow element
//		String element1 = shadow0.findElement(By.cssSelector("#shadow-element")).getText();
//		System.out.println("1st shadow element text is:- " + element1);
		
		// Finding 2nd shadow element
//		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
//		Thread.sleep(2000);
//		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
//		Thread.sleep(2000);
//		String element2 = shadow1.findElement(By.cssSelector("#nested-shadow-element")).getText();
//		System.out.println("2nd shadow element text is:- " + element2);
		
		// Finding 3rd shadow element
		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(2000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(2000);
		SearchContext shadow2 = shadow1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		Thread.sleep(2000);
		String element3 = shadow2.findElement(By.cssSelector("#multi-nested-shadow-element")).getText();
		System.out.println("3rd shadow element text is:- " + element3);		
		
	}

}
