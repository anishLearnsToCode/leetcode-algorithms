# https://leetcode.com/problems/clone-graph/description/
# T: O(n) where n is the number of nodes in the graph
# S: O(n) where n is the number of nodes in the graph

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node: 
            return node
        d = {node.val: Node(node.val, [])}
        q = deque([node])
        while q:
            cur_node = q.pop()
            cur_res = d[cur_node.val]
            for n in cur_node.neighbors:
                if n.val not in d:
                    q.append(n)
                    d[n.val] = Node(n.val, [])
                cur_res.neighbors.append(d[n.val])
        return d[node.val]
