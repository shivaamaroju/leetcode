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
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;
        int length = 0;
        while(current != null){
            length++;
            current = current.next;
        }
        int[] arr = new int[length];
        int[] ans = new int[length];
        ListNode temp = head;
        for(int i = 0 ; i < length ; i++){
            arr[i] = temp.val;
            temp = temp.next;
        }

        for(int i = 0 ; i < length ; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                int index = stack.pop();
                ans[index] = arr[i];
            }
            stack.push(i);
        }

        return ans;
    }
}