package twenty.Feb;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * Created by logan on 2020/2/7.
 */
public class TestSwapNodes {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 解题关键点,
     * 关键
     * 1, 如何抽取外层节点用作变量, 用pre还是next
     * 2. 两两交叉的指针关联代码的处理, 可以不用先一部到位,
     *    在本次循环可以先暂时执行下一个pair的left, 等一次循环在重新指向下一个pair的right
     *      preNode.next = rightNode;
     * @param head
     * @return
     */
    public static ListNode swapPair(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode newHead = head.next;
        ListNode preNode = new ListNode(-1);
        while(curr != null && curr.next != null) {
            ListNode leftNode = curr;
            ListNode rightNode = curr.next;
            // 交换
            preNode.next = rightNode;
            leftNode.next = rightNode.next;
            rightNode.next = leftNode;

            preNode = leftNode;
            curr = leftNode.next;

        }
        return newHead;
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
        printList(swapPair(listNodeA));

    }

    public static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
    }

}
