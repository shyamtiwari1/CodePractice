import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String args[]){

    }


    public class Node{
        int key;
        int val ;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public class LRUCacheImplement{

        Map<Integer , Node> mpp = new HashMap<>();

        Node head;
        Node tail;
        int capacity ;

        public LRUCacheImplement(int capacity){

            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;

        }

        public int get(int key){
            if(!mpp.containsKey(key)){
                return -1;
            }else{
                Node node = mpp.get(key);
                deleteNode(node);
                insertAfterHEad(node);
                return node.val;
            }
        }

        public void put(int key , int val){
            if(!mpp.containsKey(key)){
                if(mpp.size()<capacity){
                    Node node = new Node(key , val);
                    insertAfterHEad(node);
                    mpp.put(key , node);
                }else{
                    Node leastUsedNode = mpp.get(tail.prev.key);
                    Node newNode = new Node(key , val);
                    deleteNode(leastUsedNode);
                    mpp.remove(leastUsedNode.key);
                    insertAfterHEad(newNode);
                }


            }else{
                Node existingNode = mpp.get(key);
                existingNode.val = val;
                deleteNode(existingNode);
                insertAfterHEad(existingNode);
            }
        }

        public void insertAfterHEad(Node node){

            Node currAfterHead = head.next;
            head.next = node;node.prev = head;
            node.next = currAfterHead;
            currAfterHead.prev = node;


        }
        public void deleteNode(Node node){
            Node prevNode = node.prev;
            Node afterNode = node.next;
            prevNode.next = afterNode;
            afterNode.prev = prevNode;

        }

    }
}
