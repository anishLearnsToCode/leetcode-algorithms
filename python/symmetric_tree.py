# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def is_symmetric(self, left: TreeNode, right: TreeNode) -> bool:
        if left and right:
            return left.val == right.val and self.is_symmetric(left.left, right.right) \
                   and self.is_symmetric(left.right, right.left)
        return left == right

    def isSymmetric(self, root: TreeNode) -> bool:
        return root is None or self.is_symmetric(root.left, root.right)
