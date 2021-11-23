class Bucket:
    def __init__(self):
        self.list = []

    def contains(self, element: int) -> bool:
        return element in self.list

    def add(self, element: int) -> None:
        self.list.append(element)

    def remove(self, element: int) -> None:
        if self.contains(element):
            self.list.remove(element)


class MyHashSet:
    def __init__(self):
        self._initial_size = 100
        self.size = 0
        self.buckets = [Bucket() for _ in range(self._initial_size)]

    def add(self, key: int) -> None:
        hashCode = key % len(self.buckets)
        if not self.buckets[hashCode].contains(key):
            self.buckets[hashCode].add(key)
            self.size += 1

    def remove(self, key: int) -> None:
        self.buckets[key % len(self.buckets)].remove(key)

    def contains(self, key: int) -> bool:
        return self.buckets[key % len(self.buckets)].contains(key)
