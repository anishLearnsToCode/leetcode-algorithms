# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def deleteNode(self, node: ListNode) -> None:
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        while node is not None and node.next is not None and node.next.next is not None:
            node.val = node.next.val
            node = node.next
        node.val = node.next.val
        node.next = None
