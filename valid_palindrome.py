# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# I find mid of list. Reverse list from end to mid
# Match each element from original list and new list, if all the elements are equal
# we return True

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head: return True
        
        mid = head
        slow = head
        fast = head.next
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        mid = slow
        
        nHead = self.reverse(mid, None)
        
        while head and nHead:
            if head.val != nHead.val:
                return False
            head = head.next
            nHead = nHead.next
            
        
            
        return True
        
    
    def reverse(self, head, prev):
        if not head.next:
            head.next = prev
            return head
        
        new_head = self.reverse(head.next, head)
        head.next = prev
        return new_head 