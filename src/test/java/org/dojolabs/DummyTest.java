package org.dojolabs;

import java.util.Arrays;

public class DummyTest {

	public static void main(String[] args) {
		int[] input = changeArray(new int[] {0,1,2,-3,4,-5});
//		int[] positive = new int[input.length];
//		int p = 0;
		
//		for (int i = 0; i < input.length; i++) {
//			if( input[i] > 0 ) {
//				positive[p++] = input[i];
//			}
//		}
//		
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
			
		}
		
		
	}
	
	private static int [] changeArray(int[] array) {
		return Arrays.copyOf(array, 100);
	}
}
