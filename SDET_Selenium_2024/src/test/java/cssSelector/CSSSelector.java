
/*
 * CSS Selector - Cascading Style Sheets
 * 
 * NOTE: Remove blank spaces by Dot(.) while working with CSS Selectors
 * 
 * tag id               -----> tag#idValue                         ---> #idValue
 * tag class            -----> tag.classNameValue                  ---> .ClassNameValue
 * tag attribute        -----> tag[attribute='value']               
 * tag class attribute  -----> tag.className[attribute='value']
 * */

package cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelector {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.opencart.com");

//		1) tag id  --->  tag#idValue OR #idValue
		WebElement logo = driver.findElement(By.cssSelector("#logo"));
		System.out.println("1. Is application logo visible? - " + logo.isDisplayed());

//		2) tag class ---> tag.classValue Or (.classValue)
		// tag = 'input' // classValue = 'form-control form-control-lg'
		// Remove blank spaces by Dot(.)
//		WebElement searchBox = driver.findElement(By.cssSelector("input.form-control.form-control-lg"));
		WebElement searchBox = driver.findElement(By.cssSelector(".form-control.form-control-lg"));
		searchBox.click();
		searchBox.sendKeys("MacBook");
		System.out.println("2. In searchBox text entered 'MacBook'");

//		3) tag attribute ---> tag[attribute='value']
		WebElement opencartLogoImage = driver.findElement(By.cssSelector("img[alt='Your Store']"));
		System.out.println("3. Is logo image visible? - " + opencartLogoImage.isDisplayed());

//		4) tag class attribute ---> tag.className[attribute='value']
		// tag = 'button' // className = 'btn btn-light btn-lg' // attribute =
		// 'data-lang' // value = 'en-gb'
		// In className we need to remove blank spaces by Dot(.)
		driver.findElement(By.cssSelector("button.btn.btn-light.btn-lg[data-lang='en-gb']")).click();
		System.out.println("4) Search button clicked");

//		driver.close(); 
	}

}
