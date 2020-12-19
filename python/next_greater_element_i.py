from typing import List, Dict


class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        next_greater_map = self.get_next_greater_elements(nums2)
        result = []
        for element in nums1:
            result.append(next_greater_map[element])
        return result

    def get_next_greater_elements(self, array: List[int]) -> Dict[int, int]:
        stack = []
        result = {}
        for element in array:
            while len(stack) != 0 and element > stack[-1]:
                result[stack.pop()] = element
            stack.append(element)

        while len(stack) !=0:
            result[stack.pop()] = -1

        return result
