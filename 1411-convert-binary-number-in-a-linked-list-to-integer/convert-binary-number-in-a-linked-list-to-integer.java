/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        if(head==null)return 0;
        ListNode temp=head;
        String s="";
        while(temp!=null){
            s=s+temp.val;
            temp=temp.next;
        }
        return Integer.parseInt(s,2);
    }
}