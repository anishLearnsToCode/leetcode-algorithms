from collections import deque


class MyQueue:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1 = deque()
        self.s2 = deque()

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        while len(self.s1) > 0:
            self.s2.append(self.s1.pop())
        self.s1.append(x)
        while len(self.s2) > 0:
            self.s1.append(self.s2.pop())

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        return self.s1.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.s1[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.s1) == 0

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()