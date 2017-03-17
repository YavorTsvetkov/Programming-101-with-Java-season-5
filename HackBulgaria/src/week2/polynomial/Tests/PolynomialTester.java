package week2.polynomial.Tests;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import week2.polynomial.Polynomial;

public class PolynomialTester {
	private Polynomial firstPolynomial;
	private Polynomial secondPolynomial;
	
	@Before
	public void initPolynomial() {
		this.firstPolynomial = new Polynomial("2x^4 + 3x^2 - 10x + 3");
		this.secondPolynomial = new Polynomial("- x^3 + 2x^2 + 2x - 1");
	}
	
	@Test
	public void testEquality() {
		boolean areEquals = this.firstPolynomial.equals(secondPolynomial);
		
		Assert.assertEquals(false, areEquals);
	}
	
	@Test
	public void testDiversity() {
		Polynomial thirdPoly = new Polynomial("2x^4 + 3x^2 - 10x + 3");
		boolean areDiverse = this.firstPolynomial.equals(thirdPoly);
		
		Assert.assertEquals(true, areDiverse);
	}
	
	@Test
	public void testAddition() {
		Polynomial result = Polynomial.addition(firstPolynomial, secondPolynomial);
		
		Polynomial expected = new Polynomial("2x^4 - x^3 + 5x^2 - 8x + 2");
		
		Assert.assertEquals(expected.toString(), result.toString());
	}
	
	@Test
	public void testSubtraction() {
		Polynomial result = Polynomial.subtract(firstPolynomial, secondPolynomial);
		Polynomial expected = new Polynomial("2x^4 + x^3 + x^2 - 12x + 4");
		
		Assert.assertEquals(expected, result);
	}
	
}
