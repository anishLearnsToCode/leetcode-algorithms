from typing import List


class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        left, right = 0, len(letters) - 1
        while left <= right:
            middle = left + (right - left) // 2
            if letters[middle] <= target: left = middle + 1
            else: right = middle - 1
        return letters[left % len(letters)]
