#Time Complexity O(N)
#Space Complexity O(1)
#It successfully runs on leetcode

#Approach: we can just copy in array list and reverse and check it with original but it will be O(N) space and O(N) time
# so rather as we know in palindrom from midpoint every elements on left is same as  reversed rigth hand side, so with that intution
# we will first find MIDDLE, then will REVERSE from middle to end of list, and we will check from head and reverse, whether value matches or not
#if not will return False otherwise True

class Solution:

    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head
        while fast and fast.next:
            slow= slow.next
            fast = fast.next.next
        prev = None
        while slow:
            slow.next, prev, slow = prev, slow,slow.next
        l,r = head, prev
        while r:
            if r.val!=l.val:
                return False
            r= r.next
            l= l.next
        return True