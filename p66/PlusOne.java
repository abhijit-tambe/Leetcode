/*66. Plus One
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.*/
package p66;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		if (digits[digits.length - 1] == 9) {
			if (digits.length == 1) {
				int ans[] = new int[2];
				ans[0] = 1;
				ans[1] = 0;
				return ans;
			} else {

				int l = digits.length - 1;
				while (l >= 0 && digits[l] == 9) {
					digits[l] = 0;
					l--;
				}
				if (l == -1) {
					int newa[] = new int[digits.length + 1];
					for (int i = 0; i < digits.length; i++) {
						newa[i + 1] = digits[i];
					}
					newa[0] = 1;
					return newa;
				} else {
					digits[l] = digits[l] + 1;
					return digits;
				}
			}
		} else {
			digits[digits.length - 1] = digits[digits.length - 1] + 1;
			return digits;
		}
	}

}
