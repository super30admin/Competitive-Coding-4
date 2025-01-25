######### Balanced Binary Tree #######

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# recursively compute the left and right height for a node and based on that the height of the tree is the max between the left and right. 
# If the absolute difference between the two heights is less than or equal to 1 then it is a balancedd tree.

def checkBalanced(root,curr_height):
        if not root:
            return curr_height - 1
        left_height = checkBalanced(root.left, 1+curr_height)
        right_height = checkBalanced(root.right,1+curr_height)
        if left_height == -1 or right_height ==-1:
            return -1
        if abs(left_height-right_height)>1:
            return -1
        return max(left_height,right_height)
    
def isBalanced(root):
        if not root:
            return True
        value = checkBalanced(root, 0)
        if value == -1:
            return False
        else:
            return True
