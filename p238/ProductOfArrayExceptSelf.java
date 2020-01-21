/*238. Product of Array Except Self
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 * 
 * */
package p238;

import java.util.HashSet;

public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int mul = 1;
		HashSet<Integer> idx = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				idx.add(i);
				continue;
			}
			mul *= nums[i];
		}
		int[] ans = new int[nums.length];
		if (idx.size() > 1) {
			return ans;
		} else if (idx.size() == 1) {
			for (int i = 0; i < nums.length; i++) {
				if (idx.contains(i)) {
					ans[i] = mul / 1;
				} else
					ans[i] = 0;
			}
			return ans;
		}
		for (int i = 0; i < nums.length; i++) {
			ans[i] = mul / nums[i];
		}
		return ans;
	}
}
