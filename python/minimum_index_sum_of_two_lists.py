from typing import List


class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        restaurant1_2_indices = {}
        index_sum = float('inf')
        result = []
        for index, restaurant in enumerate(list1):
            restaurant1_2_indices[restaurant] = index
        for index, restaurant in enumerate(list2):
            if index + restaurant1_2_indices.get(restaurant, float('inf')) < index_sum:
                index_sum = index + restaurant1_2_indices[restaurant]
                result = [restaurant]
            elif index + restaurant1_2_indices.get(restaurant, float('inf')) == index_sum:
                result.append(restaurant)
        return result
