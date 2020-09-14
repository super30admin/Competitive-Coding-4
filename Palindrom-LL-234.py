# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# 1. Get middle and reverse the list from there and check the value of the first and the second list

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head is None or head.next is None:
            return True
        def reverse(node):
            curr = node
            prev = None
            while curr:
                new = curr.next
                curr.next = prev
                prev = curr
                curr = new
            return prev
        
        slow = fast = head
        
        while fast and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        
    
        temp2 = reverse(slow)
        slow.next = None
        temp1 = head
       
        while temp2:
            if temp1.val == temp2.val:
                temp1 = temp1.next
                temp2 = temp2.next
            else:
                return False
        return True
        