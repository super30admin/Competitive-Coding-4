# TC = O(n)
# SC = O(n) stack size
# If we iterate the nodes in reverse using recursion, and iterate forward at the same time using global var and check for palindrome

class Solution:
    def isPalindrome(self, head) -> bool:
        if head == None:
            return True
        self.low = head
        return self.helper(head)

    def helper(self, head):
        if head != None:
            if not self.helper(head.next):
                return False

            if (head.val != self.low.val):
                return False

            self.low = self.low.next
        return True