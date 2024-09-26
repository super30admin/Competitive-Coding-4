"""
FAANMG Problem #59 {Easy}

173. Binary Search Tree Iterator

Time Complexity : O(N)


Space Complexity : O(1)


Did this code successfully run on Leetcode : Yes
  


// First find out the middle element in the list
// reverse the other half of the list
// Iterate both the list to check if it is palinrodme or not

@name: Rahul Govindkumar_RN27JUL2022
"""


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        
        # function to reverse the list
        def reverse(head):
            prev = None
            curr = head
            fast = head.next

            while(fast):
                curr.next =prev
                prev = curr
                curr = fast
                fast = fast.next
            curr.next=prev
            return curr
        
        
        
        if (head.next is None):
            return True
            
        slow = head
        fast = head
        
        while(fast.next is not None and fast.next.next is not None ):
            slow = slow.next
            fast = fast.next.next
            
        head2 = reverse(slow.next)
        
        #Check if the two LL value is same
        while(head2):
            
            if(head.val != head2.val):
                return False
            head= head.next
            head2 = head2.next
            
        return True
            