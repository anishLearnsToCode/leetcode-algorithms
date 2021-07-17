# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.infinity = float('inf')
        self.result = self.infinity

    def computeMinimumAbsDifference(self, root: TreeNode, left: float, right: float):
        if root is None: return
        self.result = min(self.result, root.val - left, right- root.val)
        self.computeMinimumAbsDifference(root.left, left, root.val)
        self.computeMinimumAbsDifference(root.right, root.val, right)

    def minDiffInBST(self, root: TreeNode) -> int:
        self.computeMinimumAbsDifference(root, -self.infinity, self.infinity)
        return int(self.result)
