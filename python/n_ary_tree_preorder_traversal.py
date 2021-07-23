# Definition for a Node.
from typing import List


class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def __init__(self):
        self.result = []

    def preorderTraversal(self, root: Node) -> None:
        if root is None: return None
        self.result.append(root.val)
        for child in root.children:
            self.preorderTraversal(child)

    def preorder(self, root: Node) -> List[int]:
        self.preorderTraversal(root)
        return self.result
