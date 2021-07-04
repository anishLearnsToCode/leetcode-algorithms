# Definition for a binary tree node.
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.count = 1
        self.previous = None
        self.max = 0

    def find_mode(self, root: TreeNode, modes: List[int]):
        if root is None:
            return
        self.find_mode(root.left, modes)
        if self.previous:
            self.count = self.count + 1 if root.val == self.previous.val else 1
        if self.count > self.max:
            self.max = self.count
            modes.clear()
            modes.append(root.val)
        elif self.count == self.max:
            modes.append(root.val)
        self.previous = root
        self.find_mode(root.right, modes)

    def findMode(self, root: TreeNode) -> List[int]:
        if root is None: return []
        result = []
        self.find_mode(root, result)
        return result
