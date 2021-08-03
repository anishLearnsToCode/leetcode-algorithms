# Definition for a binary tree node.
from typing import List
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def averageOfLevels(self, root: TreeNode) -> List[float]:
        result = [0]
        queue = deque()
        queue.append(root)
        queue.append(None)
        count = 0
        while queue:
            current = queue.popleft()
            if current is None and len(queue) == 0: break
            if current is None:
                queue.append(None)
                result[-1] /= count
                result.append(0)
                count = 0
                continue
            count += 1
            if current.left is not None: queue.append(current.left)
            if current.right is not None: queue.append(current.right)
            result[-1] += current.val
        result[-1] /= count
        return result
