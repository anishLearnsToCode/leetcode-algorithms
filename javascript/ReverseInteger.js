// https://leetcode.com/problems/reverse-integer/

var reverse = function (x) {
  let result = 0;
  const isNegative = x <= 0;
  let absNumber = Math.abs(x);
  while (absNumber !== 0) {
    let remainder = absNumber % 10;
    absNumber = Math.floor(absNumber / 10);
    result = result * 10 + remainder;
    if (result > 2147483647) {
      return 0;
    }
  }
  return isNegative ? -result : result;
};
