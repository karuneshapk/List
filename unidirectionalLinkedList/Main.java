package unidirectionalLinkedList;

/**
 * Created by mgolub on 8/4/2016.
 */
public class Main {
    public static void main(String[] args) {
        SimpleLinkedList linkedList = new SimpleLinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        linkedList.add("6");
        linkedList.add("7");
        linkedList.add("8");
        linkedList.add("9");
        linkedList.add("10");

        System.out.println(linkedList);

        linkedList.revert();
        System.out.println();

        System.out.println(linkedList);
    }
}
