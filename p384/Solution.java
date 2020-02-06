/*384. Shuffle an Array
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
 * */package p384;

import java.util.Random;

public class Solution {

	static int[] og;
	static int[] shuf;

	public Solution(int[] nums) {
		og = nums.clone();
		shuf = nums.clone();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return og;
	}

	void swap(int i, int j) {
		int temp = shuf[i];
		shuf[i] = shuf[j];
		shuf[j] = temp;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		Random r = new Random();
		for (int i = 0; i < shuf.length; i++) {
			int r1 = r.nextInt(shuf.length - i) + i;
			swap(i, r1);
		}
		return shuf;
	}

}
