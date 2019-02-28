package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaChallengesTest {
	
	@Test
	public void testUnion() {
		SetADT<Integer> set1 = new JavaSet<>();
		set1.insert(1);
		set1.insert(2);
		set1.insert(3);
		set1.insert(4);
		SetADT<Integer> set2 = new JavaSet<>();
		set2.insert(3);
		set2.insert(4);
		set2.insert(5);
		set2.insert(6);
		SetADT<Integer> set3 = Challenges.union(set1, set2);
		assertEquals(set3.size(),6);		
	}
	
	@Test
	public void testIntersection() {
		SetADT<Integer> set1 = new JavaSet<>();
		set1.insert(1);
		set1.insert(2);
		set1.insert(3);
		set1.insert(4);
		SetADT<Integer> set2 = new JavaSet<>();
		set2.insert(3);
		set2.insert(4);
		set2.insert(5);
		set2.insert(6);
		SetADT<Integer> set3 = Challenges.intersection(set1, set2);
		assertEquals(set3.size(),2);
	}
	
	@Test
	public void testWordCount() {
		ListADT<String> list = new JavaList<>();
		list.addBack("Betty");
		list.addBack("Botter");
		list.addBack("bought");
		list.addBack("some");
		list.addBack("butter");
		list.addBack("butter");
		list.addBack("butter");
		MapADT<String,Integer> map = Challenges.wordCount(list);
		assertEquals(map.size(),5);
     	assertEquals((int) map.get("butter"),3);		
	}

}
