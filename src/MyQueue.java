public class MyQueue {
    private String[] queue;
    private int front;
    private int rear;
    private static final int DEFAULT_CAPACITY = 10;

    public MyQueue() {
        this.queue = new String[DEFAULT_CAPACITY];
        this.front = this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void enqueue(String message) {
        if (front == -1) {
            front = rear = 0;
        } else if ((rear + 1) % queue.length == front) {
            // Resize the array if it's full
            resize();
        } else {
            rear = (rear + 1) % queue.length;
        }
        queue[rear] = message;
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Empty queue!");
            return null;
        }
        String data = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % queue.length;
        }
        return data;
    }

    private void resize() {
        int newCapacity = queue.length * 2;
        String[] newQueue = new String[newCapacity];
        int i = 0;
        while (front != rear) {
            newQueue[i++] = queue[front];
            front = (front + 1) % queue.length;
        }
        newQueue[i] = queue[rear];
        front = 0;
        rear = i;
        queue = newQueue;
    }
}
