import bisect

class Solution:
    def getSkyline(self, buildings):
        h = []
        for b in buildings:
            h.append((b[0], -b[2]))
            h.append((b[1], b[2]))
        
        h.sort()
        prev = cur = 0
        m = [0]
        res = []
        
        for i in h:
            if i[1] < 0:
                bisect.insort(m, -i[1])
            else:
                m.remove(i[1])
            cur = max(m)
            if cur != prev:
                res.append([i[0], cur])
                prev = cur
        
        return res
