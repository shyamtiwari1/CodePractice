package Code.LeetCode.LinkedList;

public class ReverseNodesInKGRoup {


//    https://leetcode.com/problems/reverse-nodes-in-k-group/description/




    public ListNode reverKGroupRecursive(ListNode head , int k ){

        /**in this approach we check if there are k nodes left first , if not return head
         * if yes, revert first k nodes just as we did in a reverse a linked list
         * then recursively call for remaining part
         */

        ListNode node= head;

        for(int i = 0 ; i <k;i++){
            if(node==null)return head;
            node = node.next ;
        }

        ListNode curr  =head;
        ListNode prev = null;

        for(int i = 0 ; i<k;i++){
            ListNode nextnode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextnode;
        }

        head.next = reverKGroupRecursive(curr.next , k);
        return prev;
    }


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

