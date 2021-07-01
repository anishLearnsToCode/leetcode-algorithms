from typing import List
from collections import deque


class Solution:
    def compress(self, chars: List[str]) -> int:
        compressed_strings = deque()
        current_char, count,length = chars[0], 0, 0
        for character in chars:
            if character == current_char:
                count += 1
            else:
                compressed_strings.append((current_char, str(count)))
                length += 1 + (len(str(count)) if count > 1 else 0)
                current_char = character
                count = 1
        compressed_strings.append((current_char, str(count)))
        length += 1 + (len(str(count)) if count > 1 else 0)

        i = 0
        for compressed_string in compressed_strings:
            character, count = compressed_string
            chars[i] = character
            if int(count) > 1:
                chars[i + 1:i + 1 + len(count)] = count
            i += 1 + (len(count) if int(count) > 1 else 0)
        return length
