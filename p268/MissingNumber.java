/*268. Missing Number
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * */package p268;

import java.util.HashSet;

public class MissingNumber {

	public int missingNumber(int[] nums) {
		HashSet<Integer> hs = new HashSet<>();
		int max = Integer.MIN_VALUE;
		for (int i : nums) {
			if (i > max) {
				max = i;
			}
			hs.add(i);
		}
		for (int i = 0; i <= max; i++) {
			if (!hs.contains(i)) {
				return i;
			}
		}
		return max + 1;
	}
}
