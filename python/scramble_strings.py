# https://leetcode.com/problems/scramble-string/description/
# T: O(n^4) where n is the number of characters in the string
# S: O(n^3) where n is the number of characters in the string

from collections import defaultdict

class Solution:
    def isScramble(self, s1: str, s2: str) -> bool:
        cache = dict()
        return self.helper(s1, s2, cache)
    
    def helper(self, s1: str, s2: str, cache: dict) -> bool:
        key = (s1,s2)
        key_r = (s2,s1)
        if key in cache:
            return cache[key]
        if key_r in cache:
            return cache[key_r]
        # If not cached
        n = len(s1)
        # Base case
        if sorted(s1) != sorted(s2):
            cache[key] = False
            return False
        if n <= 3:
            cache[key] = True
            return True
        # split sting for comparision
        count_s1 = defaultdict(int)
        count_s2 = defaultdict(int)
        count_s2_r = defaultdict(int)
        
        for i in range(1, n):
            count_s1[s1[i-1]] += 1
            count_s2[s2[i-1]] += 1
            count_s2_r[s2[-i]] += 1

            if count_s1 == count_s2:
                cache[key] = self.helper(s1[0:i], s2[0:i], cache) and self.helper(s1[i:n], s2[i:n], cache)
                if cache[key]:
                    return True
            if count_s1 == count_s2_r:
                cache[key] = self.helper(s1[0:i], s2[n-i:n], cache) and self.helper(s1[i:n], s2[0:n-i], cache)
                if cache[key]:
                    return True
        return False
