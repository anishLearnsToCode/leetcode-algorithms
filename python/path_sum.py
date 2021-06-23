# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def _is_leaf_node(self, node: TreeNode) -> bool:
        return node.left is None and node.right is None

    def _has_path_sum(self, root: TreeNode, target: int, currentSum: int) -> bool:
        if root is None:
            return False
        currentSum += root.val
        if self._is_leaf_node(root):
            return currentSum == target
        return self._has_path_sum(root.left, target, currentSum) or \
               self._has_path_sum(root.right, target, currentSum)

    def hasPathSum(self, root: TreeNode, targetSum: int) -> bool:
        if root is None:
            return False
        return self._has_path_sum(root, targetSum, 0)


root = TreeNode(val=1)
root.right = TreeNode(val=2)
print(Solution().hasPathSum(root, 3))
