# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #Solution 1
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        #Approach: Recursive
        #Time Complexity: O(n)
        #Space Complexity: O(h) #under the hood

        self.k = k
        self.result = None
        self.kthSmallestHelper(root, k)
        
        return self.result.val
    
    def kthSmallestHelper(self, root, k):
        #base
        if not root:
            return
        
        #logic
        self.kthSmallestHelper(root.left, k)
        self.k -= 1
        
        if self.k == 0:
            self.result = root
            return
        
        self.kthSmallestHelper(root.right, k)
    
    #Solution 2
    """
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        #Approach: Iterative
        #Time Complexity: O(n)
        #Space Complexity: O(h)
        
        st = []
        count = 0
        while root or st:
            while root:
                st.append(root)
                root = root.left
            root = st.pop()
            
            count += 1
            if count == k:
                return root.val
            
            root = root.right
    """