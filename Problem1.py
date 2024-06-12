#Time complexity: O(n)
#Space complexity: O(n)
#Works on leetcode: yes
#Approach: Here the idea is to recursively check if the left and right children's height differ more than 1, if yes return 
# -1 else return 1+max(height of left, height of right). Finally check if we get -1 or not. 
class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def check(root):
            if root is None:
                return 0
            l = check(root.left)
            r = check(root.right)
            if l==-1 or r==-1 or abs(l-r)>1:
                return -1
            return 1+max(l,r)
        return check(root)!=-1
        