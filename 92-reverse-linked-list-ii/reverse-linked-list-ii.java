class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int c=1;
ListNode x=new ListNode(-1);
ListNode y=x;
        while(c<left){
    int n=head.val;
y.next=new ListNode(n);
y=y.next;
head=head.next;
c++;
        }
        ListNode rev=reverse(head,right-left+1);

y.next=rev;

        return x.next;
    }
    public ListNode reverse(ListNode head,int c){
        int cc=1;
        ListNode prev=null,next=null,cur=head;
        while(cc<=c){
            next=cur.next;
           cur.next=prev;
           prev=cur;
            cur=next;
            cc++;
        }
        ListNode x=new ListNode(-1);
        ListNode y=x;
        ListNode z=prev;
        while(z!=null){
y.next=z;
y=y.next;
z=z.next;


        }
        y.next=cur;

        return x.next;
    }
}