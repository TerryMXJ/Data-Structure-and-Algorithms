package list;

public class LinkedList {

    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void insertHead(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public void insertTail(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
        }else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new_node;
        }
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }

}
