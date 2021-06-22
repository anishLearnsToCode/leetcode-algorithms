from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        result = [0] * (m + n)
        i, j, k = 0, 0, 0
        while i < m and j < n:
            if nums1[i] < nums2[j]:
                result[k] = nums1[i]
                i += 1
            else:
                result[k] = nums2[j]
                j += 1
            k += 1
        while i < m:
            result[k] = nums1[i]
            i += 1
            k += 1
        while j < n:
            result[k] = nums2[j]
            j += 1
            k += 1
        for i in range(m + n):
            nums1[i] = result[i]
