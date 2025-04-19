
/*
Q. In below code which design pattern is implemented ?
 
   Answer :- Singleton Pattern
   
   1. Observer Pattern
   2. Factory Pattern
   3. Builder Pattern
   4. Singleton Pattern
*/

package seleniumTrickyQuestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrickyCode038 {

}

class DriverManager extends TrickyCode038 {

	private static WebDriver driver;

	private DriverManager() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
		}
		return driver;
	}

}