package Workshop.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CustomLikedList{

    private Node head;
    private Node tail;
    private int size;

    public CustomLikedList() {
    }

    private static class Node{
        private int element;
        private Node prev;
        private Node next;

        public Node(int element) {
            this.element = element;
        }
    }

    public int get(int index){
        validateIndex(index);

        Node currentNode = this.head;
        int currentIndex = 0;
        int element = 0;

        while (currentNode != null){
            if (index == currentIndex){
                element = currentNode.element;
                break;
            }
            currentIndex++;
            currentNode = currentNode.next;
        }

        return element;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size){
            throw new IllegalArgumentException("Index out of bounds for index " + index);
        }
    }

    public void addLast(int element){
        if (isEmpty()){
            addFirst(element);
            return;
        }

        Node newNode = new Node(element);

        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
        this.size++;
    }

    public void addFirst(int element){
        Node newNode = new Node(element);
        if (this.head != null){
            newNode.next = this.head;
            this.head.prev = newNode;
        }

        this.head = newNode;

        if (isEmpty()){
            this.tail = this.head;
        }

        this.size++;
    }

    public int removeFirst(){
        if (isEmpty()){
            throw new IllegalStateException("Cannot remove an element from an empty List.");
        }

        int removedElement = this.head.element;
        this.head = this.head.next;

        if (this.size > 1){
            this.head.prev = null;
        }

        this.size--;

        if (this.isEmpty()){
            this.head = this.tail = null;
        }
        return removedElement;
    }

    public int removeLast(){
        if (size < 2){
            return removeFirst();
        }

        int removeElement = this.tail.element;
        this.tail = this.tail.prev;
        this.tail.next = null;
        this.size--;

        return removeElement;
    }

    public void forEach (Consumer<Integer> consumer){
        Node current = this.head;
        while (current != null){
            consumer.accept(current.element);
            current = current.next;
        }
    }

    public int[] toArray(){
        int[] array = new int[this.size];

        Node current = this.head;
        int index = 0;
        while (current != null){
            array[index++] = current.element;
            current = current.next;
        }

        //second way
//        List<Integer> list = new ArrayList<>();
//        forEach(list::add);
//        return list.stream().mapToInt(e -> e).toArray();

        return  array;
    }

    public void clear(){
        if (!isEmpty()){
            Node current = this.head;
            while (current != null){
                Node next = current.next;
                current.prev = null;
                current.next = null;
                current = next;
            }
            this.size = 0;
            this.head = this.tail = null;
        }
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
