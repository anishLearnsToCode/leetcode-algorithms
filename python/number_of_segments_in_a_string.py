class Solution:
    def countSegments(self, s: str) -> int:
        counting, segments = False, 0
        for character in s:
            if counting and character == ' ':
                counting = False
                continue
            if not counting and character != ' ':
                segments += 1
                counting = True
        return segments
