package edu.smith.cs.csc212.adtr;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class Challenges {

	/**
	 * The union of two sets is the set of elements that either contains.
	 * Return a set of unique elements by combining two different sets
	 * @param left - a Set of elements
	 * @param right - another Set of elements
	 * @return - a Set of elements with values that either of the two contains
	 */
	public static SetADT<Integer> union(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();
		for (int i:left.toList()) {
			output.insert(i);
		}
		for (int j:right.toList()) {
			output.insert(j);
			
		}
		return output;
	}
	
	/**
	 *The intersection of two sets is the set of elements that both contain. 
	 * @param left - a Set of elements
	 * @param right - another Set of elements
	 * @return - a Set of elements with values common to both sets
	 */
	public static SetADT<Integer> intersection(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();
		for (int i:left.toList()) {
			for (int j:right.toList()) {
				if (i==j) {
					output.insert(i);
				}
				else {
					continue;
				}
			}
		}
		
		return output;
	}
	
	/**
	 *  Count the words in the input list and put them in the map.
	 * @param words - a list of words
	 * @return - a Map with the number of times each word appears in the list
	 */
	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		MapADT<String, Integer> output = new JavaMap<>();
		for (String i: words) {
			Integer countBefore = output.get(i);
			if (countBefore==null) {
				output.put(i,1);
			} else {
				output.put(i, countBefore + 1);;
			}
		}
		return output;
	}
}
