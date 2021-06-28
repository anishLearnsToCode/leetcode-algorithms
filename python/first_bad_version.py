# The isBadVersion API is already defined for you.
# @param version, an integer
# @return an integer
def isBadVersion(version):
    return None


class Solution:
    def firstBadVersion(self, n: int) -> int:
        """
        :type n: int
        :rtype: int
        """
        left, right = 0, n
        while left <= right:
            middle = left + (right - left) // 2
            if isBadVersion(middle):
                right = middle - 1
            else:
                left = middle + 1
        return left
