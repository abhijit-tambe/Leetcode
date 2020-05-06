/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function (nums) {
  var set = new Set();
  nums.forEach((x) => {
    set.add(x);
  });
  return nums.length === set.size ? false : true;
};
