# Definition for singly-linked list.
 class ListNode:
     def __init__(self, val=0, next=None):
         self.val = val
         self.next = next

# TC : O(n)
# SC : O(1)

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # middle of list
        fast = head 
        slow = head
        
        while fast and fast.next: # not null
            slow = slow.next 
            fast = fast.next.next
        
        mid = slow # middle 
        
        def reverse_list(head):
            prev = None
            curr = head
            nextp = head.next
            
            while (curr and curr.next):
                curr.next = prev
                prev = curr
                curr = nextp
                nextp = nextp.next
            curr.next = prev    
            return curr
        
        new_mid = reverse_list(mid)
        
        
        while (new_mid):
            if new_mid.val == head.val:
                new_mid = new_mid.next
                head = head.next
            else:
                return False
            
        return True
        
            
            
            
            
            
            
