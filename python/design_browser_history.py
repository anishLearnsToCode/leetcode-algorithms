class BrowserHistory:

    def __init__(self, homepage: str):
        self.history = [homepage]
        self.ptr = 0 

    def visit(self, url: str) -> None:
        self.ptr += 1
        self.history = self.history[:self.ptr]
        self.history.append(url)
               
    def back(self, steps: int) -> str:
        self.ptr = max(0, self.ptr - steps)
        return self.history[self.ptr]

    def forward(self, steps: int) -> str:
        self.ptr = min(len(self.history) - 1, self.ptr + steps)
        return self.history[self.ptr]    
