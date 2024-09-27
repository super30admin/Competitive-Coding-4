# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        
        # Reverse List
        def reverse_list(head):
            prev = None            
            curr = head
            
            while curr:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp
                
            return prev
        
        if not head:
            return True
        
        ### Find Midpoint
        slow, fast = head, head
        
        while fast.next and fast.next.next:
            slow, fast = slow.next, fast.next.next
        
        mid_pointer = slow.next
        slow.next = None
        
        ### Reverse the second half of the list
        pointer_1 = head
        pointer_2 = reverse_list(mid_pointer)

        ### Traverse both the lists till either list reaches end or we find unequal elements
        while pointer_1 and pointer_2:
            if pointer_1.val != pointer_2.val:
                return False
            pointer_1, pointer_2 = pointer_1.next, pointer_2.next
            
        return True
    
### Complexity Analysis

# Time Complexity: O(N) --> Traversing entire list
# Space Complexity: O(1) --> Constant space since only pointers are used