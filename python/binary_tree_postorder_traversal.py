# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def _postorder_traversal(self, root: Optional[TreeNode], list: List[int]) -> None:
        if root is None: return
        self._postorder_traversal(root.left, list)
        self._postorder_traversal(root.right, list)
        list.append(root.val)

    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        self._postorder_traversal(root, result)
        return result
