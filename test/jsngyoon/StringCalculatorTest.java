package jsngyoon;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
	private StringCalculator sc;

	@Before
	public void setUp() throws Exception {
		sc = new StringCalculator();
	}

	@Test
	public void testAdd() {
		int result = 1+2+3;		
		assertEquals(result, sc.add("1,2:3"));
		assertEquals(result, sc.add("//#\n1#2#3"));
	}
	
	@Test(expected=RuntimeException.class)
	public void testAddException() throws RuntimeException {
		//expectedException.expect(RuntimeException.class);
		sc.add("1,-1,2");
	}

}
