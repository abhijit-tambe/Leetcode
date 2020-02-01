/*1313. Decompress Run-Length Encoded List
We are given a list nums of integers representing a list compressed with run-length encoding.

Consider each adjacent pair of elements [a, b] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are a elements with value b in the decompressed list.

Return the decompressed list.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [2,4,4,4]
Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
At the end the concatenation [2] + [4,4,4,4] is [2,4,4,4].

 * */
package p1313;

public class DecompressRunLengthEncodedList {
	public int[] decompressRLElist(int[] nums) {
		int length = 0;
		for (int i = 0; i < nums.length; i += 2) {
			length += nums[i];
		}
		System.out.print(length);
		int j = 0;
		int[] arr = new int[length];
		for (int i = 0; i < nums.length; i += 2) {
			int x = nums[i];
			while (x-- > 0) {
				arr[j] = nums[i + 1];
				j++;
			}
		}
		return arr;
	}
}
