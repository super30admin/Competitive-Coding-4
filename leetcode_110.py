#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 110: Balanced Binary Tree
    Link: https://leetcode.com/problems/balanced-binary-tree/

    Problem:
    Given a binary tree, determine if it is height-balanced.
    A height-balanced binary tree is a binary tree in which the depth of the two
    subtrees of every node never differs by more than one.

    Approach:
    Post-order DFS. Return the height of each subtree, or -1 as a sentinel
    value if that subtree is unbalanced. This allows early termination and
    avoids recomputing heights.

    1️⃣ Base case: empty node returns height 0.
    2️⃣ Recurse left; if -1 propagate immediately (already unbalanced).
    3️⃣ Recurse right; if -1 propagate immediately.
    4️⃣ If abs(left - right) <= 1 → return max(left, right) + 1 (height).
    5️⃣ Otherwise return -1 (unbalanced sentinel).
    6️⃣ isBalanced checks if the final result is -1.

    // Time Complexity : O(n)
        Every node is visited once.
    // Space Complexity : O(h)
        Recursive call stack depth equals the height of the tree.

"""

from typing import Optional

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def checkBalanceOfTree(self, root):
        if not root:
            return 0

        leftTree = self.checkBalanceOfTree(root.left)
        if leftTree == -1:
            return -1

        rightTree = self.checkBalanceOfTree(root.right)
        if rightTree == -1:
            return -1

        if abs(rightTree - leftTree) <= 1:
            return max(leftTree, rightTree) + 1
        else:
            return -1

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        result = self.checkBalanceOfTree(root)
        if result == -1:
            return False
        return True
