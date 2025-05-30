package Algorithms;

public class LinkedList {

    public class ListNode{

        public ListNode(ListNode next, int val) {
            this.next = next;
            this.val = val;
        }

        ListNode next;
        int val;
        public ListNode(){}
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val , ListNode next){
            this.val = val;
            this.next = next;

        }
    }
}
