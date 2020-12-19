from math import sqrt
from typing import List


class Solution:
    def constructRectangle(self, area: int) -> List[int]:
        width = int(sqrt(area))

        while width > 0:
            if area % width == 0:
                return [area // width, width]
            else:
                width -= 1

        return [area, 1]
