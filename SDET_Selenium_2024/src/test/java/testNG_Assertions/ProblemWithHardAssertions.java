package testNG_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProblemWithHardAssertions {

	// @Test
	void test_HardAssertion() {

		System.out.println("line 1....");
		System.out.println("line 2....");

		Assert.assertEquals(123, 456); // Assertion failed, further execution stopped
		// FAILED: test_HardAssertion

		System.out.println("line 3....");
		System.out.println("line 4....");
	}

	@Test
	void test_SoftAssertion() {

		System.out.println("line 1....");
		System.out.println("line 2....");

		SoftAssert sa = new SoftAssert(); // Assertion failed, further execution continued
		sa.assertEquals(123, 456); // PASSED: test_SoftAssertion

		System.out.println("line 3....");
		System.out.println("line 4....");

//		It shows Test PASSED, But it should failed.
//		We can use n number of soft asserts. But at the end of the soft assert we've to use.
		sa.assertAll(); // Use is Mandatory // FAILED: test_SoftAssertion
	}
}
