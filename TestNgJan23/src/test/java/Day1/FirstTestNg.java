package Day1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Day2.MyTestNgListeners.class)
public class FirstTestNg {

	@Test (priority = 2, enabled = false)
	public void login() {
		
		System.out.println("Inside login method");
		//throw new ArithmeticException();
	}
	@Test (priority = 0)
	public void testscript_1() {
		
		System.out.println("I am in Testscript_1");
	}
	@Test (priority = 1, enabled = true)
	public void testscript_2() {
		
		System.out.println("I am in Testscript_2");
	}
	
}




//annotation
//@Test