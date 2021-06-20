def length_last_word(s: str) -> int:
    s = s.strip()
    for index in range(len(s) - 1, -1, -1):
        if s[index] == ' ':
            return len(s) - index - 1
        return len(s)


print(length_last_word(input()))
