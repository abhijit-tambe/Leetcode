/*1161. Maximum Level Sum of a Binary Tree
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level X such that the sum of all the values of nodes at level X is maximal.

 

Example 1:



Input: [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
 

Note:

The number of nodes in the given tree is between 1 and 10^4.
-10^5 <= node.val <= 10^5
 * */package p1161;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class MaximumLevelSumofaBinaryTree {
	public int maxLevelSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int max = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int level = 1;
		int max_level = 1;
		while (!q.isEmpty()) {
			int sum = 0;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				sum += cur.val;
				if (cur.left != null) {
					q.offer(cur.left);
				}
				if (cur.right != null) {
					q.offer(cur.right);
				}
			}

			if (sum > max) {
				max = sum;
				max_level = level;
			}
			level++;

		}

		return max_level;
	}

	// DFS
//	public int maxLevelSum(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        int max=0;
//        int max_level=0;
//        HashMap<Integer,Integer> hm = new HashMap<>();
//        dfs(root,1,hm);
//        for(int i : hm.keySet()){
//            if(hm.get(i)>max){
//                max = hm.get(i);
//                max_level=i;
//            }
//        }
//        return max_level;
//    }
//    
//   void dfs(TreeNode root,int d,HashMap<Integer,Integer> hm){
//        if(root == null){
//            return;
//        }
//       if(hm.containsKey(d)){
//           hm.put(d,hm.get(d)+root.val);
//       }else{
//           hm.put(d,root.val);
//       }
//       dfs(root.left,d+1,hm);
//       dfs(root.right,d+1,hm);
//    }
}
