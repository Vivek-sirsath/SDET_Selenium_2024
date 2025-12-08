
/*
 * BeforeClass - Will executes only one time before all test methods
 * AfterClass - Will executes only one time after all test methods
*/

package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeClassAfterClass {
	@BeforeClass
	void login() {
		System.out.println("Login");
	}

	@AfterClass
	void logout() {
		System.out.println("Logout");
	}

	@Test(priority = 1)
	void search() {
		System.out.println("This is Search method");
	}

	@Test(priority = 2)
	void advancedSearch() {
		System.out.println("This is Advanced search method");
	}

	@Test(priority = 3)
	void openModule1() {
		System.out.println("This is Module 1 method");
	}

	@Test(priority = 4)
	void openModule2() {
		System.out.println("This is Module 2 method");
	}
}
