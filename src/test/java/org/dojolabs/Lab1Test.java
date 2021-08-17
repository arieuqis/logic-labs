package org.dojolabs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Lab1Test {

	@Test
	public void givenArray_thenShouldReturnTrue1() {
		int[] array = { 10, 15, 3, 7 };
		assertTrue(Lab1.doesAnyTwoNumbersAddToK(array, 17));
	}
	
	@Test
	public void givenArray_thenShouldReturnTrue2() {
		int[] array = { 10, 15, 3, 7, 30,  60, 13};
		assertTrue(Lab1.doesAnyTwoNumbersAddToK(array, 45));
	}
	
	@Test
	public void givenArray_thenShouldReturnFalse() {
		int[] array = { 10, 15, 3, 8 };
		assertFalse(Lab1.doesAnyTwoNumbersAddToK(array, 17));
	}
}
