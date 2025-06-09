#Time Complexity: O(N)
#Space Complexity: O(1)

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: bool
        """

        if head is None or head.next is None:
            return True
        
        #1. Find the midle Node
        slow = head
        fast = head
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        #Reversing the Linked List
        prev = None
        cur = slow 
        while cur is not None:
            next_node = cur.next
            cur.next = prev
            prev = cur
            cur = next_node

        #Check for Palindrome
        p1 = head
        p2 = prev
        while p2 is not None:
            if p1.val != p2.val:
                return False
            p1 = p1.next
            p2 = p2.next
        
        return True

        
        