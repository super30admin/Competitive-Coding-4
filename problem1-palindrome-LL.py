'''https://leetcode.com/problems/palindrome-linked-list/
'''

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# Time Complexity : O(N) all operations
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head is None or head.next is None: return True
        
        # Find second half
        s = head
        f = head
        while f.next is not None and f.next.next is not None:
            s = s.next
            f = f.next.next
        
        # p is head of second half
        p = s.next
        s.next = None
        
        
        # reverse second half
        prev = None
        curr = p
        nxt = p.next
        
        # <-1<-2<-[c]3 
        while curr.next is not None:
            curr.next = prev
            prev = curr
            curr = nxt
            nxt = nxt.next
        curr.next = prev
        
        first = head
        while curr is not None:
            if curr.val != first.val:
                return False
            curr = curr.next
            first = first.next
        
        return True
    
