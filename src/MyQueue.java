public class MyQueue {
    private Node head;
    private Node tail;

    public MyQueue() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(String message) {
        Node newNode = new Node(message);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Empty queue!");
            return null;
        }
        String data = head.data;
        head = head.next;
        return data;
    }

    private static class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
}
