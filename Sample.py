# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    
    """
    Description: Given a singly linked list, determine if it is a palindrome?
    
    Time Complexicity: O(n), n -> number of items in given linked-list
    Space Complexicity: O(n) {I think because I am creating another linked-list (mirror)}
    
    Approach:
    1. find the middle node using 2-pointers
    2. create another linked-list by reversing the list found after middle (slow pointer)
    3. match values from the original half and newly created linked-list to check palindrome
    
    """
    
    def isPalindrome(self, head: ListNode) -> bool:
        
        if head == None: return True
        slow = head; fast = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            
        mirror = slow
        mirror = self.reverse(mirror)
        
        while mirror:
            if mirror.val != head.val:
                return False
            mirror = mirror.next
            head = head.next
            
        return True

    # Function to get reverse linked list
    def reverse(self, head):
        prev = None
        while head:
            temp = head
            head = head.next
            temp.next = prev
            prev = temp
        
        return prev

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    """
    Description: Given a binary tree, determine if it is height-balanced.
    
    Time Complexicity: O(n), n -> number of items in the given tree
    Space Complexicity: O(1)
    
    Approach:
    
    1. Define a function height to find height of each subtree (use recursively)
    2. check each left and right roots have consistently difference of heights <= 1 (recursively)
    
    """
    
    def isBalanced(self, root: TreeNode) -> bool:
        
        if root == None: return True
        
        return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(self.height(root.left) - self.height(root.right)) <= 1
        
    def height(self, root):

        """
        Function to get maximum height of the subtree (recursively)
        """

        if root == None: return 0
        else:
            return max(self.height(root.left), self.height(root.right)) + 1
