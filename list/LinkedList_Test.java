package list;

public class LinkedList_Test {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.insertTail(i);
        }
        list.print();
    }

}
