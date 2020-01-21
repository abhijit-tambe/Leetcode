/*46. Permutations

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * */package p46;

import java.util.ArrayList;
import java.util.List;

public class Permutaion {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();

		per(nums, ans, 0);
		return ans;

	}

	void per(int[] nums, List<List<Integer>> ans, int j) {
		if (j == nums.length) {
			List<Integer> unq = new ArrayList<>();
			for (int u : nums) {
				unq.add(u);
			}
			ans.add(unq);
			return;
		}

		for (int i = j; i < nums.length; i++) {
			swap(i, j, nums);
			per(nums, ans, j + 1);
			swap(i, j, nums);
		}
	}

	void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
