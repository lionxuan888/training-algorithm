package twenty.Feb;

import twenty.Foo;

/**
 * 反转一个单链表。206. 反转链表
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by logan on 2020/2/7.
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class TestReverseLinkList {

    public static  class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null ) {
            return head;
        }
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode tmpNext = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmpNext;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNodeA = new ListNode(5);
        ListNode listNodeB = new ListNode(3);
        ListNode listNodeC = new ListNode(7);
        ListNode listNodeD = new ListNode(9);
        ListNode listNodeE = new ListNode(2);
        listNodeA.next = listNodeB;
        listNodeB.next = listNodeC;
        listNodeC.next = listNodeD;
        listNodeD.next = listNodeE;
        listNodeE.next = null;
        printList(listNodeA);
        printList(reverseList(listNodeA));
    }


    public static void  printList(ListNode listNode) {
        while(listNode != null) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
    }
}
