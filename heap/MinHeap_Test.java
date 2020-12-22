package heap;

public class MinHeap_Test {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.print();
        minHeap.constructorMinHeap();
        minHeap.print();
        System.out.println("The Minimal value is " + minHeap.remove());
        minHeap.print();
    }

}
