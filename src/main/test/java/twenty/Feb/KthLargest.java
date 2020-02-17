package twenty.Feb;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第K大元素
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * 示例:
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by logan on 2020/2/15.
 */
public class KthLargest {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.add(8);
        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(4);
        priorityQueue.add(9);
        priorityQueue.add(1);


        priorityQueue.element();
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue);
        // 3 (11  )  >>> 1 =   1
        // 4 (100  )  >>> 1 =   2
        // 5 (101  )  >>> 1 =   2
        // 6 (110  )  >>> 1 =   3
        // 7 (111  )  >>> 1 =   3
        // 8 (1000  )  >>> 1 =   4
        // 9 (1001  )  >>> 1 =   4
        // 10 (1010  )  >>> 1 =   5
        // 11 (1011  )  >>> 1 =   5
        System.out.println(12 >>>1);
    }
}
