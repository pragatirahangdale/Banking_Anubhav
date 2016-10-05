import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FactorialTest {

	// test cases for factorial

	/*
	 * 1. when the number is zero system shuold return 1
	   2. when the number is one system should return 1
	   3. when the number is positive system should return expected 
	   output
	   4. when the number is negative system should throw exception
*/

	Maths m;
	@Before
	public void setUp() throws Exception {
		m=new Maths();
	}

	@Test
	public void whenTheNumberIsZeroSystemShouldReturnOne() {
		assertEquals(1, m.getFactorial(0));
	}
	
/*	@Test
	public void whenTheNumberIsPositiveSystemShouldReturnExpectedOutput()
	{
		assertEquals(24, m.getFactorial(4));
	}*/
	
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void whenTheNumberIsNegativeSystemShouldThrowException()
	{
		m.getFactorial(-5);
	}
	

}
