// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// T: O(N)
// S: O(1)

const removeDuplicates = (nums) => {
  let index = 0;
  for (let i = 1; i < nums.length; i++) {
    if (nums[index] < nums[i]) {
      nums[index + 1] = nums[i];
      index++;
    }
  }
  return index + 1;
};
