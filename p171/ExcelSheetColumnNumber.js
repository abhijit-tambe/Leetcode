/**
 * @param {string} s
 * @return {number}
 */
var titleToNumber = function (s) {
  let value = s.charCodeAt(0) - 64;
  for (i = 1; i < s.length; i++) {
    value = value * 26 + s.charCodeAt(i) - 64;
  }
  return value;
};
