package testNG_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertDotAssertTrue {
	@Test
	void testTitle() {
		String exp_title = "Opencart";
		String actual_title = "Openshop";

		if (exp_title.equals(actual_title)) {
			System.out.println("test passed...");
			Assert.assertTrue(true);
		} else {
			System.out.println("test failed...");
			Assert.assertTrue(false); // Expected true but passing false
		}
	}
}

//  test failed...
//  FAILED: testTitle
