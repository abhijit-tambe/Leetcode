/*108. Convert Sorted Array to Binary Search Tree
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5*/

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {        
        int last = nums.length;
        if(last==0){
            return null;
        }
        TreeNode root = new TreeNode();
        
        return bs(nums,0,last-1,root.left);
        
    }
    
    
    TreeNode bs(int [] nums , int s, int l,TreeNode r){
        if(s<=l){
            int mid = s +(l-s)/2 ;
             r = new TreeNode(nums[mid]);
            r.left = bs(nums,s,mid-1,r.left);
            r.right = bs(nums,mid+1,l,r.right);
        return r;
    }else return null;
}
}