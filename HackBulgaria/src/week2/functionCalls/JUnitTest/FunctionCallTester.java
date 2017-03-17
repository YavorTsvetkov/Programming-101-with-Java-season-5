package week2.functionCalls.JUnitTest;

import week2.functionCalls.FunctionCalls;

import org.junit.Assert;
import org.junit.Test;


public class FunctionCallTester {
	
	@Test
	public void calcCompositionTest1() {
		String comp = "f2";
		int arg = 1;
		
		int result = FunctionCalls.calcComposition(comp, arg);
		
		Assert.assertEquals(2, result);
	}
	
	@Test
	public void calcCompositionTest2() {
		String comp = "f2 . f2";
		int arg = 1;
		
		int result = FunctionCalls.calcComposition(comp, arg);
		Assert.assertEquals(4, result);
	}
	
	
	@Test
	public void calcCompositionTest3() {
		String composition = "f1 . f2 . f3 . f4";
		int arg = 5;
		
		int result = FunctionCalls.calcComposition(composition, arg);

		Assert.assertEquals(199, result);
	}
	
}
