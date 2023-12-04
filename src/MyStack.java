public class MyStack {
    private String[] stack;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        this.stack = new String[DEFAULT_CAPACITY];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(String message) {
        if (top == stack.length - 1) {
            // Resize the array if it's full
            resize();
        }
        stack[++top] = message;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Empty stack!");
            return null;
        }
        return stack[top--];
    }

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    private void resize() {
        int newCapacity = stack.length * 2;
        String[] newStack = new String[newCapacity];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
}
