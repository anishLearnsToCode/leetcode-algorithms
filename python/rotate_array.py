from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k %= len(nums)
        if k == 0:
            return
        temp = nums[-k:]
        for i in range(len(nums) - 1, k - 1, -1):
            nums[i] = nums[i - k]
        for i, val in enumerate(temp):
            nums[i] = val

    def reverse(self, A, i, j):
        while i < j:
            A[i], A[j] = A[j], A[i]
            i += 1
            j -= 1

    # this is method no. 2 to solve it with O(1) space complexity
    def rotate_2(self, A, k):
        L = len(A)
        k %= L
        if k:
            self.reverse(A, 0, L - 1)
            self.reverse(A, 0, k - 1)
            self.reverse(A, k, L - 1)
