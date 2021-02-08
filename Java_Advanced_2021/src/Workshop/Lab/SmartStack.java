package Workshop.Lab;

public class SmartStack {

    private static class Node {
        int element;
        Node prev;

        private Node(int element) {
            this.element = element;
        }
    }

    private Node top;
    private int size;

    public SmartStack() {

    }

    public void push(int element) {
        Node newNode = new Node(element);
        if (this.top != null) {
            newNode.prev = this.top;
        }
        this.top = newNode;

        this.size++;
    }

    public int peek() {
        nonEmpty("peek");
        return this.top.element;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int pop() {
        nonEmpty("pop");
        int element = this.top.element;
        this.top = this.top.prev;
        this.size--;
        return element;
    }

    private void nonEmpty(String type) {
        if (this.top == null) {
            throw new IllegalStateException("Cannot" + type + "on empty stack!");
        }
    }
}
