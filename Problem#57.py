'''
110. Balanced Binary Tree
Link: https://leetcode.com/problems/balanced-binary-tree/description/
'''

# Time Complexity : O(n) for traversing the tree
# Space Complexity : O(h) for the recursion stack, where h is the height of the tree
# Did this code successfully run on Leetcode : Yes, it passed all test cases.
# Any problem you faced while coding this : No, the implementation was straightforward using a depth-first search approach.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def dfs(root): # humne ek helper function banaya hai jo balanced aur height dono return karega kyunki balanced hone ke liye height ka difference 1 se zyada nahi hona chahiye(We defined a helper function that returns both balanced status and height because for a tree to be balanced, the height difference should not exceed 1.)
            if not root: # agar root None hai toh balanced hai aur height 0 hai (If the root is None, it is balanced and the height is 0)
                return [True, 0] # hum return karte hain [True, 0] kyunki yeh balanced hai aur height 0 hai (We return [True, 0] because it is balanced and the height is 0)
            
            left = dfs(root.left) # left subtree ka balanced aur height check karte hain recursive call se (We check the balanced status and height of the left subtree using a recursive call)
            right = dfs(root.right) # right subtree ka balanced aur height check karte hain recursive call se (We check the balanced status and height of the right subtree using a recursive call)

            balanced = left[0] and right[0] and abs(left[1] - right[1]) <= 1 # balanced tab hoga jab dono subtrees balanced hon aur unki height ka difference 1 se zyada na ho (The tree is balanced if both subtrees are balanced and the height difference is not more than 1)
            height = 1 + max(left[1], right[1]) # height nikalte hain dono subtrees ki height ka maximum leke aur 1 add karke (We calculate the height by taking the maximum of both subtree heights and adding 1)
            return [balanced, height] # hum return karte hain [balanced, height] (We return [balanced, height])
        return dfs(root)[0] # yeh return karega balanced status as either True ya False (This will return the balanced status as either True or False)
            
            