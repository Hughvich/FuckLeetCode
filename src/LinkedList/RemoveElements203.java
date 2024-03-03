package LinkedList;

/**
 * LC#203.Easy
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * 所给的ListNode(单链表类):
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *  }
 *
 */


/**
 * 三种方法：有dummyHead，有pre节点；没有dummyHead，有pre节点；没有dummyHead，没有pre节点
 *
 */
public class RemoveElements203 {
    public static ListNode removeElements(ListNode head, int val) {

        // 第一种：有dummyHead，有pre节点；
        /*
        if (head == null)
            return null;
        ListNode dummyHead = new ListNode(-1, head);
        ListNode curNode = head;
        ListNode pred = dummyHead;

        while (curNode != null) {
            if (curNode.val == val){
                pred.next = curNode.next;
            } else {
                pred = curNode;
            }
            curNode = curNode.next;
        }
        return dummyHead.next;

         */
        // 第二种：没有dummyHead，有pre节点，需要单独处理head节点
        /*
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null)
            return null;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;

         */

        // 第三种：没有dummyHead，没有pre节点，需要单独处理head节点
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null)
            return null;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtIndex(0, 3);
//        list.addAtIndex(0, 4);
        list.addAtIndex(0, 3);
//        list.addAtIndex(0, 2);
        list.addAtIndex(0, 3);
        ListNode head = new ListNode(0, list.dummyHead);

        removeElements(head, 3);

        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println(list.get(3));
    }
}

