package org.dojolabs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * This problem was asked by Stripe.
 * Given an array of integers, find the first missing positive integer in linear time
 *  and constant space. In other words, find the lowest positive integer that does not exist in the array. 
 *  The array can contain duplicates and negative numbers as well.
 *  For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *  You can modify the input array in-place
 * 
 * @author Bruno
 *
 */
public class Lab3Test {

	@Test
	public void givenArray_thenShouldReturnTheFirstPositiveInteger1() {
		int[] input = { 3, 4, -1, 1, 3 };
		assertEquals(2,Lab3Test.getLowestPositiveMissingInteger(input));

	}
	
	@Test
	public void givenArray_thenShouldReturnTheFirstPositiveInteger2() {
		int[] input = { 1, 2, 0 };
		assertEquals(3,Lab3Test.getLowestPositiveMissingInteger(input));
	}
	
	@Test
	public void givenArray_thenShouldReturnTheFirstPositiveInteger3() {
		int[] input = { 2, 1, 0 };
		assertEquals(3,Lab3Test.getLowestPositiveMissingInteger(input));
	}
	
	@Test
	public void givenArray_thenShouldReturnTheFirstPositiveInteger4() {
		int[] input = { -1, -2, 0 };
		assertEquals(1,Lab3Test.getLowestPositiveMissingInteger(input));
	}
	
	@Test
	public void givenArray_thenShouldReturnTheFirstPositiveInteger5() {
		int[] input = { 2, 1, 0, 2, 3 };
		assertEquals(4,Lab3Test.getLowestPositiveMissingInteger(input));
	}
	
	@Test
	public void givenArray_thenShouldReturnTheFirstPositiveInteger6() {
		int[] input = { 2, 0, 0, 2, 3 };
		assertEquals(1,Lab3Test.getLowestPositiveMissingInteger(input));
	}
	
	@Test
	public void givenArray_thenShouldReturnTheFirstPositiveInteger7() {
		int[] input = {  };
		assertEquals(1,Lab3Test.getLowestPositiveMissingInteger(input));
	}
	
	@Test
	public void givenArray_thenShouldReturnTheFirstPositiveInteger8() {
		assertEquals(1,Lab3Test.getLowestPositiveMissingInteger(null));
	}
	
	@Test
	public void givenArray_thenShouldReturnTheFirstPositiveInteger9() {
		int[] input = { 3, 0, 0, 3, 4 };
		assertEquals(2,Lab3Test.getLowestPositiveMissingInteger(input));
	}
	
	private static int getLowestPositiveMissingInteger(int[] input) {
		
		if(input != null) {
			
			Set<Integer> lowestIntegers = new HashSet<>();
			Set<Integer> numbersAlreadyProcessed = new HashSet<>();
			
			Integer lowestPositiveInteger = null;
			Integer biggestPositiveInteger = null;
			
			for (int i = 0; i < input.length; i++) {
				if(lowestIntegers.contains(input[i])) {
					lowestIntegers.remove(input[i]);
				}else if( input[i] > 0 ) {
					int firstLowerPositiveInteger = input[i] - 1;
					lowestIntegers.add(input[i]);
					
					if( firstLowerPositiveInteger > 0 && !numbersAlreadyProcessed.contains(firstLowerPositiveInteger)) {
						lowestIntegers.add(firstLowerPositiveInteger);
						if( lowestPositiveInteger == null || lowestPositiveInteger.intValue() > firstLowerPositiveInteger ) {
							lowestPositiveInteger = firstLowerPositiveInteger;
						}
					}
					
					if( biggestPositiveInteger == null || biggestPositiveInteger.intValue() < input[i] ) {
						biggestPositiveInteger = input[i];
					}
				}
				numbersAlreadyProcessed.add(input[i]);
			}
			
			if( lowestPositiveInteger != null && lowestIntegers.contains(lowestPositiveInteger)) {
				return lowestPositiveInteger;
			}else if (biggestPositiveInteger != null ) {
				return biggestPositiveInteger.intValue() + 1;
			}
			
		}
		
		return 1;
	}
}
