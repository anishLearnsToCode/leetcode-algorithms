from heapq import heappop, heappush

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def addNodesToSet(self, root: TreeNode, elements: set) -> None:
        if root is None: return
        elements.add(root.val)
        self.addNodesToSet(root.left, elements)
        self.addNodesToSet(root.right, elements)

    def unique_elements(self, root: TreeNode) -> set:
        elements = set()
        self.addNodesToSet(root, elements)
        return elements

    def findSecondMinimumValue(self, root: TreeNode) -> int:
        elements = self.unique_elements(root)
        if len(elements) < 2: return -1
        heap = []
        for element in elements:
            heappush(heap, element)
        heappop(heap)
        return heappop(heap)
