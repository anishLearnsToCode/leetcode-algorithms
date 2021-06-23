# Definition for a binary tree node.
from typing import List
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []

        queue = deque()
        queue.append(root)
        result = []
        current_level = []

        while len(queue):
            current_level_length = len(queue)
            for _ in range(current_level_length):
                current = queue.popleft()
                current_level.append(current.val)
                if current.left:
                    queue.append(current.left)
                if current.right:
                    queue.append(current.right)
            result.append(current_level)
            current_level = []

        return result[::-1]
