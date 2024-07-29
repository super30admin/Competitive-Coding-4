# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from queue import Queue

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        # If the tree is empty, return an empty list.
        if root is None:
            return []
        
        # Initialize the queue and result list.
        q = Queue()
        q.put(root)
        result = []
        
        # Perform level order traversal (BFS).
        while not q.empty():
            Max = float("-inf")  # Initialize the maximum value for the current level.
            size = q.qsize()  # Number of nodes at the current level.
            
            for i in range(size):
                curr = q.get()  # Get the next node from the queue.
                
                # Update the maximum value for the current level.
                Max = max(Max, curr.val)
                
                # Add the left child to the queue if it exists.
                if curr.left != None:
                    q.put(curr.left)
                
                # Add the right child to the queue if it exists.
                if curr.right != None:
                    q.put(curr.right)
            
            # Append the maximum value of the current level to the result list.
            result.append(Max)
        
        return result

# The time complexity of this algorithm is O(n)
# The space complexity is O(n/2) = O(n)
