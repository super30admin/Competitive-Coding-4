# Height Balanced Binary Tree
#  tC = O(n) : n is number of nodes
# sc = O(n) 

class Solution:
    def isBalanced(self, root):
        
        def dfs(node):
            if not node: return [True, 0]
            
            left, right = dfs(node.left), dfs(node.right)
            balanced = abs(left[1]-right[1]) <= 1 and left[0] and right[0]

            return [balanced, 1+max(left[1], right[1])]

        return dfs(root)[0]
