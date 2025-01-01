package windowHandling;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetWindowHandlesForTwoWindows {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set<String> windowIDs = driver.getWindowHandles(); // have parent and child window IDs
		
/*		Approach 01
        This approach is recommended for two windows
 
		Convert Set into List using ArrayList
		Q. Why converted Set into List?
		- We don't have get() method in set collection, so we can't retrieve individual item
*/		
//		List<String> windowList = new ArrayList(windowIDs); // This also works
		List<String> windowList = new ArrayList<String>(windowIDs);
		String parentID = windowList.get(0);
		String childID = windowList.get(1);
		
//		Even if we opened the child window, our driver is still focused on parent window.
		System.out.println(driver.getTitle()); // OrangeHRM
		// To switch to child window
		driver.switchTo().window(childID);
		System.out.println(driver.getTitle());
		
		
		

	}

}
