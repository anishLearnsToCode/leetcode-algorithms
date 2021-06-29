from typing import List, Dict


class Solution:
    def get_frequency(self, numbers: List[int]) -> Dict[int, int]:
        frequency = {}
        for number in numbers:
            frequency[number] = frequency.get(number, 0) + 1
        return frequency

    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result = []
        nums1, nums2 = (nums1, nums2) if len(nums1) < len(nums2) else (nums2, nums1)
        nums_1_freq = self.get_frequency(nums1)
        for number in nums2:
            if nums_1_freq.get(number, 0) >= 1:
                result.append(number)
                nums_1_freq[number] -= 1
        return result
