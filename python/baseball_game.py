from typing import List
from collections import deque

class Solution:
    def calPoints(self, ops: List[str]) -> int:
        items = deque()
        for operation in ops:
            if operation == '+':
                items.append(items[len(items) - 1] + items[len(items) - 2])
            elif operation == 'D':
                items.append(items[len(items) - 1] * 2)
            elif operation == 'C':
                items.pop()
            else:
                items.append(int(operation))
        return sum(items)
