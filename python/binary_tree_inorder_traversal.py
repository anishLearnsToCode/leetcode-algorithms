from typing import Optional, List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right



class Solution:
    def _inorder_traversal(self, root: TreeNode, list: List[int]) -> None:
        if root == None: return
        self._inorder_traversal(root.left, list)
        list.append(root.val)
        self._inorder_traversal(root.right, list)

    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        self._inorder_traversal(root, result)
        return result
