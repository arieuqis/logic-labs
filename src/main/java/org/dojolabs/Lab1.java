package org.dojolabs;

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
}
