package org.dojolabs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * This problem was asked by Uber.
 * Given an array of integers, return a new array such that each element at index i 
 * 	of the new array is the product of all the numbers in the original array except the one at i.
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. 
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * Follow-up: what if you can't use division?
 * 
 * @author Bruno
 *
 */
public class Lab2Test {

	@Test
	public void givenArray_thenShouldReturnOtherOneWithProducts1() {
		int[] input = { 1, 2, 3, 4, 5 };
		int[] output = { 120, 60, 40, 30, 24 };
		
		int[] productsArray = Lab2Test.getProductsArray(input);
		for (int i = 0; i < productsArray.length; i++) {
			assertEquals(output[i], productsArray[i]);
		}
	}
	
	@Test
	public void givenArray_thenShouldReturnOtherOneWithProducts2() {
		int[] input = { 3, 2, 1 };
		int[] output = { 2, 3, 6 };
		
		int[] productsArray = Lab2Test.getProductsArray(input);
		for (int i = 0; i < productsArray.length; i++) {
			assertEquals(output[i], productsArray[i]);
		}
	}
	
	@Test
	public void givenArray_thenShouldReturnOtherOneWithProducts3() {
		int[] input = { 3, 0, 1 };
		int[] output = { 0, 3, 0 };
		
		int[] productsArray = Lab2Test.getProductsArray(input);
		for (int i = 0; i < productsArray.length; i++) {
			assertEquals(output[i], productsArray[i]);
		}
	}

	private static int[] getProductsArray(int[] input) {
		int[] productsArray = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			productsArray[i] = 1;
			for (int j = 0; j < input.length; j++) {
				if( i != j) {
					productsArray[i] *= input[j];
				}
			}
		}
		
		return productsArray;
	}
	
	
}
