package org.dojolabs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
	public void givenString_shouldReturnPossibleStringsWithThisOneAsPrefixBrutely1() {
		Set<String> results = getPossibleStringsBrutely("de", new String[] {"dog", "deer", "deal"});
		assertNotNull(results);
		
		List<String> esperados = Arrays.asList("deer", "deal");
		assertEquals(esperados.size(), results.size());
		for (String string : esperados) {
			assertTrue(results.contains(string));
		}
	}
	

	@Test
	public void givenString_shouldReturnPossibleStringsWithThisOneAsPrefixBrutely2() {
		Set<String> results = getPossibleStringsBrutely("d", new String[] {"dog", "deer", "deal"});
		assertNotNull(results);
		
		List<String> esperados = Arrays.asList("dog","deer", "deal");
		for (String string : esperados) {
			assertTrue(results.contains(string));
		}
	}
	
	@Test
	public void givenString_shouldReturnPossibleStringsWithThisOneAsPrefixBrutely3() {
		Set<String> results = getPossibleStringsBrutely("di", new String[] {"dog", "deer", "deal"});
		assertNotNull(results);
		
		assertEquals(0, results.size());
	}
	
	@Test
	public void givenString_shouldReturnPossibleStringsWithThisOneAsPrefixTrie1() {
		Set<String> results = getPossibleStringsTrie("de", new String[] {"dog", "deer", "deal"});
		assertNotNull(results);
		
		List<String> esperados = Arrays.asList("deer", "deal");
		assertEquals(esperados.size(), results.size());
		for (String string : esperados) {
			assertTrue(results.contains(string));
		}
	}
	

	@Test
	public void givenString_shouldReturnPossibleStringsWithThisOneAsPrefixTrie2() {
		Set<String> results = getPossibleStringsTrie("d", new String[] {"dog", "deer", "deal"});
		assertNotNull(results);
		
		List<String> esperados = Arrays.asList("dog","deer", "deal");
		for (String string : esperados) {
			assertTrue(results.contains(string));
		}
	}
	
	@Test
	public void givenString_shouldReturnPossibleStringsWithThisOneAsPrefixTrie3() {
		Set<String> results = getPossibleStringsTrie("di", new String[] {"dog", "deer", "deal"});
		assertNotNull(results);
		
		assertEquals(0, results.size());
	}
	
	private Set<String> getPossibleStringsBrutely(String string, String[] strings) {
		HashMap<String, HashSet<String>> mapaCombinacoes = new HashMap<>();
		
		for(int i = 0; i < strings.length; i++) {
			String prefix = strings[i];
			while(prefix.length() > 0 ) {
				if( !mapaCombinacoes.containsKey(prefix)) {
					mapaCombinacoes.put(prefix, new HashSet<>());
				}
				
				mapaCombinacoes.get(prefix).add(strings[i]);
				prefix = prefix.substring(0, prefix.length() - 1 );
			}
		}
		
		return mapaCombinacoes.getOrDefault(string, new HashSet<>());
	}
	
	private Set<String> getPossibleStringsTrie(String prefix, String[] strings) {
		TrieNode root = new TrieNode();
		for (int i = 0; i < strings.length; i++) {
			root.insert(strings[i]);
			
		}
		
		return root.startsWith(prefix);
	}
	
	class TrieNode {
		Map<String, TrieNode> children;
		
		boolean isEndOfWord;
		String character;
		
		public TrieNode() {
			isEndOfWord = false;
			children = new HashMap<>();
		}
		
		public TrieNode(String character) {
			this();
			this.character = character;
		}
		
		
		
		void insert(String word) {
			TrieNode node = this;
			int length = word.length();
			for (int i = 0; i < length; i++) {
				String ch = String.valueOf(word.charAt(i));
				if( !node.children.containsKey(ch)) {
					node.children.put(ch, new TrieNode(ch));
				}
				node = node.children.get(ch);
			}
			node.isEndOfWord = true;
		}
		
		Set<String> startsWith(String prefix) {
			TrieNode node = this;
			
			int length = prefix.length();
			for (int i = 0; i < length; i++) {
				String ch = String.valueOf(prefix.charAt(i));
				if( node.children.containsKey(ch)) {
					node = node.children.get(ch);
				}else {
					return new HashSet<>();
				}
			}
			
			Set<String> result = new HashSet<>();
			getAllWords(prefix, node, result);
			
			return result;
		}

		@Override
		public String toString() {
			return "TrieNode [isEndOfWord=" + isEndOfWord + ", character=" + character + "]";
		}
		
	}
	
	static void getAllWords(String prefix, TrieNode node, Set<String> result){
		for(Entry<String, TrieNode> item : node.children.entrySet()) {
			String completeWord = prefix + item.getKey();
			if( item.getValue().isEndOfWord ) {
				result.add(completeWord);
			}else {
				getAllWords(completeWord, item.getValue(), result);
			}
			
		}
	}
}

