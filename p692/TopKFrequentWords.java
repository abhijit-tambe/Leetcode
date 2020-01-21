/*
 * Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
 * */
package p692;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {

		HashMap<String, Integer> hm = new HashMap<>();
		for (String s : words) {
			hm.put(s, hm.getOrDefault(s, 0) + 1);
		}
		// slow approach brute force
		// List<String> str = hm.keySet().stream().sorted((a,b)->{
		// if(hm.get(b)==hm.get(a)){
		// return a.compareTo(b);
		// }else
		// return hm.get(b)-hm.get(a);})
		// .collect(Collectors.toList());
		// return str.subList(0,k);

		// using minimum heap
		PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
			if (hm.get(a) == hm.get(b)) {
				return b.compareTo(a);
			} else
				return hm.get(a) - hm.get(b);
		});

		List<String> str = new ArrayList<>();
		for (String s : hm.keySet()) {
			pq.offer(s);
			if (pq.size() > k) {
				pq.poll();
			}
		}

		for (int i = 0; i < k; i++) {
			str.add(0, pq.poll());
		}

		return str;
	}
}
