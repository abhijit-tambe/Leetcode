/*9. Palindrome Number
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?
 * 
 * */package p9;

public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		int x1 = x;
		int y = 0;
		while (x > 0) {
			y *= 10;
			y += x % 10;
			x /= 10;
		}
		return x1 == y ? true : false;
	}

}
