/*128. Longest Consecutive Sequence
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * */
package p128;

import java.util.HashSet;

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
		if (nums.length < 1)
			return 0;
		int cur_max = 0;
		int global_max = 1;
//  O(nlogn)
//		int cur = 0;
//		int next = 0;
//		Arrays.sort(nums);
//		System.out.print(Arrays.toString(nums));
//		cur = nums[0];
//		next = cur + 1;
//		int count = 1;
//		for (int i = 1; i < nums.length; i++) {
//			if (nums[i] == nums[i - 1]) {
//				continue;
//			}
//			if (nums[i] != next) {
//
//				cur = nums[i];
//
//				next = cur;
//				count = 0;
//			}
//
//			next++;
//			count++;
//			global_max = Math.max(count, global_max);
//
//		}
//		return global_max;

		// O(n)
		HashSet<Integer> hs = new HashSet<>();
		for (int i : nums) {
			hs.add(i);
		}

		for (int i : hs) {
			if (!hs.contains(i - 1)) {
				int temp = i;
				cur_max = 1;
				while (hs.contains(++temp)) {
					cur_max++;
				}

				global_max = Math.max(cur_max, global_max);
			}

		}

		return global_max;
	}

}
