package org.dojolabs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
		int[] input = { -1, -2, 0 };
		assertEquals(1,Lab3Test.getLowestPositiveMissingInteger(input));
	}
	
	private static int getLowestPositiveMissingInteger(int[] input) {
		Set<Integer> numbersAlreadyCalculated = new HashSet<>();
		Set<Integer> lowestIntegers = new HashSet<>(); 
		
		for (int i = 0; i < input.length; i++) {
			if( input[i] > 0 ) {
				int firstLowerPositiveInteger = input[i] - 1;
				
				if( firstLowerPositiveInteger > 0 && !lowestIntegers.contains(firstLowerPositiveInteger) && !numbersAlreadyCalculated.contains(firstLowerPositiveInteger)) {
					lowestIntegers.add(firstLowerPositiveInteger);
				}
				numbersAlreadyCalculated.add(input[i]);
			}
		}
		
		if( lowestIntegers.size() > 0 ) {
			return new TreeSet<>(lowestIntegers).first();
		}else if(numbersAlreadyCalculated.size() > 0){
			return new TreeSet<>(numbersAlreadyCalculated).last() + 1;
		}
		
		return 1;
	}
	
	
}
