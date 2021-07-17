from typing import List


class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        pairs = 0
        if k == 0:
            frequencies = {}
            for number in nums:
                frequencies[number] = frequencies.get(number, 0) + 1
            for frequency in frequencies.values():
                pairs += 1 if frequency > 1 else 0
        else:
            numbers = set()
            for number in nums:
                if number not in numbers:
                    pairs += 1 if (number - k) in numbers else 0
                    pairs += 1 if (number + k) in numbers else 0
                    numbers.add(number)
        return pairs
