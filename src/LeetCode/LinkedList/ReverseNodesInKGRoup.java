package LeetCode.LinkedList;

public class ReverseNodesInKGRoup {


    public static void main(String args[]){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 3;
        ListNode head1 = reverseKGroup(head,k);
        printList(head1);

    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }




        public static ListNode reverseKGroup(ListNode head, int k) {

            ListNode currhead = head ;
            ListNode k_1thNode = head;

            int x = k ;
            while(x!=0){
                k_1thNode = k_1thNode.next;
                x--;
            }
            if(k_1thNode ==null){
                return head;
            }else{
                ListNode temp = head ;
                ListNode curr = temp.next;
                head.next = k_1thNode;
                while(k!=1){

                    ListNode temp2 = curr.next;
                    curr.next = temp ;
                    temp = curr ;
                    curr = temp2;
                    currhead = curr;
                    k--;
                }
            }
            return currhead;
    }

    }

