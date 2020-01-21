/*662. Maximum Width of Binary Tree
 * 
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:

Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:

Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:

Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:

Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 * */
package p662;

import java.util.HashMap;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class MaximumWidthofBinaryTree {

	static int ans;

	// using dfs start
	public int widthOfBinaryTree(TreeNode root) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		ans = 0;
		dfs(hm, 0, 0, root);
		return ans;
	}

	void dfs(HashMap<Integer, Integer> hm, int d, int idx, TreeNode root) {
		if (root == null) {
			return;
		}
		hm.computeIfAbsent(d, x -> idx);
		ans = Math.max(ans, idx - hm.get(d) + 1);
		dfs(hm, d + 1, 2 * idx, root.left);
		dfs(hm, d + 1, 2 * idx + 1, root.right);

	}
	// dfs end

	// using bfs
//	public int widthOfBinaryTree(TreeNode root) {
//		int ans = 0;
//		HashMap<TreeNode, Integer> hm = new HashMap<>();
//		Deque<TreeNode> dq = new ArrayDeque<>();
//		dq.add(root);
//		hm.put(root, 0);
//		while (!dq.isEmpty()) {
//			ans = Math.max(ans, hm.get(dq.peekLast()) + 1 - hm.get(dq.peekFirst()));
//			int size = dq.size();
//			for (int i = 0; i < size; i++) {
//				TreeNode cur = dq.poll();
//				int pos = hm.get(cur);
//				if (cur.left != null) {
//					hm.put(cur.left, 2 * pos + 1);
//					dq.offer(cur.left);
//				}
//				if (cur.right != null) {
//					hm.put(cur.right, 2 * pos + 2);
//					dq.offer(cur.right);
//				}
//			}
//		}
//		return ans;
//	}

}
