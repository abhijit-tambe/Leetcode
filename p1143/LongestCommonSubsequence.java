/*1143. Longest Common Subsequence
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.
 * */
package p1143;

public class LongestCommonSubsequence {
//// memoization
//	public int longestCommonSubsequence(String text1, String text2) {
//		int m = text1.length();
//		int n = text2.length();
//		int memo[][] = new int[m + 1][n + 1];
//		for (int i = 0; i <= m; i++) {
//			for (int j = 0; j <= n; j++) {
//				memo[i][j] = -1;
//			}
//		}
//
//		return logsub(text1, text2, m, n, memo);
//
//	}
//
//	int logsub(String text1, String text2, int m, int n, int[][] memo) {
//		if (memo[m][n] != -1) {
//			return memo[m][n];
//		}
//		if (m == 0 || n == 0) {
//			memo[m][n] = 0;
//		} else if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
//			memo[m][n] = 1 + logsub(text1, text2, m - 1, n - 1, memo);
//		} else {
//			memo[m][n] = Math.max(logsub(text1, text2, m - 1, n, memo), logsub(text1, text2, m, n - 1, memo));
//
//		}
//		return memo[m][n];
//	}
/// end of memonization

// Tabulation
	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		int memo[][] = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					memo[i][j] = memo[i - 1][j - 1] + 1;
				} else {
					memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
				}

			}
			System.out.println();
		}

		return memo[m][n];

	}

}
