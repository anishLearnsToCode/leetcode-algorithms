from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __repr__(self):
        return str(self.val)

    def __str__(self):
        return str(self.val)


class Solution:
    def get_path_to(self, root: TreeNode, node: TreeNode) -> deque:
        path = deque()
        while root.val != node.val:
            path.append(root)
            root = root.left if root.val > node.val else root.right
        path.append(root)
        return path

    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        path_p = self.get_path_to(root, p)
        path_q = self.get_path_to(root, q)
        index = 0
        for node_p, node_q in zip(path_p, path_q):
            if node_p is not node_q:
                break
            index += 1
        return path_p[index - 1]
