package org.dojolabs;

import java.util.Arrays;

public class DummyTest {

	public static void main(String[] args) {
		
		String word = "dog";
		
		int length = word.length();
		int indexSemMinus;
		int index;
		
		for( int level = 0; level < length; level ++) {
			index = word.charAt(level) - 'a';
			indexSemMinus = word.charAt(level);
			
			System.out.println("Sem minus: " + indexSemMinus);
			System.out.println("Com minus: " + index);
		}
	}
	
}
