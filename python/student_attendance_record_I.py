class Solution:
    def checkRecord(self, s: str) -> bool:
        consecutiveLate, absent = 0, 0
        for character in s:
            if character == 'L':
                consecutiveLate += 1
            else:
                if character == 'A': absent += 1
                consecutiveLate = 0
            if consecutiveLate >= 3 or absent >= 2: return False
        return True
