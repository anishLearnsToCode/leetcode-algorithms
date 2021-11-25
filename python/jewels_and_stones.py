class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        jewelTypes = set(jewels)
        result = 0
        for stone in stones:
            if stone in jewelTypes:
                result += 1
        return result
