package org.dojolabs;

import java.util.HashSet;

public class Lab1 {

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
