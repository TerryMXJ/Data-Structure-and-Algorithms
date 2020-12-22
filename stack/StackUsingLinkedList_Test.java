package stack;

public class StackUsingLinkedList_Test {

    public static void main(String[] args) {
        StackUsingLinkedList list = new StackUsingLinkedList();
        for (int i = 0; i < 10; i++) {
            list.push(i);
        }
        list.display();
        for (int i = 0; i < 11; i++) {
            System.out.printf("\nTop element is %d\n", list.peek());
            list.pop();
        }
    }

}
