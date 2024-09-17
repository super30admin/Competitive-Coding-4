class Solution {
    public boolean isPalindrome(ListNode head) {

         if(head == null ) return true;

         ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        int len = 0;
        int i = 0;
        int flag = 0;
        while(curr!=null){

             len++;
            curr = curr.next;
        }

         if(len == 1 ) return true;
        if(len == 2){

             if(head.val == head.next.val) return true;
            else return false;
        }
        curr = head;


          while(i<len/2 && fast.next != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
             i++;

         }
        if(len % 2 != 0){
            curr = curr.next;
        }

         System.out.println(prev.val);
        System.out.println(curr.val);
        while(curr != null){

             if(prev.val == curr.val){
                curr = curr.next;
                prev = prev.next;

             }
            else{
                return false;
            }
        }


        return true;

     }
} 
