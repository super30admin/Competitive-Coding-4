class ListNode:
    def __init__(self, value=0, next=None):
        self.value = value
        self.next = next

def is_palindrome(head):
    if not head or not head.next:
        return True
    
    # Step 1: Find the middle of the linked list
    slow = fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
    
    # Step 2: Reverse the second half of the linked list
    prev = None
    current = slow
    while current:
        next_node = current.next
        current.next = prev
        prev = current
        current = next_node
    
    # Step 3: Compare the first half and the reversed second half
    first_half = head
    second_half = prev
    while second_half:
        if first_half.value != second_half.value:
            return False
        first_half = first_half.next
        second_half = second_half.next
    
    return True

# Example usage
# Creating a palindrome linked list: 1 -> 2 -> 2 -> 1
head = ListNode(1)
head.next = ListNode(2)
head.next.next = ListNode(2)
head.next.next.next = ListNode(1)

print(is_palindrome(head))  # Output: True

# Creating a non-palindrome linked list: 1 -> 2 -> 3
head = ListNode(1)
head.next = ListNode(2)
head.next.next = ListNode(3)

print(is_palindrome(head))  # Output: False