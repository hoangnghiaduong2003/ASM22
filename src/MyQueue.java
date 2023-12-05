class MyQueue {
    private Node start;
    private Node end;
    public MyQueue() {
        this.start = null;
        this.end = null;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public void enqueue(String message) {
        Node newNode = new Node(message);
        if (isEmpty()) {
            start = end = newNode;
        } else {
            end.next = newNode;
            end = newNode;
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Empty queue!");
            return null;
        }
        String data = start.data;
        start = start.next;
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
