class Trienode:
    def __init__(self):
        self.children = {}
        self.word = False

class WordDictionary:

    def __init__(self):
        self.root = Trienode()
        

    def addWord(self, word: str) -> None:
        ptr = self.root
        for ch in word:
            if ch not in ptr.children:
                ptr.children[ch] = Trienode()
            ptr = ptr.children[ch]
        ptr.word = True
        

    def search(self, word: str) -> bool:
        def dfs(j, root):
            curr = root
            for i in range(j, len(word)):
                ch = word[i]
                if ch == ".":
                    for child in curr.children.values():
                        if dfs(i+1, child):
                            return True
                    return False
                else:
                    if ch not in curr.children:
                        return False
                    curr = curr.children[ch]
            return curr.word
        return dfs(0, self.root)

