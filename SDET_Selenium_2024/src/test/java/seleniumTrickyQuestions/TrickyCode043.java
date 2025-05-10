
/*
Q. What will be the output of the following code ?
 
   Answer :- Custom wait executed
   
   1. Compiler error
   2. No output
   3. Custom wait executed
   4. Runtime exception
*/

package seleniumTrickyQuestions;

interface WebDriverExtensions {
	default void customWait() {
		System.out.println("Custom wait executed");
	}
}

public class TrickyCode043 implements WebDriverExtensions {

	public static void main(String[] args) {

		TrickyCode043 driver = new TrickyCode043();

		driver.customWait();

	}

}
