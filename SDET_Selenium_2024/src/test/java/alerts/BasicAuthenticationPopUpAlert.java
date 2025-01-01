package alerts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthenticationPopUpAlert {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

/*
		  https://the-internet.herokuapp.com/basic_auth This link will open the pop-up
		  alert which is asking Username and Password.
		  Here, we don't need to switchTo alert, Instead of this we'll directly
		  pass the username and password along with URL.
		  Then alert will be handled.
		  
		  Syntax: https://username:passsword@the-internet.herokuapp.com/basic_auth
		     i.e. https://admin:admin@the-internet.herokuapp.com/basic_auth
 */
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

//		Validate if authentication is done or not.
		WebElement el = driver.findElement(By.xpath(
				"//div[@class='example']/p[contains(text(),'Congratulations! You must have the proper credentials.')]"));
		
		String expectedText = "Congratulations! You must have the proper credentials.";
		
		if(el.getText().equals(expectedText)) {
			System.out.println("Authentication alert handled");
		}
		
	}

}
