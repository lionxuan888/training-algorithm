package twenty.Feb;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by logan on 2020/2/8.
 */
public class TestCycleList {

    public static  class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 探测环, 有两种解决方案
     * 1. 用set保存
     * 2. 用快慢指针的方法
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        ListNode curr = head;
        Set<ListNode> set = new HashSet();
        while(curr != null) {
            set.add(curr);
            ListNode next = curr.next;
            // 判断是否有环
            if (set.contains(next)) {
                return true;
            }
            curr = next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNodeA = new ListNode(5);
        ListNode listNodeB = new ListNode(3);
        ListNode listNodeC = new ListNode(7);
        ListNode listNodeD = new ListNode(9);
        ListNode listNodeE = new ListNode(2);
        listNodeA.next = listNodeB;
        listNodeB.next = listNodeC;
        listNodeC.next = listNodeB;
        listNodeD.next = listNodeE;
        listNodeE.next = null;
        System.out.println("是否有环:" + hasCycle(listNodeA));

        System.out.println();
    }
    
}
