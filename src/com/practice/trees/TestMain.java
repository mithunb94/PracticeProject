package com.practice.trees;

public class TestMain {

	public static void main(String[] args) {
		System.out.println(isPalindrome("abcba"));
		System.out.println(isPalindrome("abx"));
		
	}

	public static boolean isPalindrome(String str) {
		if (str == null) {
			return false;
		}
		if (str.length() == 0 || str.length() == 1) {
			return true;
		}
		if (str.charAt(0) == str.charAt(str.length()-1)) {
			return isPalindrome(str.substring(1, str.length()-1));
		}
		return false;
	}
}
