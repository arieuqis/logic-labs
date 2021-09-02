package org.dojolabs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

/**
 * This problem was asked by Google.
 * 
 * Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
 * 
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 * 
 * In this example, assume nodes with the same value are the exact same node objects.
 * 
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 * @author Bruno
 *
 */
public class Lab5Test {

	@Test
	public void givenTwoLinkedList_shouldReturnTheIntersectingNodeIfThereIsOne1() {
		LinkedList<Integer> a = new LinkedList<>();
		a.add(3);
		a.add(7);
		a.add(8);
		a.add(10);
		
		LinkedList<Integer> b = new LinkedList<>();
		b.add(99);
		b.add(1);
		b.add(8);
		b.add(10);
		
		assertEquals(8, getIntersectingNode(a, b));
		
	}
	
	@Test
	public void givenTwoLinkedList_shouldReturnTheIntersectingNodeIfThereIsOne2() {
		LinkedList<Integer> a = new LinkedList<>();
		a.add(3);
		a.add(7);
		a.add(9);
		a.add(11);
		a.add(20);
		a.add(50);
		a.add(10);
		
		LinkedList<Integer> b = new LinkedList<>();
		b.add(99);
		b.add(100);
		b.add(2);
		b.add(6);
		b.add(99);
		b.add(1);
		b.add(8);
		b.add(10);
		
		assertEquals(10, getIntersectingNode(a, b));
		
	}
	
	@Test
	public void givenTwoLinkedList_shouldReturnNullIfThereIsNoIntersectingNode() {
		LinkedList<Integer> a = new LinkedList<>();
		a.add(3);
		a.add(7);
		a.add(5);
		a.add(11);
		
		LinkedList<Integer> b = new LinkedList<>();
		b.add(99);
		b.add(1);
		b.add(8);
		b.add(10);
		
		assertEquals(null, getIntersectingNode(a, b));
		
	}

	private Integer getIntersectingNode(LinkedList<Integer> a, LinkedList<Integer> b) {
		HashSet<Integer> aSet = new HashSet<Integer>();
		
		Iterator<Integer> iteratorA = a.iterator();
		
		while(iteratorA.hasNext()) {
			aSet.add(iteratorA.next());
		}
		
		Iterator<Integer> iteratorB = b.iterator();
		
		while(iteratorB.hasNext()) {
			Integer node = iteratorB.next();
			if( aSet.contains(node)) {
				return node;
			}
		}
		
		return null;
	}
	
	
}
