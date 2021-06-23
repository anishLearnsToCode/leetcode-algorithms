# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __repr__(self):
        return f'Tree(val={self.val})'


class Solution:
    def sorted_array_to_bst(self, array: List[int], start: int, end: int) -> Optional[TreeNode]:
        if end == start:
            return None

        middle = (start + end) // 2
        root = TreeNode(val=array[middle])
        root.left = self.sorted_array_to_bst(array, start, middle)
        root.right = self.sorted_array_to_bst(array, middle + 1, end)
        return root

    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        return self.sorted_array_to_bst(nums, 0, len(nums))
