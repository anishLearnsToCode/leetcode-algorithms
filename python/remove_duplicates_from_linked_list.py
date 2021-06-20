class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def deleteDuplicates(head: ListNode) -> ListNode:
    if head is None:
        return None
    current = head
    while current is not None:
        if current.val == current.next.val:
            current.next = current.next.next
        else:
            current = current.next
    return head
