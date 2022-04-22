package org.howard.edu.lsp.assignment6.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.ArrayList;
import org.howard.edu.lsp.assignment6.integerset.IntegerSet;
import org.howard.edu.lsp.assignment6.integerset.ListEmptyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;




public class IntegerSetTest {
	@Test
	@DisplayName("IntegerSet.clear test cases")
	public void testClear() {
		ArrayList<Integer> list1= new ArrayList<>();
		IntegerSet set1 = new IntegerSet(list1);
		
		ArrayList<Integer> list2= new ArrayList<>();
		IntegerSet set2 = new IntegerSet(list2);
		
		set1.addItem(1);
		set1.addItem(2);
		set1.addItem(3);
		set1.addItem(4);
		set1.addItem(5);
		set1.addItem(6);
		set1.addItem(7);
		
		set2.addItem(1);
		set2.addItem(2);
		set2.addItem(3);
		set2.addItem(4);
		set2.addItem(5);
		set2.addItem(6);
		set2.addItem(7);

		//testing that clear works and set should have a length of 0 when done
		set1.clear();
		set2.clear();
		assertEquals(set1.length(),0);
		assertEquals(set2.length(), 0);
	}

	@Test
	@DisplayName("IntegerSet.length test cases")
	public void testLength() {
		ArrayList<Integer> list1= new ArrayList<>();
		IntegerSet set1 = new IntegerSet(list1);
		
		set1.addItem(1);
		set1.addItem(2);
		set1.addItem(3);
		set1.addItem(4);
		set1.addItem(5);
		set1.addItem(6);
		set1.addItem(7);

		assertEquals(7, set1.length(), "Should return 7");
		set1.clear();
		assertEquals(0, set1.length(), "Should return 0");
		set1.addItem(1);
		set1.addItem(2);
		set1.addItem(3);
		assertEquals(3, set1.length(), "Should return 3");
	}

	@Test
	@DisplayName("IntegerSet.equals test cases")
	public void testEqualsIntegerSet() {
		ArrayList<Integer> list1= new ArrayList<>();
		IntegerSet set1 = new IntegerSet(list1);
		
		ArrayList<Integer> list2= new ArrayList<>();
		IntegerSet set2 = new IntegerSet(list2);
		
		set1.addItem(1);
		set1.addItem(2);
		set1.addItem(3);
		set1.addItem(4);
		set1.addItem(5);
		set1.addItem(6);
		set1.addItem(7);
		
		set2.addItem(1);
		set2.addItem(2);
		set2.addItem(3);
		set2.addItem(4);
		set2.addItem(5);
		set2.addItem(6);
		set2.addItem(7);
		//testing when sets are full of values are they equal
		assertEquals(true ,set1.equals(set2));
		//testing when sets are different will it return false
		set2.addItem(9);
		assertEquals(false, set1.equals(set2));
		//testing when sets are empty are they equal
		set1.clear();
		set2.clear();
		assertEquals(true, set1.equals(set2));
		
	}

	@Test
	@DisplayName("IntegerSet.largestelements test cases")
	public void testLargestelement() throws ListEmptyException {
		ArrayList<Integer> list1= new ArrayList<>();
		IntegerSet set1 = new IntegerSet(list1);
		
		set1.addItem(1);
		set1.addItem(2);
		set1.addItem(3);
		set1.addItem(4);
		
		//testing to see largest element is updated
		assertEquals(set1.largestelement(), 4);
		set1.removeItem(4);
		assertEquals(set1.largestelement(), 3);
		set1.removeItem(3);
		assertEquals(set1.largestelement(), 2);
		set1.removeItem(2);
		assertEquals(set1.largestelement(), 1);		
	}
	
	@Test
	@DisplayName("IntegerSet.largestelements exception handling test cases")
	public void testLargestelement_THROWS_EXCEPTION() throws ListEmptyException {
		ArrayList<Integer> list1= new ArrayList<>();
		IntegerSet set1 = new IntegerSet(list1);
		
		set1.addItem(1);
		set1.addItem(2);
		set1.addItem(3);
		set1.addItem(4);
		set1.clear();
		
		ListEmptyException thrown = assertThrows(ListEmptyException.class, () -> set1.largestelement());
		//testing exception handling
		assertTrue(thrown.getMessage().contains("This list cannot have a size of zero"));
	}


	@Test
	@DisplayName("Method returning smallest element or exception when set is empty")
	public void testSmallestelement() throws ListEmptyException, ListEmptyException {
		ArrayList<Integer> list1= new ArrayList<>();
		IntegerSet set1 = new IntegerSet(list1);
		
		set1.addItem(3);
		set1.addItem(12);
		set1.addItem(6);
		set1.addItem(10);
		
		//testing that smallest element is updated in set
		assertEquals(3, set1.smallestelement());
		set1.removeItem(3);
		
		assertEquals(6, set1.smallestelement());
		set1.removeItem(6);
		
		assertEquals(10, set1.smallestelement());
		set1.removeItem(10);
		
		assertEquals(12, set1.smallestelement());		
		
	}
	
	@Test
	@DisplayName("IntegerSet.smallestelement exception handling test cases")
	public void testSmallestelement_THROWS_EXCEPTION() throws ListEmptyException, ListEmptyException {
		ArrayList<Integer> list1= new ArrayList<>();
		IntegerSet set1 = new IntegerSet(list1);
		
		set1.addItem(3);
		set1.addItem(12);
		set1.addItem(6);
		set1.addItem(10);
		
		set1.clear();
		
		ListEmptyException thrown = assertThrows(ListEmptyException.class, () -> set1.smallestelement());
		//testing exception handling
		assertTrue(thrown.getMessage().contains("This list cannot have a size of zero"));
		
	}
	

