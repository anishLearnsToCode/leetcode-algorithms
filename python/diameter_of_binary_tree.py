# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.diameter = 0

    def computerDiameterOfBinaryTree(self, root: TreeNode) -> int:
        if root is None: return 0
        leftHeight = self.computerDiameterOfBinaryTree(root.left)
        rightHeight = self.computerDiameterOfBinaryTree(root.right)
        self.diameter = max(self.diameter, leftHeight + rightHeight)
        return 1 + max(leftHeight, rightHeight)

    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.computerDiameterOfBinaryTree(root)
        return self.diameter
