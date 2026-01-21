''' Time Complexity : O(n) 
    Space Complexity : O(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : 1. Find Middle
              2. Reverse second half
              3. compare 2 linked lists
'''

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow, fast = head, head
        #find middle
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        #reverse second part
        prev = None
        curr = slow.next
        while curr is not None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        p1 = head
        p2 = prev

        while p1 is not None and p2 is not None:
            if p1.val != p2.val: 
                return False
            p1 = p1.next
            p2 = p2.next
            
        return True