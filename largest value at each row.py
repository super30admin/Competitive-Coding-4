#// Time Complexity : O(N) 
# // Space Complexity : O(N) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root==None:
            return []

        queue=collections.deque()
        result=[]

        queue.append(root)

        while queue:
            maxElement=float('-inf')
            size=len(queue)
            for i in range(size):
                curr=queue.popleft()
                maxElement=max(curr.val,maxElement)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            result.append(maxElement)
        return result


# Approach:
# 1. We start by initializing an empty list to store the maximum values of each level.
# 2. We use a queue to perform a level-order traversal of the binary tree. We start by
# adding the root node to the queue.
# 3. We then enter a loop that continues until the queue is empty. In each iteration of the
# loop, we keep track of the maximum value encountered at the current level.
# 4. We use a variable `size` to store the number of nodes at the current level.
# 5. We then iterate over the nodes at the current level, popping each node from the queue and
# updating the maximum value if necessary. We also add the left and right children of each node
# to the queue if they exist.
# 6. After processing all nodes at the current level, we append the maximum value to the result
# list.
# 7. Finally, we return the result list, which contains the maximum values of each level in the
# binary tree.