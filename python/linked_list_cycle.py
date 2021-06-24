# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def not_null(self, head: ListNode) -> bool:
        return head is not None

    def hasCycle(self, head: ListNode) -> bool:
        if head is None:
            return False
        slow, fast = head, head.next
        while self.not_null(slow) and self.not_null(fast) and self.not_null(slow.next) and self.not_null(fast.next):
            if slow is fast:
                return True
            slow = slow.next
            fast = fast.next.next
        return False
