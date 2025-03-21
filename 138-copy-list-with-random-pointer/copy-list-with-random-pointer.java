/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return head;
        Node temp=head;
        while(temp!=null){
            Node nn=new Node(temp.val);
             nn.next=temp.next;
             temp.next=nn;
              temp=nn.next;
        }
        temp=head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        Node x=new Node(-1);
        Node tt=x;
        temp=head;
        while(temp!=null){
        tt.next=temp.next;
        tt=tt.next;
        temp.next=temp.next.next;
        temp=temp.next;
        }

        return x.next;
    }
}