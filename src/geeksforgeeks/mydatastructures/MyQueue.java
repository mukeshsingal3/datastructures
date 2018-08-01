package geeksforgeeks.mydatastructures;

public class MyQueue<T> {
    private int size;
    private int front;
    private int rear;
    private T[] array;

    public MyQueue(int size) {
        this.size = size;
        front = rear = -1;
        array = (T[]) new Object[size];
    }

    public void enQueue(T item) {

        if (isFull()) {
            System.out.println("Queue is Full");
        } else {
            if (rear == -1 && front == -1) {
                rear = front = 0;
            } else {
                rear = (rear + 1) % size;
            }

            array[rear] = item;
            System.out.println("Added " + item);
        }
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public T deQueue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return null;
        } else {

            T item = array[front];
            System.out.println("Removed " + item);
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return item;

        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(5);
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();

    }
}
