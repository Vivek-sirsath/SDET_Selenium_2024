
/*
 * BeforeMethod - Will executes multiple times before each and every test method
 * AfterMethod - Will executes multiple times after each and every test method
*/

package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeMethodAfterMethod {
	@BeforeMethod
	void login() {
		System.out.println("Login");
	}

	@AfterMethod
	void logout() {
		System.out.println("Logout");
	}

	@Test(priority = 1)
	void search() {
		System.out.println("Search method");
	}

	@Test(priority = 2)
	void advancedSearch() {
		System.out.println("Advanced search method");
	}

	@Test(priority = 3)
	void openModule1() {
		System.out.println("Open Module 1 method");
	}

	@Test(priority = 4)
	void openModule2() {
		System.out.println("Open Module 2 method");
	}
}
