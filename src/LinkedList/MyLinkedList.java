package LinkedList;

/**
 * LC#707.Med 设计链表
 *
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
 *
 * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 *
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
 *
 * 实现 LinkedList.MyLinkedList 类：
 *
 * LinkedList.MyLinkedList() 初始化 LinkedList.MyLinkedList 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 *
 *
 * 示例：
 *
 * 输入
 * ["LinkedList.MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * 输出
 * [null, null, null, null, 2, null, 3]
 *
 * 解释
 * LinkedList.MyLinkedList myLinkedList = new LinkedList.MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
 * myLinkedList.get(1);              // 返回 2
 * myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
 * myLinkedList.get(1);              // 返回 3
 *
 *
 * 关键：会遍历节点，一个get一个addAtIndex
 *
 */

public class MyLinkedList {
    int size;
    ListNode dummyHead;


    public MyLinkedList() {
        size = 0;
        dummyHead = new ListNode(0);
    }

    // 查找/获取 第index的节点
    public int get(int index) {
        if (size <= 0)
            return -1;
        if (index < 0 || index >= size)
            return -1;
        ListNode currentNode = dummyHead;
        // 遍历到index，因为dummy head存在，= index为所求
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        if (currentNode == null)
            return -1;
        return currentNode.val;
    }

    // 加在头尾分别是加在index = 0 / size处的情况
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        }
        ListNode newNode = new ListNode(val);
        ListNode current = dummyHead;
        // 找到index前一个为current
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;
        if (size == 0)
            dummyHead = dummyHead.next;
        ListNode currentNode = dummyHead;
        // 遍历到index
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtHead(23);
        list.addAtHead(44);
        list.addAtHead(55);
        list.addAtHead(666);

        System.out.println(list.get(0));
        list.deleteAtIndex(3);
        System.out.println(list.get(3));
        System.out.println(list.get(5));
    }
}

