package Code.LeetCode.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {


    //https://leetcode.com/problems/find-median-from-data-stream/description/

    /***
     *here we'll use two heaps one min heap and one max heap
     * all elements in small heap is always gonna be less than or equal to all elemnt of large heap
     * difference in size of two heap will not be greater than 1
     * if size diff is more than 1 then take out largest elemtn of min heap and add to large heap
     * add and remove operation are log(n) in a heap
     * findmax in max heap is O(1) , finding min in minheap is O(1)
     * take small heap as max heap and large heap as min heap
     *
     *
     */





    class MedianFinder {

        PriorityQueue<Integer> smallheap ;
        PriorityQueue<Integer> largeheap ;

        public MedianFinder() {
            smallheap = new PriorityQueue<>(Collections.reverseOrder());
            largeheap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            smallheap.offer(num);
            largeheap.offer(smallheap.poll());

            if(largeheap.size()>smallheap.size()){
                smallheap.offer(largeheap.poll());
            }
        }

        public double findMedian() {
            if(smallheap.size()==largeheap.size()){
                return (smallheap.peek()+largeheap.peek())/2.0;
            }else{
                return smallheap.peek();
            }

        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


}
