# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    # TC: O(N)
    # SC: O(1)
    
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        
        if (head.next == None):
            return True
        
        slow = head
        fast = head
        
        # Mid Of LL
        while (fast.next is not None and fast.next.next is not None):
            fast = fast.next.next
            slow = slow.next
        
        # Reverse Second part of LL
        head2 = self.reverse(slow.next)
        
        # Break the Connection
        slow.next = None
        head1 = head
        
        # Compare
        while (head1 != None and head2 != None):
            if (head1.val != head2.val):
                return False
            
            head1 = head1.next
            head2 = head2.next
            
        return True
        
    
    def reverse(self, head):
        
        prev = None
        curr = head
        nxt = head.next
        
        while(curr != None):
            curr.next = prev
            prev = curr
            curr = nxt
            if (nxt != None):
                nxt = nxt.next
                
        return prev