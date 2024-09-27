class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode prev = head;
        ListNode cur = head.next.next; 
        
        int count =0;
        while(prev!=null){
           count++; 
            prev = prev.next;
        }
        int mid=count/2;
        cur = head;
        ListNode midPointer= null;
        count =0;
        while(cur!=null){
            
            if(count==mid) midPointer= cur;
            if(count>mid){
                ListNode followUp= cur.next;
                cur.next= prev;
                prev= cur;
                cur= followUp;   
            }else{
                cur=cur.next;
            }
            count++;
        }
        count=0;
            ListNode fp = head;
            ListNode sp = midPointer;
        while(count<mid){
          count++;
            if(fp.val!=sp.val) return false;
             fp = fp.next;
             sp = midPointer.next;
        }
    return true;
        
    }
}
