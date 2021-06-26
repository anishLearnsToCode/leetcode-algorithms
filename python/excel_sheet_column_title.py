class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        column_title = ''
        while columnNumber > 0:
            columnNumber, digit = divmod(columnNumber - 1, 26)
            column_title = chr(digit + 65) + column_title
        return column_title
