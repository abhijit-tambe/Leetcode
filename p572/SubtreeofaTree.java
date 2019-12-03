/*572. Subtree of Another Tree
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.*/

package p572;
//
//public class SubtreeofaTree {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}

//class Solution {
//    public boolean isSubtree(TreeNode s, TreeNode t) {
//            if(s==null){
//                return t==null;
//            }
//        return isSame(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);
//        
//    }
//    
//    public boolean isSame(TreeNode s,TreeNode t){
//        if(s==null){
//         return t==null;   
//        }
//        if(t==null){
//         return false;    
//        }
//        
//        return (s.val==t.val)&&isSame(s.left,t.left)&&isSame(s.right,t.right);
//    }
//    
//}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



class SubtreeofaTree{
//class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
            if(s==null){
                return true;
            }
        
        if(s.val == t.val){
          return isSame(s,t);    
        }
        // isSubtree(s.left,t);
        // isSubtree(s.right,t);
        if(isSubtree(s.left,t)){
            return isSubtree(s.right,t);
        }
        return false;
    }
    
    public boolean isSame(TreeNode s,TreeNode t){
        if(s==null&&t==null){
         return true;   
        }
        if(s==null&&t!=null||s!=null&&t==null){
            return false;
        }
        
        if((s.val==t.val)&&isSame(s.left,t.left)&&isSame(s.right,t.right))
        {
            return true;
        }            
        return false;
        
    }
    
}