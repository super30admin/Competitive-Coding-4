# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Brute Force approach is reverse the linked list and store it in array and compare with given current linkedlist.
# To optimize the space, first we need to find the middle element in the list
# Then reverse the second half of the list which includes the middle node in both the lists if the given list is odd since we are setting the end of first list to None
# Then compare the first half value with the second half one by one
# If the value is not equal then return False else return True


class Solution:
    def isPalindrome(self, head: ListNode | None) -> bool:
        if not head or not head.next:
            return True
        
        #find mid
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        #reverse second list
        head2 = slow
        prev = None

        while head2:
            currentNode = head2.next
            head2.next = prev
            prev = head2
            head2 = currentNode

        l1 = head
        l2 = prev

        while l2:
            if l1.val != l2.val:
                return False
            l1 = l1.next
            l2 = l2.next

        return True


        