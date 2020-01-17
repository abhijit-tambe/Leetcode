/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6 * */
package p42;

import java.util.Arrays;

public class TrappingRainWater {
	public int trap(int[] height) {
		if (height.length < 1) {
			return 0;
		}
		int l[] = new int[height.length];
		int r[] = new int[height.length];
		l[0] = height[0];
		r[height.length - 1] = height[height.length - 1];
		int water = 0;
		for (int i = 1; i < height.length; i++) {
			l[i] = Math.max(l[i - 1], height[i]);
		}
		for (int i = height.length - 2; i >= 0; i--) {
			r[i] = Math.max(r[i + 1], height[i]);
		}
		for (int i = 0; i < height.length; i++) {
			water += Math.min(l[i], r[i]) - height[i];
		}
		System.out.println(Arrays.toString(l));
		System.out.println(Arrays.toString(r));
		return water;
	}
}
