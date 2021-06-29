import re


class Solution:
    def __init__(self):
        self.vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}

    def is_vowel(self, character: str) -> bool:
        return character in self.vowels

    def index_in_range(self, l: iter, index: int) -> bool:
        return 0 <= index < len(l)

    # 2 pointer approach
    # def reverseVowels(self, s: str) -> str:
    #     characters = [character for character in s]
    #     left, right = 0, len(characters) - 1
    #     while left < right:
    #         while left < right and not self.is_vowel(s[left]):
    #             left += 1
    #         while left < right and not self.is_vowel(s[right]):
    #             right -= 1
    #         if left < right:
    #             characters[left], characters[right] = characters[right], characters[left]
    #             left += 1
    #             right -= 1
    #     return ''.join(characters)

    # faster method
    def reverseVowels(self, s):
        vowels = re.findall('(?i)[aeiou]', s)
        return re.sub('(?i)[aeiou]', lambda m: vowels.pop(), s)

print(Solution().reverseVowels('aA'))
