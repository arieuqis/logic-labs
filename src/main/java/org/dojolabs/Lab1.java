package org.dojolabs;

import java.util.HashSet;

public class Lab1 {

	public static boolean doesAnyTwoNumbersAddToK(int[] numbers, int k) {
		for (int i = 0; i < numbers.length; i++) {
			int currentNumber = numbers[i];
			for (int j = 0; j < numbers.length; j++) {
				int comparisonNumber = numbers[j];
				boolean numbersCanBeChecked = currentNumber != comparisonNumber;
				if( numbersCanBeChecked ) {
					boolean sumOfTheseNumbersAddToK = currentNumber + comparisonNumber == k;
					if( sumOfTheseNumbersAddToK ) {
						System.out.println(String.format("The sum of number %s and %s are equal to %s", currentNumber, comparisonNumber, k));
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean doesAnyTwoNumbersAddToKRecursively(int[] numbers, int k) {
		return checkWhetherNumbersAddToK(numbers, k, 0);
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
	
	public static boolean checkWhetherNumbersAddToK(int[] numbers, int k, int currentNumberIndex) {
		for (int j = 0; j < numbers.length; j++) {
			int comparisonNumber = numbers[j];
			int currentNumber = numbers[currentNumberIndex];
			boolean numbersCanBeChecked = currentNumber != comparisonNumber;
			boolean sumOfTheseNumbersAddToK = currentNumber + comparisonNumber == k;
			
			if( numbersCanBeChecked && sumOfTheseNumbersAddToK ) {
				if( sumOfTheseNumbersAddToK ) {
					System.out.println(String.format("The sum of number %s and %s are equal to %s", currentNumber, comparisonNumber, k));
					return true;
				}
			}
		}
		
		currentNumberIndex++;
		
		if( currentNumberIndex < numbers.length ) {
			return checkWhetherNumbersAddToK(numbers, k, currentNumberIndex);
		}else {
			return false;
		}
		
	}
}
