package org.dojolabs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This problem was asked by Amazon.
 * 
 * Run-length encoding is a fast and simple method of encoding strings. 
 * The basic idea is to represent repeated successive characters as a single count and character. 
 * For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
 * 
 * Implement run-length encoding and decoding. 
 * You can assume the string to be encoded have no digits and consists solely of alphabetic characters. 
 * You can assume the string to be decoded is valid.
 * @author Bruno
 *
 */
public class Lab6Test {

	@Test
	void givenString_thenShouldEncodeIt() {
		String encodedString = encode("AAAABBBCCDAA");
		assertEquals("4A3B2C1D2A", encodedString);
	}
	
	@Test
	void givenEncodedString_thenShouldDecodeIt() {
		String decodedString = decode("4A3B2C1D2A");
		assertEquals("AAAABBBCCDAA", decodedString);
	}

	private String decode(String string) {
		String decoded = "";
		
		for (int i = 0; i < string.length(); i = i + 2) {
			int totalTimes = Character.getNumericValue(string.charAt(i));
			char nextChar = string.charAt(i+1);
			for(int j = 1; j <= totalTimes; j++) {
				decoded += Character.toString(nextChar);
			}
			
		}
		
		return decoded;
	}

	private String encode(String string) {
		char repeatedChar = string.charAt(0);
		int totalTimes = 1;
		String encoded = "";
		for (int i = 1; i < string.length(); i++) {
			char currentChar = string.charAt(i);
			if(currentChar == repeatedChar) {
				totalTimes ++;
			}else {
				encoded += totalTimes + Character.toString(repeatedChar);
				repeatedChar = currentChar;
				totalTimes = 1;
			}
		}
		
		encoded += totalTimes + Character.toString(repeatedChar);
		
		return encoded;
	}
}
