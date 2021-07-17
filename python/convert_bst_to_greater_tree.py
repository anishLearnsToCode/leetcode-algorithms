# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.value = 0

    def computeGreaterTree(self, root: TreeNode):
        if root is None: return
        self.computeGreaterTree(root.right)
        root.val += self.value
        self.value = root.val
        self.computeGreaterTree(root.left)

    def convertBST(self, root: TreeNode) -> TreeNode:
        self.computeGreaterTree(root)
        return root
