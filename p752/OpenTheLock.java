/*752. Open the Lock
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

Example 1:
Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:
Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:
Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation:
We can't reach the target without getting stuck.
Example 4:
Input: deadends = ["0000"], target = "8888"
Output: -1
Note:
The length of deadends will be in the range [1, 500].
target will not be in the list deadends.
Every string in deadends and the string target will be a string of 4 digits from the 10,000 possibilities '0000' to '9999'.
 * */package p752;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OpenTheLock {
	public int openLock(String[] deadends, String target) {
		HashSet<String> vis = new HashSet<>(Arrays.asList(deadends));
		int steps = 0;
		String s = "0000";
		List<String> dvis = new ArrayList<>();
		if (vis.contains("0000")) {
			return -1;
		}

		for (int j = 0; j < 4; j++) {

			int curup = Character.getNumericValue(target.charAt(j));

			int curdown = Character.getNumericValue(target.charAt(j));

			curup = curup == 9 ? 0 : curup + 1;
			curdown = curdown == 0 ? 9 : curdown - 1;
			String up = target.substring(0, j) + curup + target.substring(j + 1, target.length());
			String down = target.substring(0, j) + curdown + target.substring(j + 1, target.length());
			dvis.add(up);
			dvis.add(down);
		}

		if (vis.containsAll(dvis)) {
			return -1;
		}
		System.out.print(dvis);
		Queue<String> q = new LinkedList<>();
		q.offer(s);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String str = q.poll();

				if (str.equals(target)) {
					return steps;
				}
				if (vis.contains(str)) {
					continue;
				}
				vis.add(str);
				for (int j = 0; j < 4; j++) {

					int curup = Character.getNumericValue(str.charAt(j));

					int curdown = Character.getNumericValue(str.charAt(j));

					curup = curup == 9 ? 0 : curup + 1;
					curdown = curdown == 0 ? 9 : curdown - 1;

					String up = str.substring(0, j) + curup + str.substring(j + 1, str.length());
					String down = str.substring(0, j) + curdown + str.substring(j + 1, str.length());
					q.offer(up);
					q.offer(down);

				}
			}
			steps++;

		}

		return -1;

	}
}
