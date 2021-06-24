class Node:
    def __init__(self, val, min, previous):
        self.val = val
        self.next = next
        self.min = min
        self.previous = previous

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.current = None

    def push(self, val: int) -> None:
        if self.current is None:
            self.current = Node(val, val, None)
        else:
            self.current.next = Node(val, min(val, self.current.min), self.current)
            self.current = self.current.next

    def pop(self) -> None:
        val = self.current.val
        self.current = self.current.previous
        return val

    def top(self) -> int:
        return self.current.val

    def getMin(self) -> int:
        return self.current.min
