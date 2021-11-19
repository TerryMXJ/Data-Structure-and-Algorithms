package list;

public class ReverseList {

    public static void main(String[] args) {

    }

    private LinkedList.Node reverseList(LinkedList.Node head) {
        LinkedList.Node prev = null, cur = head, next = null;
        // 检验的是cur当前所指向的结点, 返回的是prev结点
        while (cur!=null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
