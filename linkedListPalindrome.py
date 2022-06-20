"""
Approach: Find mid of the list, reverse second half and check if both lists are equal node by node.

TC: O(n) We are required to traverse the list completely at least 1 time to find mid and 2nd time to reverse and check 2 halves are same.
SC: O(1) We are reversing linked list 2nd half in place 
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # None check
        if not head:
            return False
        
        # find mid
        p1, p2 = head, head
        
        while p2.next:
            p2 = p2.next
            if p2.next:
                p1 = p1.next
                p2 = p2.next
        # p1 is at mid point
        # Now if p1 has next that is not None, meaning its not at end of the list
        # then run the algorithm to break 2nd half of the list and reverse it
        if p1.next:
            p2 = p1.next
            p3 = p2.next
            p1.next = None
            p1 = None
            while p3:
                p2.next = p1
                p1 = p2
                p2 = p3
                p3 = p3.next
            p2.next = p1
            # once reverse is complete, set p1 back to head of the 1st list
            # while p2 is already at head of 2nd list
            # now move each of them 1 step, and keep checking if their values are matching
            # if not, return False, if we makde it out of the loop, assume everything was well
            # and return True
            p1 = head
            while p1 and p2:
                if p1.val != p2.val:
                    return False
                p1 = p1.next
                p2 = p2.next
            return True
        # if we didn't go in if, that means list was 1 element so assume True
        return True


"""Approach: Recursive
We push each node in the list in recursive stack until next node is not None. We maintain global ptr p1 pointing to head 
of the linkedlist. And when recursion reaches last node, we check if that node has same value as first node p1 is pointing to
and return boolean. As the recusion stack unwinds, we move the p1 one step forward and keep checking if previous result was True and 
current head and p1 are pointing to same value.
TC O(n)
SC O(n) for recursive stack
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    p1 = None
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        self.p1 = head
        return self.helper(head)
    
    def helper(self, head) -> bool:
        # base 
        if not head.next:
            return self.p1.val == head.val
        
        """Another way you can add the logic is:
          # logic
        r = self.helper(head.next)
        if not r:
            return False
        self.p1 = self.p1.next
        
        return self.p1.val == head.val"""
        # logic
        r = self.helper(head.next)
        self.p1 = self.p1.next
        
        return r and self.p1.val == head.val
        
