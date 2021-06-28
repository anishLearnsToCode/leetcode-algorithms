class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split()
        if len(words) != len(pattern):
            return False
        mapping = {}
        used_words = set()
        for character, word in zip(pattern, words):
            if character in mapping:
                if mapping[character] != word:
                    return False
            elif word in used_words:
                return False
            else:
                mapping[character] = word
                used_words.add(word)
        return True


print(Solution().wordPattern('abba', 'dog dog dog dog'))
