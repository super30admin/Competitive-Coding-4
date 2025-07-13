''' 110 Balanced Binary Tree
https://leetcode.com/problems/balanced-binary-tree/

Given a binary tree, determine if it is height-balanced.
A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than 1.


Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true

Solution:
1. Brute Force:
We check three conditions at every node.
a)  left height = height of left subtree + 1,
    right height = height of right subtree + 1, and
    if delta <= 1, where delta = |left height - right height|
    Current node is balanced if delta <= 1, else imbalanced
b)  left subtree is balanced
c)  right subtree is balanced
We return True if all the three conditions are satisfied, i.e.
return (current node is balanced && left subtree is balanced && right subtree is balanced).

We can achieve this by recursion f(root).

Base case:
if root is NULL, return True
if child node, return True
Logic:
Step 0: At every node, compute left height (lht), right height (rht),
       node_balanced = abs(lht - rht) <= 1  # O(H), H = log N
Step 1: left_balanced = f(root.left)
        right_balanced = f(root.right)
Step 2: return left_balanced & right_balanced & node_balanced
Time: O(NH), Space: O(H)

2. Optimal:
The problem with the brute force approach is that at every node,
we are making a new recursive function to compute height from scratch which takes O(H) time. Instead, we could achieve the same thing by simply fetching the
left and right height in O(1) time from the return values of the recursive calls to the left and right subtrees. In other words,
left_balanced, left_height = f(root.left)
right_balanced, right_height = f(root.right)

Accordingly, the base cases should be modified as returning a pair <bool, int> = <balanced, height>.
Base case:
if root is NULL, return True,-1
if child node, return True,0
Time: O(N), Space: O(H)
'''

def isBalanced(root): # O(N), O(H)
    def helper(root):
        # base
        if not root:
            return True, -1 # (is NULL height balanced, height)
        if not root.left and not root.right:
            return True, 0 # (is child height balanced, height)

        # logic
        lbal, lht = helper(root.left)
        rbal, rht = helper(root.right)
        nodebal = abs(lht - rht) <= 1
        ht = 1 + max(lht, rht)
        return (lbal and rbal and nodebal, ht)

    bal, _ = helper(root)
    return bal
