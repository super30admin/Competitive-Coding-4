
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    # tc : O(n)
    # sc : O(1)
    def isPalindrome(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: bool
        """
        # intution
        # compare the first and last pointer, second and last but one and so on..
        # tick part like in arrays or lists i cant travel from tail to prev pointer to check
        # so will reverse the list and verify the current linked list and reverse linke dlist
        # to optimize : instead of reversing the whoe list, i can split the current list into two parts
        # first_half = head to mid, second_half = mid.next to last 
        # reverse the second half and compare 

        # find mid
        mid = self.middle(head)
        nextnode = mid.next
        mid.next = None

        # reversing the second half 
        second_half = self.reverse(nextnode)
        flag = True
        first_half = head

        # compare the first half and second half lists 
        while second_half is not None : # tc: O(n/2)
            if second_half.val != first_half.val:
                flag = False
            second_half = second_half.next
            first_half = first_half.next

        return flag

    def middle(self, head): # tc :O(n/2)
        slow = head
        fast = head

        while (fast.next is not None and fast.next.next is not None):
            slow = slow.next
            fast = fast.next.next

        return slow

    def reverse(self, head): # tc: O(n/2)
        curr = head
        prev = None

        while curr is not None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        return prev 

