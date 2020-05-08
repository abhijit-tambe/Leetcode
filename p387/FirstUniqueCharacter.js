/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function (s) {
  let hash = new Map();
  for (let a in s) {
    if (!hash.has(s.charAt(a))) {
      hash.set(s.charAt(a), 1);
    } else {
      hash.set(s.charAt(a), hash.get(s.charAt(a)) + 1);
    }
  }
  for (let a in s) {
    if (hash.get(s.charAt(a)) == 1) {
      return a;
    }
  }
  return -1;
};
