/*94. Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
*/


/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */


/*DFS*/
var inorderTraversal = function(root) {
    var number = []; 
    dfs(root,number);
    return number;
};

var dfs = function(root,number){
    if(root===null){
        return ;
    }
    dfs(root.left,number);
    number.push(root.val);
    dfs(root.right,number);
}