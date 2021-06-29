# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def is_leaf_node(self, root: TreeNode) -> bool:
        return root.left is None and root.right is None

    def sum_left_leaves(self, root: TreeNode, is_left_branch: bool) -> int:
        if root is None:
            return 0
        if self.is_leaf_node(root) and is_left_branch:
            return root.val
        return self.sum_left_leaves(root.left, is_left_branch=True) + self.sum_left_leaves(root.right, is_left_branch=False)

    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        return self.sum_left_leaves(root, is_left_branch=False)
