class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        boolean flag=true;
        ListNode sl=head;
        ListNode fp=head;
        ListNode prev=null;
        
        while(fp!=null && fp.next!=null){
            prev=sl;
            sl=sl.next;
            fp=fp.next.next;
        }
        System.out.println(fp);
        System.out.println(sl.val);
        fp=reverse(sl);
        sl=head;
        prev.next=null;
        System.out.println(fp);
        System.out.println(sl.val);
        while(sl!=null){
            if(sl.val!=fp.val){
                flag=false;
                break;
            }
            sl=sl.next;
            fp=fp.next;
        }
        return flag;
    }
    private static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode nxt=head.next;
        
        while(nxt!=null){
            curr.next=prev;
            prev=curr;
            curr=nxt;
            nxt=nxt.next;
        }
        curr.next=prev;
        return curr;
    }
    
}
