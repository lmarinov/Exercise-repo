package Workshop.Exercise;

public class Main {
    public static void main(String[] args) {

        CustomLikedList customerLinkedList = new CustomLikedList();


        for (int i = 0; i < 5; i++) {
            customerLinkedList.addFirst(i + 1);
        }

        customerLinkedList.clear();
        System.out.println();
    }
}
