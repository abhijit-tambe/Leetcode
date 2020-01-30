/*409. Longest Palindrome

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 * */package p409;

public class LongestPalindrome {

	public int longestPalindrome(String s) {
		int ans = 0;
		int[] count = new int[58];
		char[] arr = s.toCharArray();
		for (char c : arr) {
			count[c - 'A']++;
		}

		for (int i : count) {

			ans += i / 2 * 2;
		}

		if (ans < s.length())
			ans++;
		return ans;
	}

}
