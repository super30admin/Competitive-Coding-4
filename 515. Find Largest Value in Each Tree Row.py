#BFS 
# TC - O(n) & SC - O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root == None :
            return []
        res = []
        q = deque([root])
        
        while q:
            lrg = - math.inf
            for _ in range(len(q)):
                top = q.popleft()
                if top.val > lrg:
                    lrg = top.val
                #lrg = max(lrg,top.val)
                if top.left:
                    q.append(top.left)
                if top.right:
                    q.append(top.right)
            res.append(lrg)
        return res