from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseList(self, head: ListNode) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head
        a, b, c = head, head.next, head.next.next
        a.next = None
        while c is not None:
            b.next = a
            a, b, c = b, c, c.next
        b.next = a
        return b
