# https://leetcode.com/problems/number-of-zero-filled-subarrays/
# T: O(N) where N is the length of nums
# S: O(1)

class Solution:
    def zeroFilledSubarray(self, nums) -> int:
        count = 0
        i = 0
        while i < len(nums):
            if nums[i] == 0:
                j = i
                while j < len(nums) and nums[j] == 0:
                    j += 1
                count += (j - i) * (j - i + 1) // 2
                i = j
            else:
                i = i+1

        return count
