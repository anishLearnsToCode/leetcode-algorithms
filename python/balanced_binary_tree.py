# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def _is_balanced(self, root: TreeNode) -> int:
        if root is None:
            return 0

        left_height = self._is_balanced(root.left)
        right_height = self._is_balanced(root.right)
        if left_height == -1 or right_height == -1 or abs(left_height - right_height) > 1:
            return -1

        return 1 + max(left_height, right_height)

    def isBalanced(self, root: TreeNode) -> bool:
        if root is None:
            return True
        return self._is_balanced(root) is not -1
