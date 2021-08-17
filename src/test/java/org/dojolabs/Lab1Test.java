package org.dojolabs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Problem:
 * This problem was recently asked by Google.
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Bonus: Can you do this in one pass?

 * @author Bruno
 *
 */
public class Lab1Test {

	@Test
	public void givenArray_thenShouldReturnTrue1() {
		int[] array = { 10, 15, 3, 7 };
		assertTrue(Lab1.doesAnyTwoNumbersAddToKRecursively(array, 17));
	}
	
	@Test
	public void givenArray_thenShouldReturnTrue2() {
		int[] array = { 10, 15, 3, 7, 30,  60, 13};
		assertTrue(Lab1.doesAnyTwoNumbersAddToKRecursively(array, 45));
	}
	
	@Test
	public void givenArray_thenShouldReturnTrue3() {
		int[] array = { 10, 15, 3, 7, 30,  60, 13};
		assertTrue(Lab1.doesAnyTwoNumbersAddToKRecursively(array, 18));
	}
	
	@Test
	public void givenArray_thenShouldReturnFalse() {
		int[] array = { 10, 15, 3, 8 };
		assertFalse(Lab1.doesAnyTwoNumbersAddToKRecursively(array, 17));
	}
}
