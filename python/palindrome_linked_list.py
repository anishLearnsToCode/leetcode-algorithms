# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def length(self, head: ListNode) -> int:
        count = 0
        while head is not None:
            count += 1
            head = head.next
        return count

    def reverse(self, head: ListNode) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head
        a, b, c = head, head.next, head.next.next
        a.next = None
        while c is not None:
            b.next = a
            a, b, c = b, c, c.next
        b.next = a
        return b

    def isPalindrome(self, head: ListNode) -> bool:
        list_length = self.length(head)
        first_half = head
        second_half = head
        for i in range((list_length + 1) // 2):
            second_half = second_half.next
        second_half = self.reverse(second_half)
        while second_half is not None:
            if first_half.val != second_half.val:
                return False
            second_half = second_half.next
            first_half = first_half.next
        return True
