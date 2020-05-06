/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var sortedArrayToBST = function (nums) {
  var result = (s, l) => {
    if (s <= l) {
      let mid = Math.floor(s + (l - s) / 2);
      var r = new TreeNode(nums[mid]);
      r.left = result(s, mid - 1);
      r.right = result(mid + 1, l);
      return r;
    } else return null;
  };
  return result(0, nums.length - 1);
};
