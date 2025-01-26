# Time Complexity : O(n), n is no of nodes in the given list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# using two pointers - fast and slow
# 3 main steps - divide the list in 2 halves - first and second
# to find the mid of the list, fast will move by 2 nodes, slow will move by 1 node, after fast reaches the end, the slow will be at mid
# after finding the mid element, from the next of mid, the second list will start
# then we have to reverse the seconf half of the list, using two pointers - current and prev
# then the head of the first list is head, and the head of the seconf list is prev (because current becomes none)
# then we have to compare the values of all nodes in the first list and the second list
# since there can be unequal members because of odd/even difference,  we will loop on the length of the second half of the list
# and for odd no of elements, both lists will go through the same mid node, which is fine

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution(object):
    def __init__(self):
        self.ispalindrome = True

    def isPalindrome(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: bool
        """
        if head is None or head.next is None:
            return True

        # mid of the LL
        slow = head
        fast = head

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        # slow is at the mid element
        mid = slow

        # reverse the second half
        current = mid
        prev = None

        while(current is not None):
            temp = current.next
            current.next = prev
            prev = current
            current = temp

        first  = head
        second = prev

        while(second is not None):
            if first.val != second.val:
                self.ispalindrome = False
                return self.ispalindrome

            first = first.next
            second = second.next
        

        return self.ispalindrome


