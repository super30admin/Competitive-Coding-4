#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 234: Palindrome Linked List
    Link: https://leetcode.com/problems/palindrome-linked-list/

    Problem:
    Given the head of a singly linked list, return true if it is a palindrome
    or false otherwise.

    Approach:
    Two-pointer + in-place reversal. Find the midpoint with slow/fast pointers,
    reverse the second half in-place, then compare both halves from the outside in.

    1️⃣ Use slow/fast pointers to find the midpoint (slow lands at start of second half).
    2️⃣ Reverse the second half in-place using prev/curr pointers.
    3️⃣ Walk both head and the reversed second half together, comparing values.
    4️⃣ If any values differ → return False; otherwise return True.

    // Time Complexity : O(n)
        One pass to find midpoint, one pass to reverse, one pass to compare.
    // Space Complexity : O(1)
        In-place reversal; no extra data structures used.

"""

from typing import Optional

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        prev, curr = None, slow

        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt

        while prev and head:
            if prev.val != head.val:
                return False
            head = head.next
            prev = prev.next

        return True
