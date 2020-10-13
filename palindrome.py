// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution:
    def reverse(self, head: ListNode) -> ListNode:
        prev_node = None
        
        while head:
            next_node = head.next
            head.next = prev_node
            prev_node = head
            head = next_node
            
        return prev_node
        
    def isPalindrome(self, head: ListNode) -> bool:
        fast = slow = head
        
        while fast != None and fast.next != None:
            fast = fast.next.next
            slow = slow.next
        
        fast = head
        slow = self.reverse(slow)
        
        while slow != None:
            if slow.val != fast.val:
                return False
                
            fast = fast.next
            slow = slow.next
        
        return True
        