package testNG_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {
	@Test
	void testMethod() {

//	  Assert.assertEquals("Actual", "Expected"); 

//    Assert.assertEquals("xyz", "xyz"); // PASSED: testMethod
//    Assert.assertEquals("xyz", "xyz1"); // FAILED: testMethod
//    Assert.assertEquals(123, 456); // FAILED: testMethod
//	  Assert.assertEquals("123", 123); // FAILED: testMethod
//	  Assert.assertNotEquals(123, 123); // FAILED: testMethod
//	  Assert.assertNotEquals("Jalgaon", "jlgaon"); //PASSED: testMethod
//	  Assert.assertTrue(true); // PASSED: testMethod
//	  Assert.assertTrue(false); // FAILED: testMethod
//	  Assert.assertTrue(1==2); // FAILED: testMethod
//    Assert.assertTrue(1==1); // PASSED: testMethod
//	  Assert.assertFalse(1==2); // PASSED: testMethod
//    Assert.assertFalse(1==1); // FAILED: testMethod
	  Assert.fail(); // FAILED: testMethod
		
	}
}
