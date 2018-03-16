package com.practice.trees;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestMain {

	public static void main(String[] args) {
		String[] values = new String[] {"a", "b", "c", "d"};
		List<String> valuesList = Arrays.asList(values);
		Set<String> valueSet = new HashSet<String>(valuesList);
		System.out.println(valuesList);
		System.out.println(valueSet);
		values[3] = "e";
		System.out.println(valuesList);
		System.out.println(valueSet);
	}

}
