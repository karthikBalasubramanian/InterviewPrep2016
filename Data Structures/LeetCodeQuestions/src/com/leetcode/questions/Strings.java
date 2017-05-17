package com.leetcode.questions;

import java.util.HashMap;

public class Strings {

	public int lengthOfLongestSubstring(String s) {
		int slowPointer = 0;
		int fastPointer = 0;
		HashMap<Character, Integer> charmap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (charmap.containsKey(c)) {
				slowPointer = Math.max(slowPointer, charmap.get(c) + 1);
			}
			charmap.put(c, i);
			fastPointer = Math.max(fastPointer, i - slowPointer + 1);
		}

		return fastPointer;
	}

	public String longestPalindrome(String s) {

		int length = s.length();
		boolean[][] palindromeMatrix = new boolean[length][length];
		int palindromeStartsAt = 0;
		int max_length = 1;

		// fill the diagonals of Palindrome matrix

		for (int i = 0; i < length; i++) {
			palindromeMatrix[i][i] = true;
		}

		for (int i = 0; i < length - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				palindromeMatrix[i][i + 1] = true;
				palindromeStartsAt = i;
				max_length = 2;
			}
		}

		for (int currentPosition = 3; currentPosition <= length; currentPosition++) {

			for (int i = 0; i < length - currentPosition + 1; i++) {
				int j = currentPosition + i - 1;
				if (s.charAt(i) == s.charAt(j) && palindromeMatrix[i + 1][j - 1]) {
					palindromeMatrix[i][j] = true;
					palindromeStartsAt = i;
					max_length = currentPosition;
				}
			}

		}

		return s.substring(palindromeStartsAt, max_length + palindromeStartsAt);
	}

	public int longestPalindromeSubseq(String s) {

		int[][] longestPalindromeReturningArray = new int[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			longestPalindromeReturningArray[i][i] = 1;
		}

		for (int i = 2; i <= s.length(); i++) {
			for (int j = 0; j < s.length() - i + 1; j++) {
				int k = i + j - 1;

				if (i == 2 && s.charAt(i) == s.charAt(j)) {
					longestPalindromeReturningArray[i][j] = 2;
				}
				if (s.charAt(j) == s.charAt(k)) {
					longestPalindromeReturningArray[j][k] = longestPalindromeReturningArray[j + 1][k - 1] + 2;
				} else {
					longestPalindromeReturningArray[j][k] = Math.max(longestPalindromeReturningArray[j][k - 1],
							longestPalindromeReturningArray[j + 1][k]);
				}
			}
		}

		return longestPalindromeReturningArray[0][s.length() - 1];
	}

	public String addBinary(String a, String b) {
		
		int number0 = Integer.parseInt(a, 2);
        int number1 = Integer.parseInt(b, 2);

        int sum = number0 + number1;
        System.out.println(sum);
        String s3 = Integer.toBinaryString(sum);

		return s3;

	}

	public static void main(String[] args) {
		String s = "pwwkew";
		Strings obj = new Strings();
		System.out.println(obj.lengthOfLongestSubstring(s));
		// System.out.println(obj.longestPalindrome(
		// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		// // long[][] ary = new long[Integer.MAX_VALUE][Integer.MAX_VALUE];
		System.out.println(obj.longestPalindromeSubseq("cbbd"));
		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		System.out.println(obj.addBinary(a, b));
	}
}
