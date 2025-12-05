package SeleniumJavaTipsAndTricks2024;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamicTable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice.expandtesting.com/dynamic-table");
		
		// 1) Find the no of rows
		List<WebElement> rows = driver.findElements(By.xpath("(//table[@class='table table-striped'])/tbody/tr"));
		System.out.println("No of rows: " + rows.size()); // 4
		
		// 2) Iterate through all the rows of first column
		for(int r = 1; r <= rows.size(); r++) {
			WebElement name = driver.findElement(By.xpath("(//table[@class='table table-striped'])/tbody/tr["+r+"]//td[1]"));
			
			if(name.getText().equalsIgnoreCase("Chrome")) {	
				
				String CPULoad = driver.findElement(By.xpath("//td[normalize-space()='Chrome']//following-sibling::*[contains(text(),'%')]")).getText();				
				String value = driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();
				
				if(value.contains(CPULoad)) {
					System.out.println("CPU load matching with the value");					
				}
				else {
					System.out.println("CPU load not matching");
					
				}
			}
		}
		driver.quit();
	}

}
