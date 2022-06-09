#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        fast = head
        slow = head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        prev = self.reverse(slow)
        curr = head
        while curr and prev:
            if prev.val!=curr.val:
                return False
            curr = curr.next
            prev = prev.next
        return True
    def reverse(self,slow):
        prev = None
        curr = slow
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev
    
        