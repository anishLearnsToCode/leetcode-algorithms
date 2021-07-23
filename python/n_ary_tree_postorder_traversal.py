# Definition for a Node.
from typing import List


class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def __init__(self):
        self.result = []

    def postorderTraversal(self, root: Node) -> None:
        if root is None: return None
        for child in root.children:
            self.postorderTraversal(child)
        self.result.append(root.val)

    def postorder(self, root: Node) -> List[int]:
        self.postorderTraversal(root)
        return self.result
