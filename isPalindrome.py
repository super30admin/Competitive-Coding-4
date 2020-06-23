#234. Palindrome Linked List
# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head:
            return True
        slow = head
        fast = head
        Flag = 
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        new = slow.next
        slow.next = None
        curr = ListNode()
        curr = self.reverse(new)
        slow = head
        while slow and curr:
            if slow.val == curr.val:
                Flag = True
                slow = slow.next
                curr = curr.next
            else:
                Flag = False
                break
        if Flag:
            return True
        else:
            return False
    def reverse(self,root):
        prev = None
        curr = root
        
        while curr:
            nexxt = curr.next
            curr.next = prev
            prev = curr
            curr = nexxt
            
        
        return prev