	@Test
	@DisplayName("IntegerSet.contains test cases")
	public void testContains() {
		ArrayList<Integer> list1= new ArrayList<>();
		IntegerSet set1 = new IntegerSet(list1);
		
		set1.addItem(10);
		set1.addItem(15);
		//Testing that true is returned when element should be found in set
		assertEquals(true, set1.contains(10));
		//Testing that true is not returned when element is not found in set and instead false is returned
		assertNotEquals(true, set1.contains(25));
		assertEquals(false, set1.contains(25));
		
	}

	@Test
	@DisplayName("IntegerSet.addItem test cases")
	public void testAddItem() {
		ArrayList<Integer> list1= new ArrayList<>();
		IntegerSet set1 = new IntegerSet(list1);
		
		set1.addItem(1);
		set1.addItem(2);
		set1.addItem(3);
		//Testing that set not is empty when addItem() method is called representing NotNULL
		assertNotNull(set1);
		//Testing that set receives 3 elements when addItem() method is called 3 times
		assertEquals(3, set1.length());
	}

	@Test
	@DisplayName("IntegerSet.removeItem test cases")
	public void testRemoveItem() {
		ArrayList<Integer> list1= new ArrayList<>();
		IntegerSet set1 = new IntegerSet(list1);
		
		set1.addItem(1);
		set1.addItem(2);
		set1.addItem(3);
		
		set1.removeItem(1);
		set1.removeItem(2);
		//Testing that set has one element after two elements are removed
		assertEquals("3 ", set1.toString());
		
		set1.removeItem(3);
		//Testing that set has no elements when all elements are removed form set
		assertEquals(0, set1.length());

	}

	@Test
	@DisplayName("IntegerSet.union test cases")
	public void testUnion() {
		ArrayList<Integer> list1= new ArrayList<>();
		IntegerSet set1 = new IntegerSet(list1);
		
		ArrayList<Integer> list2= new ArrayList<>();
		IntegerSet set2 = new IntegerSet(list2);
		
		set1.addItem(1);
		set1.addItem(2);
		set2.addItem(3);
		set2.addItem(4);
		
		//tests that union works utilizing to String method
		IntegerSet setu= set1.union(set2);
		assertEquals("1 2 3 4 ", setu.toString());
		assertEquals(4, setu.length());
		//tests that union does not give back results in wrong order
		assertNotEquals("4 3 2 1", setu.toString());
		
	}

	@Test
	@DisplayName("IntegerSet.intersection test cases")
	public void testIntersection() {
		ArrayList<Integer> list1= new ArrayList<>();
		IntegerSet set1 = new IntegerSet(list1);
		
		ArrayList<Integer> list2= new ArrayList<>();
		IntegerSet set2 = new IntegerSet(list2);
		
		set1.addItem(1);
		set1.addItem(2);
		set1.addItem(3);
		
		set2.addItem(3);
		set2.addItem(4);
		set2.addItem(1);
		
				//tests that intersection works utilizing to String method
				IntegerSet setu= set1.intersection(set2);
				assertEquals("1 3 ", setu.toString());
				assertEquals(2, setu.length());
				//tests that intersection does not give back results in wrong order
				assertNotEquals("3 1", setu.toString());
		
	}

	@Test
	@DisplayName("IntegerSet.difference test cases")
	public void testDifference() {
		ArrayList<Integer> list1= new ArrayList<>();
		IntegerSet set1 = new IntegerSet(list1);
		
		ArrayList<Integer> list2= new ArrayList<>();
		IntegerSet set2 = new IntegerSet(list2);
		
		set1.addItem(1);
		set1.addItem(2);
		set1.addItem(10);
		set1.addItem(20);
		
		set2.addItem(1);
		set2.addItem(2);
		set2.addItem(3);
		set2.addItem(4);
		
		IntegerSet setdiff = set1.difference(set2);
		
		assertNotNull(setdiff);
		assertEquals("10 20 ", setdiff.toString());


	}

	@Test
	@DisplayName("IntegerSet.getlist test cases")
	public void testGetlist() {
		ArrayList<Integer> list1= new ArrayList<>();
		IntegerSet set1 = new IntegerSet(list1);
		
		set1.addItem(10);
		set1.addItem(20);
		
		//testing getlist() method that is returns the list of elements and can pass it into another list
		ArrayList<Integer> set2 = set1.getlist();
		
		//testing that set2 is not empty and equals [10,20] 
		assertNotNull(set2);
		assertEquals("[10, 20]", set2.toString());
		
	}
	

	

	@Test
	@DisplayName("IntegerSet.toString test cases")
	public void testToString() {
		ArrayList<Integer> list1= new ArrayList<>();
		IntegerSet set1 = new IntegerSet(list1);
		
		set1.addItem(5);
		set1.addItem(4);
		set1.addItem(3);
		set1.addItem(2);
		set1.addItem(1);
		
		//Tests that to string gives back set elements in order without commas or brackets
		assertEquals("5 4 3 2 1 ", set1.toString());
		assertNotEquals("[5,4,3,2,1]", set1.toString());
	}

	@Test
	@DisplayName("IntegerSet.isEmpty test cases")
	public void testisEmpty() {
		ArrayList<Integer> list1= new ArrayList<>();
		IntegerSet set1 = new IntegerSet(list1);
		
		//Test that false is returned when set has at least one or more elements in it
		set1.addItem(1);
		assertEquals(false, set1.isEmpty());
		set1.addItem(2);
		assertEquals(false, set1.isEmpty());
		//Tests that true is returned when set has last element removed
		set1.removeItem(1);
		set1.removeItem(2);
		assertEquals(true, set1.isEmpty());
		
	}
}
