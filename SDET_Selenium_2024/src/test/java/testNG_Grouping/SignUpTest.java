package testNG_Grouping;

import org.testng.annotations.Test;

public class SignUpTest {

	@Test (priority = 1, groups = {"regression"})
	void signUpByGmail() {
		System.out.println("This is signup by Gmail...");
	}

	@Test (priority = 2, groups = {"regression"})
	void signUpByFacebook() {
		System.out.println("This is signup by Facebook...");
	}

	@Test (priority = 3, groups = {"regression"})
	void signUpByTweeter() {
		System.out.println("This is signup by Tweetwer...");
	}

}
