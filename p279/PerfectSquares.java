/*
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 * */
package p279;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PerfectSquares {
	public int numSquares(int n) {
		List<Integer> li = new ArrayList<>();
		int num = Integer.MAX_VALUE;
		for (int i = 1; i * i <= n; i++) {

			li.add(i * i);
		}

		HashSet<Integer> vis = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();

		for (int i = li.size() - 1; i >= 0; i--) {
			q.offer(n - li.get(i));
			vis.add(n - li.get(i));
		}

		int d = 1;
		while (!q.isEmpty()) {

			int s = q.size();
			for (int i = 0; i < s; i++) {
				int cur = q.poll();
				if (cur == 0) {
					return d;
				}
				if (li.contains(cur)) {
					return d + 1;
				} else {
					for (int j : li) {
						int t = cur - j;
						if (t >= 0) {
							if (!vis.contains(t)) {
								q.offer(t);
								vis.add(t);
							}

						} else
							break;
					}
				}

			}
			d++;
		}

		return d;
	}
}
