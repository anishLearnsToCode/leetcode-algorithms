# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.sumTilts = 0

    def computeTilts(self, root: TreeNode) -> int:
        if root is None: return 0
        leftSum, rightSum = self.computeTilts(root.left), self.computeTilts(root.right)
        self.sumTilts += abs(leftSum - rightSum)
        return leftSum + rightSum + root.val

    def findTilt(self, root: TreeNode) -> int:
        self.computeTilts(root)
        return self.sumTilts
