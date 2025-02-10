"""

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []

 
Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100


Time Complexity: O(N) – Each node is visited once in a level-order traversal.
Space Complexity: O(N) – The queue stores at most one level of nodes, and the result list stores all nodes.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""


# The approach uses a queue for level-order traversal while tracking the level of each node. 
# Nodes at odd levels are reversed before appending to the result to achieve the zigzag pattern. 
# This ensures a BFS traversal with alternating left-to-right and right-to-left order at each level.

from queue import Queue


class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        q = Queue()
        q.put((root, 0))

        res = []

        while not q.empty():
            size = q.qsize()
            lst = []
            for _ in range(size):
                ele, level = q.get()
                lst.append(ele.val)
                if ele.left:
                    q.put((ele.left, level+1))
                if ele.right:
                    q.put((ele.right, level+1))

            if level % 2 != 0:
                res.append(lst[::-1])
            else:
                res.append(lst)

        return res

