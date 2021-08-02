class Solution:
    def judgeCircle(self, moves: str) -> bool:
        vertical, horizontal = 0, 0
        for move in moves:
            if move == 'U': vertical += 1
            elif move == 'D': vertical -= 1
            elif move == 'R': horizontal += 1
            elif move == 'L': horizontal -= 1
        return vertical == 0 and horizontal == 0
