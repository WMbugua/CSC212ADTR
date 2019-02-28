package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.errors.BadIndexError;
import edu.smith.cs.csc212.adtr.errors.EmptyListError;
import edu.smith.cs.csc212.adtr.real.JavaList;


public class JavaListTest {
	
	/**
	 * Make a new empty list.
	 * @return an empty list to be tested.
	 */
	private <T> ListADT<T> makeEmptyList() {
		return new JavaList<>();
	}
	
	/**
	 * Helper method to make a full list.
	 * @return [a, b, c, d] - a small, predictable list for many tests.
	 */
	private ListADT<String> makeFullList() {
		ListADT<String> data = makeEmptyList();
		data.addBack("a");
		data.addBack("b");
		data.addBack("c");
		data.addBack("d");
		return data;
	}
		
	@Test
	public void testEmpty() {
		ListADT<String> data = makeEmptyList();
		assertEquals(0, data.size());
		assertEquals(true, data.isEmpty());
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeBack();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveIndexCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeIndex(3);
	}

	@Test
	public void testAddToFront() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addFront("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(0));
		Assert.assertEquals("1", data.getIndex(1));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(2));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-2");
		Assert.assertEquals("-1", data.getIndex(1));
		Assert.assertEquals("-2", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(2));
		Assert.assertEquals("1", data.getIndex(3));
		Assert.assertEquals(false, data.isEmpty());
	}
	
	@Test
	public void testAddToBack() {
		ListADT<String> data = makeEmptyList();
		data.addBack("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		data.addBack("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(0));
		data.addBack("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(2));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(0));
		data.addBack("-2");
		Assert.assertEquals("-2", data.getIndex(3));
		Assert.assertEquals("-1", data.getIndex(2));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(0));
	}
	
	@Test
	public void testremoveIndex() {
		ListADT<String> data = makeFullList();
		assertEquals(data.removeIndex(2),"c");
		assertEquals(data.removeIndex(2),"d");
	}
	
	@Test(expected=BadIndexError.class)
	public void testremoveIndexLow() {
		ListADT<String> data = makeFullList();
		data.removeIndex(-5);
	}
	
	@Test(expected=BadIndexError.class)
	public void testremoveIndexHigh() {
		ListADT<String> data = makeFullList();
		data.removeIndex(data.size());
	}
	
	@Test
	public void testremoveBack() {
		ListADT<String> data = makeFullList();
		assertEquals(data.removeBack(),"d");
		assertEquals(data.size(),3);
		assertEquals(data.removeBack(),"c");
		assertEquals(data.size(),2);
	}
	
	@Test
	public void testremoveFront() {
		ListADT<String> data = makeFullList();
		assertEquals(data.removeFront(),"a");
		assertEquals(data.size(),3);
		assertEquals(data.removeFront(),"b");
		assertEquals(data.size(),2);
	}
	
	@Test
	public void testaddIndex() {
		ListADT<String> data = makeEmptyList();
		data.addIndex(0, "a");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("a", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addIndex(0, "b");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("b", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addIndex(1,"c");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("c", data.getIndex(1));
		Assert.assertEquals(false, data.isEmpty());
		data.addIndex(2, "d");
		Assert.assertEquals(4, data.size());
		Assert.assertEquals("d", data.getIndex(2));
		Assert.assertEquals(false, data.isEmpty());
		assertEquals(data.getFront(),"b");
		assertEquals(data.getBack(),"a");
	}
	
	@Test
	public void testGetFront() {
		ListADT<String> data = makeFullList();
		assertEquals("a", data.getFront());
	}
	
	@Test
	public void testGetBack() {
		ListADT<String> data = makeFullList();
		assertEquals("d", data.getBack());
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.getFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.getBack();
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexLow() {
		ListADT<String> data = makeFullList();
		data.getIndex(-2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHigh() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size());
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size()*2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()*2, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHigh() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()+1, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexLow() {
		ListADT<String> data = makeFullList();
		data.addIndex(-1, "the");
	}
	
	@Test
	public void testsetIndex() {
		ListADT<String> data = makeFullList();
		data.setIndex(0, "e");
		Assert.assertEquals(4, data.size());
		Assert.assertEquals("e", data.getIndex(0));
		data.setIndex(1, "f");
		Assert.assertEquals(4, data.size());
		Assert.assertEquals("f", data.getIndex(1));
		data.setIndex(2, "g");
		Assert.assertEquals(4, data.size());
		Assert.assertEquals("g", data.getIndex(2));
		data.setIndex(3, "h");
		Assert.assertEquals(4, data.size());
		Assert.assertEquals("h", data.getIndex(3));
		assertEquals(data.getFront(),"e");
		assertEquals(data.getBack(),"h");
	}
	
	@Test(expected=EmptyListError.class)
	public void testsetIndexCrash() {
		ListADT<String> data = makeEmptyList();
		data.setIndex(3, "c");
	}
	
	@Test(expected=BadIndexError.class)
	public void testsetIndexHigh() {
		ListADT<String> data = makeFullList();
		data.setIndex(data.size()*2, "h");
	}
	
	@Test(expected=BadIndexError.class)
	public void testsetIndexLow() {
		ListADT<String> data = makeFullList();
		data.setIndex(-5, "-e");
	}
	
	@Test
	public void testToJava() {
		assertEquals(makeFullList().toJava(), Arrays.asList("a", "b", "c", "d"));
	}
}
