
/*
 * BeforeTest - Will executes once before all test method execution
 * AfterTest - Will executes once after all test method execution
*/

package testNG_BTAT_BSAS;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeTestAfterTest {

	@Test(priority = 1)
	void m2() {
		System.out.println("This is second test method");
	}

	@BeforeTest
	void m1() {
		System.out.println("BeforeTest method executing once before executing all Test methods");
	}

	@Test(priority = 4)
	void m4() {
		System.out.println("This is forth test method");
	}

	@Test(priority = 5)
	void m5() {
		System.out.println("This is fifth test method");
	}

	@Test(priority = 2)
	void m3() {
		System.out.println("This is third test method");
	}

	@AfterTest
	void m6() {
		System.out.println("AfterTest method executing once after executing all Test methods");
	}
}
