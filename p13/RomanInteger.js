/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function (s) {
  // console.log(s);
  const hash = {
    I: 1,
    V: 5,
    X: 10,
    L: 50,
    C: 100,
    D: 500,
    M: 1000,
  };
  var sum = 0;
  for (var a = 0; a < s.length; ) {
    if (hash[s.charAt(a)] < hash[s.charAt(a + 1)]) {
      sum += hash[s.charAt(a + 1)] - hash[s.charAt(a)];
      a++;
    } else sum += hash[s.charAt(a)];
    a++;
  }
  return sum;
};
