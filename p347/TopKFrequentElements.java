/*347. Top K Frequent Elements
 * 
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * */
package p347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TopKFrequentElements {
	
	    public List<Integer> topKFrequent(int[] nums, int k) {
	        HashMap<Integer,Integer> freq = new HashMap<>();
	        
	        for (int x : nums){
	            freq.put(x,freq.getOrDefault(x,0)+1);
	        }
	        
	        List<Integer> ans = new ArrayList<>();
	        
	        ans = freq.keySet().stream().sorted((a,b)->freq.get(b)-freq.get(a)).collect(Collectors.toList());
	        
	        return new ArrayList<Integer>(ans.subList(0,k)); 
	    }
	
}
