# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    """
    Time Complexity: O(n)
    Space Complexity: O(h)

    Approach:
        - Initially we find the mid-point of the linked-list
        - we do it using fast pointer
        - once we find the mid-point. we want to reverse the rest of the linked list
        - once we reverse the second-half of the list
        - we want to check the reversed list with the first half of the list
            - if node value is not equal to reversed node value then return False
            - we move the the head to the next and res to the next and check again 
        - if all node are same return True
    """
    def __init__(self):
        self.head1 = None
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
    # Recursion Method
        slow = head
        fast = head
        while (fast != None and fast.next != None):
            slow = slow.next
            fast = fast.next.next
        curr = slow

        res = self.reverse(curr)
        while res is not None:
            if (head.val != res.val):
                return False
            head = head.next
            res = res.next
        return True
            
    def reverse(self, curr):
        if curr == None or curr.next == None:
            return curr
        result = self.reverse(curr.next)
        curr.next.next = curr
        curr.next = None
        return result

    # #   Iterative Method
    #     slow = head
    #     fast = head
    #     while (fast != None and fast.next != None):
    #         slow = slow.next
    #         fast = fast.next.next
    
    #     prev = None
    #     curr = slow
    #     front = curr.next
    #     while (front is not None):
    #         curr.next = prev
    #         prev = curr
    #         curr = front
    #         front = front.next
    #     curr.next = prev

    #     while curr is not None:
    #         if (head.val != curr.val):
    #             return False
    #         head = head.next
    #         curr = curr.next
    #     return True
            