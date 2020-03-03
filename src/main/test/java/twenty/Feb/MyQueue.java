package twenty.Feb;

import java.util.LinkedHashMap;
import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by logan on 2020/2/15.
 */
public class MyQueue {
    /**
     * 解题思路,使用两个栈
     *  Java Queue Api的三组方法
     *  queue 队列的方法  add remove / offer poll / element peek
     *  Stack 的方法     push pop  peek
     *  关于队列接口:
     *  1. Queue 接口
     *  2. Deque(deck)继承了Queue接口, Deque可以
     *   2.1 This interface extends the Queue interface. When a deque is used as a queue, FIFO (First-In-First-Out) behavior results
     *   2.2 Deques can also be used as LIFO (Last-In-First-Out) stacks. This interface should be used in preference to the legacy Stack class
     *  实现类
     *  ArrayDeque 数组实现的双端队列,his class is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue.
     *  LinkedList 链表实现的双端队列
     */
    private Stack<Integer> stack1 = null;
    private Stack<Integer> stack2 = null;
    // 初始化数据结构
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    // 把元素放入队列尾部
    public void push(int x) {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    // 删除并返回队列头的元素
    public int pop() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.pop();
    }

    // 只是查看队列头的元素
    public int peek() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>(8, 0.75f, true);

        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        map.get(3);
        map.get(2);
        map.get(1);

        System.out.println(map);


    }

}
