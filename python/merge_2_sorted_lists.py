# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        result = ListNode(val=-1)
        previous = result

        while l1 is not None and l2 is not None:
            if l1.val <= l2.val:
                previous.next = l1
                l1 = l1.next
            else:
                previous.next = l2
                l2 = l2.next
            previous = previous.next

        previous.next = l2 if l1 is None else l1
        return result.next
