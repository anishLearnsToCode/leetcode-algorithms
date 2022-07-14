// https://leetcode.com/problems/reverse-integer
// T: O(log(n))
// S: O(1)

const INTEGER_MAX_VAL = 2147483647;

const reverse = x => {
  let result = 0;
  const isNegative = x <= 0;
  let absNumber = Math.abs(x);

  while (absNumber !== 0) {
    let remainder = absNumber % 10;
    absNumber = Math.floor(absNumber / 10);
    result = result * 10 + remainder;
    if (result > INTEGER_MAX_VAL) {
      return 0;
    }
  }

  return isNegative ? -result : result;
};

console.log(reverse(120))
