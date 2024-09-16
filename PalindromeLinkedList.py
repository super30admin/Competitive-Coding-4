
# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Two pointers


# // Your code here along with comments explaining your approach

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head == None:
            return True
        
        slow = head
        fast = head.next
        while(fast != None and fast.next != None):
            fast = fast.next.next
            slow = slow.next
            
            
        head2 = slow.next
        slow.next = None
        
        # Reverse the list 2
        prev = None
        curr = head2
        fast = ListNode()
        while(curr != None):
            fast = curr.next
            curr.next = prev
            prev = curr
            curr = fast      
        head2 = prev
        
        #check from both lists
        while (head!= None and head2 != None):
            
            if(head.val != head2.val):
                return False
            else:
                head = head.next
                head2 = head2.next
        
        return True
            
        
        
        
        