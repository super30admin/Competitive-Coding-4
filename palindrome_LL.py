"""
Time Complexity : O(n) where n is the number of nodes of a linked list
Space Complexity : O(1) no auxillary data structure is use
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
The idea is to break the linked list into two linked list and check if the values of the two linked list are same or not.
If they are same the given linked list is a palindrome otherwise not.
This can be solved in three steps:
1. First find the mid of the Linked List
2. Reverse the Linked List from slow.next
3. Check if every elements'v value of two linked List is same
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self, head):
        prev = None
        curr = head
        fast = head.next
        
        while(fast != None):
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        
        return curr
        
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head == None or head.next == None:
            return head
        
        slow = head
        fast = head
        #Find the mid
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
            
        #Reverse the List from slow.next
        fast = self.reverse(slow.next)
        
        slow.next = None
        
        slow = head
        
        while(slow != None and fast != None):
            if slow.val != fast.val:
                return False
            slow = slow.next
            fast = fast.next
        
        return True
            
            