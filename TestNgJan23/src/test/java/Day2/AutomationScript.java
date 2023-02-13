package Day2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AutomationScript {
	
	@Test(dataProvider = "getData")
	public void JavaTest(int a, int b, int c) {
		
		int res;
		res = a+b;
		System.out.println("Sum of two numbers " +res);
	}

	@DataProvider
	public Object[][] getData(){
		Integer[][] data = new Integer [4][3];
		
		data [0][0] = 1;
		data [0][1] = 2;
		data [0][2] = 2;
		
		data [1][0] = 3;
		data [1][1] = 4;
		data [1][2] = 2;
		
		data [2][0] = 5;
		data [2][1] = 6;
		data [2][2] = 2;
		
		data [3][0] = 1;
		data [3][1] = 5;
		data [3][2] = 2;
		
		return data;
	}
}


//create xl sheet with 5 sets of userid and password.
//use dataprovider to feed it to login testscript