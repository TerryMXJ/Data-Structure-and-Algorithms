package heap;

import java.util.Arrays;

public class MinHeap {

    private int[] heap;
    private int size;
    private int maxSize;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[this.maxSize+1];
        this.heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos/2;
    }

    private int leftChild(int pos) {
        return (2*pos);
    }

    private int rightChild(int pos) {
        return (2*pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size/2) && pos <= size) return true;
        return false;
    }

    private void swap(int fpos, int spos) {
        int temp = this.heap[fpos];
        this.heap[fpos] = this.heap[spos];
        this.heap[spos] = temp;
    }

    public void constructorMinHeap() {
        for (int pos = (size/2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (this.heap[pos] > this.heap[leftChild(pos)]) {
                if (this.heap[leftChild(pos)] < this.heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) {
        if (size >= maxSize) {
            System.out.println("Heap is full...");
            return;
        }
        this.heap[++size] = element;
        int current = size;
        while(this.heap[current] < this.heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int remove() {
        int poped = this.heap[1];
        this.heap[1] = this.heap[this.size--];
        minHeapify(1);
        return poped;
    }

    public void print() {
        System.out.println(Arrays.toString(this.heap));
    }
}
