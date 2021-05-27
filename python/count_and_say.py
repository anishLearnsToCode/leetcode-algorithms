class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return '1'

        previous = self.countAndSay(n - 1)
        # print('previous', n - 1, previous)
        current = previous[0]
        frequency = 0
        result = ''
        for number in previous:
            if number == current:
                frequency += 1
            else:
                result += f'{frequency}{current}'
                frequency = 1
                current = number
        result += f'{frequency}{current}' if frequency > 0 else ''
        return result
