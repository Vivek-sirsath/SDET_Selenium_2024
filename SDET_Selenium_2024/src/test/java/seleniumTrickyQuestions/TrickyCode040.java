
/*
Q. What is the output of the below code snippet ?
 
   Answer :- Both browser open the URL
   
   1. Both browser open the URL
   2. Only chrome opens the URL
   3. Compilation error
   4. Runtime exception
*/

package seleniumTrickyQuestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TrickyCode040 {

}

class TestPolymorphism extends TrickyCode040{
	
	public void performAction(WebDriver driver) {
		
		driver.get("https://example.com");
	}
	
	public static void main(String[] args) {
		
		TestPolymorphism test = new TestPolymorphism();
		
		test.performAction(new ChromeDriver());
		test.performAction(new FirefoxDriver());
	}
}
