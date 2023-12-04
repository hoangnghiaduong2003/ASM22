public class MyStack {
    private Node top;

    public MyStack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(String message) {
        Node newNode = new Node(message);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Empty stack!");
            return null;
        }
        String data = top.data;
        top = top.next;
        return data;
    }

    public void display() {
        Node current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
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
