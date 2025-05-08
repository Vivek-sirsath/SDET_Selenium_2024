
/*
Q. Which issue does this code present ?
 
   Answer :- NullPointerException due to uninitialized driver when usernameField is accessed.
   
   1. No issues, it follows OOP principles.
   2. NullPointerException due to uninitialized driver when usernameField is accessed.
   3. Missing method override for initializeDriver().
   4. Improper use of driver as a non-final static variable.
*/

package seleniumTrickyQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrickyCode041 {

}

class BaseTest extends TrickyCode041 {
	
	public static WebDriver driver;
	
	public void initializeDriver() {
		driver = new ChromeDriver();
	}
	
}

class LoginTest extends BaseTest {
	
	public WebElement usernameField = driver.findElement(By.id("username"));
	
}



