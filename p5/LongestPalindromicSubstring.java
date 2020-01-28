/*
 * 5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"*/package p5;

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}
		int maxlen = 0;
		int start = 0;
		for (int i = 0; i < s.length();) {
			int left = i;
			int right = i;
			char c = s.charAt(left);
			while (right + 1 < s.length() && s.charAt(right + 1) == c) {
				right++;
			}
			i = right != left ? right + 1 : i + 1;
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}

			if (maxlen < right - left - 1) {
				System.out.println("l:" + left + ",r:" + right);
				maxlen = right - left - 1;
				start = left + 1;
			}

		}

		return s.substring(start, start + maxlen);

	}

}
