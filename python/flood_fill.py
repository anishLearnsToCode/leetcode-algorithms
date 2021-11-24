from typing import List


class Solution:

    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        self.image = image
        self.height = len(image)
        self.width = len(image[0])
        self.newColor = newColor
        if image[sr][sc] != newColor:
            self.oldColor = image[sr][sc]
            self.colorPixel(row=sr, column=sc)
        return image

    def colorPixel(self, row: int, column: int) -> None:
        if self.image[row][column] != self.newColor:
            self.image[row][column] = self.newColor
            if row - 1 >= 0 and self.image[row - 1][column] == self.oldColor: self.colorPixel(row - 1, column)
            if column + 1 < self.width and self.image[row][column + 1] == self.oldColor: self.colorPixel(row, column + 1)
            if row + 1 < self.height and self.image[row + 1][column] == self.oldColor: self.colorPixel(row + 1, column)
            if column - 1 >= 0 and self.image[row][column - 1] == self.oldColor: self.colorPixel(row, column - 1)
