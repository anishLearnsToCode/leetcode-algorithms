class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        runner_1, runner_2 = headA, headB

        while runner_1 is not runner_2:
            if runner_1 is None:
                runner_1 = headB
            else:
                runner_1 = runner_1.next

            if runner_2 is None:
                runner_2 = headA
            else:
                runner_2 = runner_2.next

        return None if runner_1 is None else runner_1
