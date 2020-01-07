/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * 
 * */
package p102;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int h=0;
        List<List<Integer>>  res = new ArrayList<>();
        List<Integer> il = new ArrayList<>();
        if(root==null){
            return res;
        }
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            il = new ArrayList<>();
            for(int i=0;i<s;i++){
             TreeNode x = q.poll();
                il.add(x.val);
                if(x.left!=null){
                    q.add(x.left);
                }
                if(x.right!=null){
                    q.add(x.right);
                }
            }
            res.add(h,il);
            h++;
        }
        return res;
    }


}
