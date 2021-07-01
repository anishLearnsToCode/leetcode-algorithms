from typing import List


class Solution:
    def get_distance(self, p1: List[int], p2: List[int]) -> int:
        x1, y1 = p1
        x2, y2 = p2
        dx, dy = x2 - x1, y2 - y1
        return dx ** 2 + dy ** 2

    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        result = 0
        for p1 in points:
            distance_frequency = {}
            for p2 in points:
                distance = self.get_distance(p1, p2)
                distance_frequency[distance] = distance_frequency.get(distance, 0) + 1
            for frequency in distance_frequency.values():
                result += frequency * (frequency - 1)
        return result
