package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.print.DocFlavor.STRING;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest {
	
	@Test
	public void testEmpty() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testInsert() {
		SetADT<String> abc = new JavaSet<>();
		abc.insert("a");
		abc.insert("b");
		abc.insert("c");
		assertEquals (abc.size(),3);
		
	}
	@Test 
	public void testInsertRepeated() {
		SetADT<String> A = new JavaSet<>();
		A.insert("a");
		A.insert("a");
		A.insert("a");
		assertEquals (A.size(), 1);
	}
	
	@Test
	public void testContains() {
		SetADT<Integer> Ints = new JavaSet<>();
		Ints.insert(3);
		Ints.insert(2);
		Ints.insert(4);
		Ints.remove(3);
		assertEquals(Ints.contains(2), true);
		assertEquals(Ints.contains(3), false);
		
	}
	
	@Test
	public void testRemove() {
		SetADT<Integer> Nums = new JavaSet<>();
		Nums.insert(1);
		Nums.insert(7);
		Nums.insert(9);
		Nums.remove(0);
		assertEquals(Nums.size(),3);
	}
	
	@Test
	public void testtoList() {
		SetADT<String> words = new JavaSet<>();
		words.insert("hey");
		words.insert("I");
		words.insert("just met you");
		ListADT<String> words1 = words.toList();
		assertEquals(words1.size(),3);	
	}
	
	@Test
	public void testtoJava() {
		SetADT<String> abc = new JavaSet<>();
		abc.insert("a");
		abc.insert("b");
		abc.insert("c");
		Set<String> abc1= abc.toJava();
		abc1.clear();
		assertEquals(abc1.isEmpty(),true);
	}
}
