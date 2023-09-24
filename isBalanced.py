# Time Complexity: O(n)
# Space Complexity: O(h)

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def helper(root):
            if root is None:
                return [True, 0]
            left = helper(root.left)
            right = helper(root.right)

            checkBalanced = ((left[0] and right[0]) and abs(left[1]-right[1]) < 2)
            #print (checkBalanced)
            return (checkBalanced, 1+max(left[1],right[1]))
        return helper(root)[0]
