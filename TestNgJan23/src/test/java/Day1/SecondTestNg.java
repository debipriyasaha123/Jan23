package Day1;

import org.testng.annotations.Test;

public class SecondTestNg {
	

	@Test (priority = 2, enabled = true)
	public void login() {
		
		System.out.println("Inside login method");
		//throw new ArithmeticException();
	}
	@Test (priority = 0)
	public void testscript_3() {
		
		System.out.println("I am in Testscript_3");
	}
	@Test (priority = 1, enabled = true)
	public void testscript_4() {
		
		System.out.println("I am in Testscript_4");
	}
	

}
