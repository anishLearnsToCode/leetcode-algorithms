class Bucket:
    def __init__(self):
        self.list = []

    def __str__(self):
        return self.list.__str__()

    def contains(self, key: int) -> bool:
        for listKey, value in self.list:
            if key == listKey:
                return True
        return False

    def put(self, key: int, value: int) -> None:
        changed = False
        for index, (listKey, _) in enumerate(self.list):
            if listKey == key:
                self.list[index] = (key, value)
                changed = True
                break
        if not changed:
            self.list.append((key, value))

    def remove(self, key: int) -> None:
        if self.contains(key):
            self.list.remove((key, self.get(key)))

    def get(self, key: int) -> int:
        if self.contains(key):
            for listKey, value in self.list:
                if listKey == key:
                    return value
        return -1


class MyHashMap:

    def __init__(self):
        self.initial_size = 100
        self.buckets = [Bucket() for _ in range(self.initial_size)]

    def _hashCode(self, number: int) -> int:
        return number % len(self.buckets)

    def put(self, key: int, value: int) -> None:
        self.buckets[self._hashCode(key)].put(key, value)

    def get(self, key: int) -> int:
        return self.buckets[self._hashCode(key)].get(key)

    def remove(self, key: int) -> None:
        self.buckets[self._hashCode(key)].remove(key)
