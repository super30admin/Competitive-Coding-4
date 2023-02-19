# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


#All TC on leetcode passed

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:

        #Here we divide the list into 2 halves. The second half of L.L. is reversed. Then we traverse both lists and check if elements are equal.
        #Time complexity - O(N)
        #Space complexity - O(1)
        slow = head
        fast = head

        #finding the mid point
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        
        cur = slow

        #reversing the list after mid point
        prev = None
        while cur:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp

        #traversing the 2 lists and checking if elements are equal
        first = head
        second = prev
        while second:
            if first.val!=second.val:
                return False
            first = first.next
            second = second.next
        return True