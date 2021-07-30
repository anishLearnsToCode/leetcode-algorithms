from typing import List


class Solution:
    def maximumProduct(self, array: List[int]) -> int:
        positive_1, positive_2, positive_3 = (-float('inf'), ) * 3
        negative_1, negative_2 = (float('inf'), ) * 2
        for number in array:
            if number > positive_1:
                positive_3 = positive_2
                positive_2 = positive_1
                positive_1 = number
            elif number > positive_2:
                positive_3 = positive_2
                positive_2 = number
            elif number > positive_3:
                positive_3 = number
            if number < negative_1:
                negative_2 = negative_1
                negative_1 = number
            elif number < negative_2:
                negative_2 = number

        return max(positive_1 * positive_2 * positive_3, negative_1 * negative_2 * positive_1)
