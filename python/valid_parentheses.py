class Solution:
    def __init__(self):
        self.openBrackets = {
            '(', '{', '['
        }

        self.inverse = {
            ')': '(',
            '}': '{',
            ']': '['
        }

    def isValid(self, string: str) -> bool:
        brackets = []
        for character in string:
            if self.isOpenBracket(character):
                brackets.append(character)
            elif len(brackets) != 0 and brackets[-1] == self.inverse[character]:
                brackets.pop()
            else:
                return False

        return len(brackets) == 0

    def isOpenBracket(self, character: str) -> bool:
        return character in self.openBrackets


sol = Solution()
print(sol.isValid('()()(())({[]})'))
