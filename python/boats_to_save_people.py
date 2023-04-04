# https://leetcode.com/problems/boats-to-save-people/description/
# T: O(nlogn) where n is the length of people
# S: O(logn) for sorting

class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        left, right, ans = 0, len(people) - 1, 0
        while left <= right:
            ans += 1
            if people[left] + people[right] <= limit:
                left+=1
            right-=1
        return ans
