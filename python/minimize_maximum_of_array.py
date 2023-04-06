# https://leetcode.com/problems/minimize-maximum-of-array/description/
# T:O(n) where n is the number of elements in the array
# S:O(1)

class Solution:
    def minimizeArrayValue(self, nums: List[int]) -> int:
        minimumValue = 0
        prefixSum = 0
        for i, num in enumerate(nums):
            prefixSum += num
            minimumValue = max(minimumValue,((prefixSum+i)//(i+1)))
        return minimumValue
