package base.arithmetic.listnode;

public class DQListNode {

    /**
     * 头节点
     */
    private Node head;
    /**
     * 尾节点
     */
    private Node last;
    /**
     * 链表长度
     */
    private int size;

    public void insert(int data, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("out of index");
        }
        Node insertNode = new Node(data);
        if (size == 0) {
            // 链表没有值
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            // 头部插入
            insertNode.next = head;
            head = insertNode;
        } else if (index == size - 1) {
            // 尾部插入
            last.next = insertNode;
            last = insertNode;
        } else {
            // 中间插入
            Node preNode = get(index - 1);
            Node tempNode = preNode.next;
            preNode.next = insertNode;
            insertNode.next = tempNode;
        }
        size++;
    }

    public Node delete(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("out of index");
        }
        Node removeNode = null;
        if (index == 0) {
            // 删除头节点
            removeNode = head;
            head = head.next;
        } else if (index == size - 1) {
            // 删除尾节点
            Node preNode = get(index - 1);
            last = preNode;
            removeNode = preNode.next;
            preNode.next = null;
        } else {
            Node preNode = get(index - 1);
            removeNode = preNode.next;
            preNode.next = preNode.next.next;
        }
        return removeNode;
    }

    public Node get(int index) throws Exception {
        if (index < 0 || index < size) {
            throw new IndexOutOfBoundsException("index out of");
        }
        Node tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    /**
     * 节点
     */
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
