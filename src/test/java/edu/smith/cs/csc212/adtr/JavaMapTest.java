package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest {

	@Test
	public void testEmpty() {
		MapADT<String, Integer> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testPut() {
		MapADT<Integer, String> table = new JavaMap<>();
		table.put(1,"Harry");
		table.put(2, "Ron");
		table.put(1, "Hermione");
		table.put(3, null);
		assertEquals(table.get(1), "Hermione");
		assertEquals(table.size(), 3);
		assertEquals(table.get(3), null);
	}
	
	@Test
	public void testValueType() {
		MapADT<Integer, String> table = new JavaMap<>();
		table.put(1, "Gryffindor");
		table.put(2, "Ravenclaw");
		assertEquals(table.get(3), null);
		assertEquals(table.get(2), "Ravenclaw");
	}
	
	@Test
	public void testSize() {
		MapADT<Integer, String> table = new JavaMap<>();
		table.put(1, "Potter");
		table.put(2, "Weasley");
		table.put(3, "Granger");
		assertEquals(table.size(),3);
	}
	
	@Test
	public void testRemove() {
		MapADT<Integer, String> table = new JavaMap<>();
		table.put(1,"Dumbledore");
		table.put(2, "McGonagall");
		table.put(3, "Snape");
		assertEquals (table.remove(3),"Snape");
		assertEquals (table.size(),2);
	}
	@Test
	public void testgetKeys() {
		MapADT<Integer, String> table = new JavaMap<>();
		table.put(1,"Dumbledore");
		table.put(2, "McGonagall");
		table.put(3, "Snape");
		assertEquals (table.getKeys().size(), 3);
	}
	
	@Test
	public void testgetEmptyKeys() {
		MapADT<Integer, String> table = new JavaMap<>();
		assertEquals (table.getKeys().isEmpty(), true);
	}
	
	@Test
	public void testgetEntries() {
		MapADT<Integer, String> table = new JavaMap<>();
		table.put(1, "Potter");
		table.put(2, "Weasley");
		table.put(3, "Granger");
		assertEquals(table.getEntries().size(),3);
	}
	
	@Test
	public void testgetEmptyEntries() {
		MapADT<Integer, String> table = new JavaMap<>();
		assertEquals(table.getEntries().isEmpty(),true);
	}
	
	@Test
	public void testtoJava() {
		MapADT<Integer, String> table = new JavaMap<>();
		table.put(1,"Dumbledore");
		table.put(2, "McGonagall");
		table.put(3, "Snape");
		Map<Integer, String> table1 = table.toJava();
		assertEquals (table1.size(),3);
		table1.clear();
		assertEquals(table1.isEmpty(),true);
		
	}
	
	@Test
	public void testtoJavaEmpty() {
		MapADT<Integer, String> table = new JavaMap<>();
		assertEquals(table.toJava().isEmpty(),true);
	}
}
