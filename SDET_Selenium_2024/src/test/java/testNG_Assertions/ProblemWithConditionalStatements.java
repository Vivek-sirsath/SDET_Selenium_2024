package testNG_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProblemWithConditionalStatements {
	@Test
	void testTitle() {
		String exp_title = "Opencart";
		String actual_title = "Openshop";
/*
		if (exp_title.equals(actual_title)) {
			System.out.println("test passed...");
		} else {
			System.out.println("test failed...");
		}
*/
		Assert.assertEquals(actual_title, exp_title);

	}
//	1) If conditional statement used for validations :-
//	   Expected and Actual not matching. But still the 'testTitle' is shows as PASSED.
//	   But Assertions shows 'testTitle' as FAILED
	
//     Console Output:
	
//	   test failed...
//	   PASSED: testTitle

//	2) If assertions used for validations :-
	
//	   FAILED: testTitle
}
