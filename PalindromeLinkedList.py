# TC: O(N) since we are traversing all the nodes.
# SC: O(1) since we are not using any extra space.


class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        slow = head 
        fast = head
        
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
            
        def reverse(head):
            curr = head
            prev = None
            # nxt = head
            while curr:
                nxt = curr.next
                curr.next = prev
                prev = curr
                curr = nxt            
            return prev
        
        fast = reverse(slow.next)
        slow.next = None
        slow = head
        while slow:
            if slow.next == None and not fast:
                return True
            if slow.val != fast.val:
                return False
            slow = slow.next
            fast = fast.next
        
        return True
