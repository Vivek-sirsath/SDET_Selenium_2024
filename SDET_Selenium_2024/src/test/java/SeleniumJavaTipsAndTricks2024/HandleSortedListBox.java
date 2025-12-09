package SeleniumJavaTipsAndTricks2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleSortedListBox {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		
        Select drpDown = new Select(driver.findElement(By.xpath("//select[@id='animals']")));
        
        ArrayList origList = new ArrayList();
        ArrayList tempList = new ArrayList();
        
        List <WebElement> options = drpDown.getOptions();
        
        for(WebElement option : options) {
        	origList.add(option.getText());
        	tempList.add(option.getText());
        }
        
        // Before Sorting
        System.out.println("Before Sorting...");
        System.out.println("Original List: " + origList);
        System.out.println("Temporary List: " + tempList);
        
        Collections.sort(tempList);
        
        // After Sorting
        System.out.println("After Sorting...");
        System.out.println("Original List: " + origList);
        System.out.println("Temporary List: " + tempList);
        
        if(origList.equals(tempList)) {
        	System.out.println("List box is sorted...");
        }else {
        	System.out.println("List box is not sorted");
        }
        
        driver.quit();

	}

}
