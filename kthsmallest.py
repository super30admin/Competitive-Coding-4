# Time complexity: O(N)
# Space complexity: O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    ctr = 0
    flag = False
    ans = -1
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        #self.inorder(root, k)
        self.iterative(root, k)
        return self.ans
    
    def iterative(self, root, k):
        
        st = []
        
        while root or st:
            while root:
                st.append(root)
                root = root.left
            root = st.pop()
            self.ctr += 1
            if self.ctr == k:
                self.ans = root.val
            root = root.right
            
        
    def inorder(self, root, k):

        if not root:
            return None

        self.inorder(root.left, k)
        self.ctr += 1
        if self.ctr == k:
            self.ans = root.val
            return
        self.inorder(root.right, k)
