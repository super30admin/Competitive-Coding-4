#TC&SC:O(N)

def isPalindrome(self, head):
    self.fp = head
    def recursively_check(current_node=head):
        if current_node is not None:
            if not recursively_check(current_node.next):
                return False
            if self.fp.val != current_node.val:
                return False
            self.fp = self.fp.next
        return True

    return recursively_check()