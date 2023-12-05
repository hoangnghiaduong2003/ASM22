public class MyStack {

    private Node top;

    public MyStack() {
        this.top = null;
    }

    public boolean isStackEmpty() {
        return top == null;
    }
    // add message in top stack
    public void push(String message) {
        Node newNode = new Node(message);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (isStackEmpty()) {
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

    public String deleteMessage(String searchString) {
        if (isStackEmpty()) {
            System.out.println("Empty stack!");
            return null;
        }

        Node current = top;
        Node prev = null;

        while (current != null && !current.data.contains(searchString)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("No matching message found!");
            return null;
        }

        if (prev == null) {

            return pop();
        } else {

            prev.next = current.next;
            return current.data;
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
