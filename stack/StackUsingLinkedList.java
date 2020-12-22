package stack;

public class StackUsingLinkedList {

    private class Node {
        int data;
        Node next;
    }

    Node top;

    public StackUsingLinkedList() {
        this.top = null;
    }

    public void push(int x) {
        Node temp = new Node();
        temp.data = x;
        temp.next = this.top;
        this.top = temp;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public int peek() {
        if (!isEmpty()) {
            return this.top.data;
        }else {
            System.out.println("Stack is Empty");
            return -1;
        }
    }

    public void pop() {
        if (this.top == null) {
            System.out.println("stack underflow");
            return;
        }
        this.top = this.top.next;
    }

    public void display() {
        if (this.top == null) {
            System.out.println("stack underflow");
        }else {
            Node temp = this.top;
            while (temp != null) {
                System.out.printf("%d ->", temp.data);
                temp = temp.next;
            }
        }
    }

}
