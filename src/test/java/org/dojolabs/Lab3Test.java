package org.dojolabs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

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
	
	private static int getLowestPositiveMissingInteger(int[] input) {
		
//		if(input != null) {
//			Set<Integer> numbersAlreadyCalculated = new HashSet<>();
//			Set<Integer> lowestIntegers = new HashSet<>();
//			
//			for (int i = 0; i < input.length; i++) {
//				if(lowestIntegers.contains(input[i])) {
//					lowestIntegers.remove(input[i]);
//				}else if( input[i] > 0 ) {
//					int firstLowerPositiveInteger = input[i] - 1;
//					
//					if( firstLowerPositiveInteger > 0 && !lowestIntegers.contains(firstLowerPositiveInteger) && !numbersAlreadyCalculated.contains(firstLowerPositiveInteger)) {
//						lowestIntegers.add(firstLowerPositiveInteger);
//					}
//				}
//				numbersAlreadyCalculated.add(input[i]);
//			}
//			
//			if( lowestIntegers.size() > 0 ) {
//				return new TreeSet<>(lowestIntegers).first();
//			}else if(numbersAlreadyCalculated.size() > 0){
//				return new TreeSet<>(numbersAlreadyCalculated).last() + 1;
//			}
//		}
		
		if(input != null && input.length > 0) {
			int[] positiveNumbers = new int[input.length];
			int[] lowestPositiveNumbers = new int[input.length];
			boolean[] numbersAlreadyCalculated = new boolean[input.length];
			int positiveIndex = 0;
			int lowestPositiveIndex = 0;
			boolean hasPositive = false;
			
			for (int i = 0; i < input.length; i++) {
				numbersAlreadyCalculated = realocateArray(numbersAlreadyCalculated, input[i]);
				
				if(input[i] > 0 ) {
					hasPositive = true;
					positiveNumbers[positiveIndex++] = input[i];
					int firstLowerPositiveInteger = input[i] - 1;
					if( firstLowerPositiveInteger > 0 ){
						lowestPositiveNumbers[lowestPositiveIndex++] = firstLowerPositiveInteger;
					}
					numbersAlreadyCalculated[input[i]] = true;
				}
			}
			
			if( hasPositive ) {
				Arrays.sort(lowestPositiveNumbers);
				for (int i = 0; i < lowestPositiveNumbers.length; i++) {
					if(lowestPositiveNumbers[i] > 0 && !numbersAlreadyCalculated[lowestPositiveNumbers[i]]) {
						return lowestPositiveNumbers[i];
					}
				}
				
				Arrays.sort(positiveNumbers);
				return positiveNumbers[positiveNumbers.length-1] + 1;
			}
			
		}
		
		return 1;
	}
	
	private static boolean [] realocateArray(boolean[] array, int number) {
		if( array.length <= number ) {
			return Arrays.copyOf(array, number);
		}else {
			return array;
		}
		
	}
	
}
