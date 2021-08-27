package org.dojolabs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * This problem was asked by Twitter.
 * Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, 
 * return all strings in the set that have s as a prefix.
 * 
 * For example, given the query string 'de' and the set of strings [dog, deer, deal], return [deer, deal].
 * 
 * Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
 * 
 * @author Bruno
 *
 */
public class Lab4Test {

	@Test
	public void givenString_shouldReturnPossibleStringsWithThisOneAsPrefix1() {
		Set<String> results = getPossibleStrings("de", new String[] {"dog", "deer", "deal"});
		assertNotNull(results);
		
		List<String> esperados = Arrays.asList("deer", "deal");
		assertEquals(esperados.size(), results.size());
		for (String string : esperados) {
			assertTrue(results.contains(string));
		}
	}
	

	@Test
	public void givenString_shouldReturnPossibleStringsWithThisOneAsPrefix2() {
		Set<String> results = getPossibleStrings("d", new String[] {"dog", "deer", "deal"});
		assertNotNull(results);
		
		List<String> esperados = Arrays.asList("dog","deer", "deal");
		for (String string : esperados) {
			assertTrue(results.contains(string));
		}
	}
	
	@Test
	public void givenString_shouldReturnPossibleStringsWithThisOneAsPrefix3() {
		Set<String> results = getPossibleStrings("di", new String[] {"dog", "deer", "deal"});
		assertNotNull(results);
		
		assertEquals(0, results.size());
	}
	
	private Set<String> getPossibleStrings(String string, String[] strings) {
		HashSet<String> results = new HashSet<>();
		HashMap<String, String> mapaCombinacoes = new HashMap<>();
		
		for(int i = 0; i < strings.length; i++) {
			int tamanho = strings[i].length();
			while(tamanho >= 0) {
//				mapaCombinacoes
			}
		}
		
		
		
		
		for(int i = 0; i < strings.length; i++) {
			if(strings[i].startsWith(string)) {
				results.add(strings[i]);
			}
		}
		return results;
	}
	
}
