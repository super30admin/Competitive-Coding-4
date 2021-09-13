import java.util.ArrayList;

class palindromeLL {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        List<Integer> elements = new ArrayList<>();
        int start, end;
        
        
        elements.add(head.val);
        while(head.next != null) {
            head = head.next;
            elements.add(head.val);
        }
        
        //Once the array is made, we will check if the elements match from start and end, end-- == start++
        
        start = 0;
        end = elements.size() - 1;
        
        //terminate when the pointers cross
        while(start < end) {
            if(elements.get(start) != elements.get(end))
                return false;
            start++;
            end--;
        }
        
        return true;

    }
}