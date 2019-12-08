/*
 * 136. Single Number
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 * 
 * */
package p136;

import java.util.HashMap;

public class SingleNumber {
	public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int x:nums){
            freq.put(x,freq.getOrDefault(x,0)+1);
        }
        
        for(int x :nums){
            if(freq.get(x)==1){
                return x;
            }
        }
        return -1;
    }
}
