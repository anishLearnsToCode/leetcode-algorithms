// https://leetcode.com/problems/palindrome-number
// T: O(log(n))
// S: O(1)

const isPalindrome = x => {
  if (x < 0 || (x % 10 === 0 && x !== 0)) {
    return false;
  }
  let result = x;
  let sum = 0;
  while (x !== 0) {
    let remainder = x % 10;
    sum = sum * 10 + remainder;
    x = Math.floor(x / 10);
  }

  return sum === result;
};
