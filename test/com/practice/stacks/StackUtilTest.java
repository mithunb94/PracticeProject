package com.practice.stacks;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackUtilTest {

	@Test
	public void testIsDigitOrAlphabet() {
		assertTrue(StackUtil.isDigitOrAlphabet('9'));
		assertTrue(StackUtil.isDigitOrAlphabet('a'));
		assertTrue(StackUtil.isDigitOrAlphabet('A'));
		assertTrue(!StackUtil.isDigitOrAlphabet('-'));
	}
	
	@Test
	public void testInfixToPostfix() {
		assertEquals("234*5/+", StackUtil.infixToPostfix("2+3*4/5"));
		assertEquals("ABC*+", StackUtil.infixToPostfix("(A+(B*C))"));
		assertEquals("AB+ZX+*", StackUtil.infixToPostfix("((A+B)*(Z+X))"));
		assertEquals("AT+BAC++CD+^*", StackUtil.infixToPostfix("((A+T)*((B+(A+C))^(C+D)))"));	
	}

	@Test
	public void testInfixToPrefix() {
		assertEquals("+2*3/45", StackUtil.infixToPrefix("2+3*4/5"));
		assertEquals("+23", StackUtil.infixToPrefix("2+3"));
		assertEquals("+*+A^BCD^E5", StackUtil.infixToPrefix("(A+B^C)*D+E^5"));
	}
	
	@Test
	public void testEvaluateExpression() {
		assertEquals(6, StackUtil.evaluateExpression(("2+5*4/5")));
	}
}
