# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def _preorder_traversal(self, root: Optional[TreeNode], list: List[int]) -> None:
        if root is None: return
        list.append(root.val)
        self._preorder_traversal(root.left, list)
        self._preorder_traversal(root.right, list)

    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        self._preorder_traversal(root, result)
        return result
