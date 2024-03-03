package LinkedList;

public class ListNode {
    int val;
    ListNode next;
//    ListNode dummyHead;
//    int size;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /*
    public int get(int index) {
        ListNode currentNode = dummyHead;
        if (index < 0 || index >= size )
            return -1;
        // 遍历到index，因为dummy head存在，index + 1为所求
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    public void addAtIndex(int index, int val) {
        ListNode dummyHead = new ListNode(0);
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

     */

}
