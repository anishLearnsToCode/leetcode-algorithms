from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def is_leaf_node(self, root: TreeNode) -> bool:
        return root.left is None and root.right is None

    def binary_tree_paths(self, root: TreeNode, current_path: str, results: List[str]):
        if root is None:
            return
        if self.is_leaf_node(root):
            results.append(f'{current_path}->{root.val}'[2:])
            return
        self.binary_tree_paths(root.left, f'{current_path}->{root.val}', results)
        self.binary_tree_paths(root.right, f'{current_path}->{root.val}', results)

    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        result = []
        self.binary_tree_paths(root, '', results=result)
        return result
