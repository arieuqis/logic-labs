package org.dojolabs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;

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
		assertTrue(Lab1Test.doesAnyTwoNumbersAddToKUsingO1(array, 17));
	}
	
	@Test
	public void givenArray_thenShouldReturnTrue2() {
		int[] array = { 10, 15, 3, 7, 30,  60, 13};
		assertTrue(Lab1Test.doesAnyTwoNumbersAddToKUsingO1(array, 45));
	}
	
	@Test
	public void givenArray_thenShouldReturnTrue3() {
		int[] array = { 10, 15, 3, 7, 30,  60, 13};
		assertTrue(Lab1Test.doesAnyTwoNumbersAddToKUsingO1(array, 18));
	}
	
	@Test
	public void givenArray_thenShouldReturnFalse() {
		int[] array = { 10, 15, 3, 8 };
		assertFalse(Lab1Test.doesAnyTwoNumbersAddToKUsingO1(array, 17));
	}
	
	public static boolean doesAnyTwoNumbersAddToKUsingO1(int[] numbers, int k) {
		HashSet<Integer> values = new HashSet<>();
		
		for (int i = 0; i < numbers.length; i++) {
			int currentNumber = numbers[i];
			int kMinusNumber = k - currentNumber;
			
			if( values.contains(kMinusNumber)) {
				System.out.println(String.format("The sum of number %s and %s are equal to %s", currentNumber, kMinusNumber, k));
				return true;
			}
			
			values.add(currentNumber);
		}
		
		return false;
	}
}
