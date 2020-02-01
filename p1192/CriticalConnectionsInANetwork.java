/*
 * 1192. Critical Connections in a Network
There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:



Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
 

Constraints:

1 <= n <= 10^5
n-1 <= connections.length <= 10^5
connections[i][0] != connections[i][1]
There are no repeated connections.
 * 
 * */package p1192;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetwork {

	static int count;

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		count = 0;
		boolean[] vis = new boolean[n];
		int low[] = new int[n];
		int dis[] = new int[n];
		int parent[] = new int[n];
		List<List<Integer>> li = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			li.add(new ArrayList<>());
		}

		for (List i : connections) {
			li.get((int) i.get(0)).add((int) i.get(1));
			li.get((int) i.get(1)).add((int) i.get(0));
		}
		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				dfsDis(i, li, vis, dis, low, parent, ans);
			}
		}
		return ans;
	}

	void dfsDis(int s, List<List<Integer>> li, boolean[] vis, int[] dis, int[] low, int[] parent,
			List<List<Integer>> ans) {
		vis[s] = true;
		low[s] = dis[s] = ++count;
		List<Integer> temp = li.get(s);
		for (int i : temp) {
			if (!vis[i]) {
				parent[i] = s;
				dfsDis(i, li, vis, dis, low, parent, ans);
				low[s] = Math.min(low[s], low[i]);
				if (low[i] > dis[s]) {
					ans.add(new ArrayList<Integer>(Arrays.asList(i, s)));
				}
			} else if (i != parent[s]) {
				low[s] = Math.min(low[s], dis[i]);
			}
		}
	}

}
