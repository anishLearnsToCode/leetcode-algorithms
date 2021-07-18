from typing import List


class Solution:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        if r * c != len(mat) * len(mat[0]) or (r == len(mat) and c == len(mat[0])): return mat
        result = [[0] * c for _ in range(r)]
        k = 0
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                result[k // c][k % c] = mat[i][j]
                k += 1
        return result
