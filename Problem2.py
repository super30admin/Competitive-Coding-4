#Time complexity: O(n)
#Space complexity: O(1)
#Works on leetcode: yes
#Approach: The idea here is to find the middle of the linked list and then reverse the second half of the linked list.
#After that, start traversing and comparing the first half and second half of the linked list. If any value is unequal, 
#the linked list is a palindrome. 
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head or not head.next:
            return True
        slow = head
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        slow = slow.next
        slow = self.rev(slow)
        while slow:
            if slow.val!=head.val:
                return False
            slow=slow.next
            head=head.next
        return True
    
    def rev(self,head):
        if not head:
            return head
        prev = None
        cur = head
        while cur:
            n = cur.next
            cur.next = prev
            prev = cur
            cur = n
        return prev