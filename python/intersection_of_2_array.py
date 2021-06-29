from typing import List


class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums_1_unique = set(nums1)
        nums_2_unique = set(nums2)
        return list(nums_1_unique.intersection(nums_2_unique))
