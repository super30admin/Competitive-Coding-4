"""Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No"""


# Definition for singly-linked list.
class Node:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
"""Approach - > find the middle node. from middle node to last reverse the linkedlist. Now with 
2 pointers one starting from start another from start of next list check if they are equal"""
class Solution:
    def isPalindrome(self, head: Node) -> bool:
        #find mid element
        slow = head
        fast = head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
         
        headnew = slow.next
        temp = None
        prev = None
        
        cur = headnew
        
        while cur:
            temp = cur.next
            cur.next =prev
            prev = cur
            cur = temp
        
        headnew = prev
        
        while head and headnew:
            if not (head.val==headnew.val):
                return False
            head = head.next
            headnew=headnew.next
            
            
        return True

# Driver code
llist = Solution() 
head = Node(1) 
head.next = Node(2)
head.next.next = Node(1)  
 
if llist.isPalindrome(head):
    print("Linked List is a palindrome.")
else:
    print("Linked List is not a palindrome.")
 

