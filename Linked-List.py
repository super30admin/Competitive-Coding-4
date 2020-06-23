# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    #helper function reverse
    def reverse(self,head):
        prev = None
        curr = head
        while curr:
            mynext = curr.next
            curr.next = prev
            prev = curr
            curr = mynext
        return prev
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        #edge case
        if not head or not head.next:
            return True
        fast = head
        slow = head
        #find mid-1
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
        #reverse the mid
        temp = self.reverse(slow.next)
        #make them two separate linked lists
        slow.next = None
        #check if they are palindromes
        while temp and head:
            if temp.val != head.val:
                return False
            temp = temp.next
            head = head.next
        return True