
/*
Q. In below code what concept is applied ?
 
   Answer :- Factory Design Pattern
   
   1. Abstraction
   2. Factory Design Pattern
   3. Polymorphism
   4. Singleton Pattern
*/

package seleniumTrickyQuestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TrickyCode039 {

}

class BrowserFactory extends TrickyCode039 {

	public static WebDriver getDriver(String browserType) {
		if (browserType.equalsIgnoreCase("chrome")) {
			return new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("firefox")) {
			return new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("UnsupportdBrowserType");
		}

	}

}