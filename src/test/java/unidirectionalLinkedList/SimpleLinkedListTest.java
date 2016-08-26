package unidirectionalLinkedList;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleLinkedListTest {
    private static SimpleLinkedList linkedList;
    private static SimpleLinkedList linkedListOneElement;
    private static SimpleLinkedList linkedListEmpty;

    private static final String LIST_TO_STRING_EMPTY = "[]";
    private static final String LIST_ONE_ELEMENT_TO_STRING = "[1]";
    private static final String LIST_TO_STRING = "[1, 2, 3, 4]";
    private static final String LIST_TO_STRING_REVERT = "[4, 3, 2, 1]";

    @BeforeClass
    public  static void setUp() throws Exception {
        linkedListEmpty = new SimpleLinkedList();

        linkedListOneElement = new SimpleLinkedList();
        linkedListOneElement.add("1");

        linkedList = new SimpleLinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        linkedList = null;
        linkedListEmpty = null;
        linkedListOneElement = null;
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertEquals(LIST_TO_STRING, linkedList.toString());
        Assert.assertEquals(LIST_ONE_ELEMENT_TO_STRING, linkedListOneElement.toString());
        Assert.assertEquals(LIST_TO_STRING_EMPTY, linkedListEmpty.toString());
    }

    @Test
    public void testRevert() throws Exception {
        Assert.assertEquals(LIST_TO_STRING_EMPTY, new SimpleLinkedList().toString());
        linkedList.revert();
        Assert.assertEquals(LIST_TO_STRING_REVERT, linkedList.toString());

        linkedListOneElement.revert();
        Assert.assertEquals(LIST_ONE_ELEMENT_TO_STRING, linkedListOneElement.toString());

        linkedListEmpty.revert();
        Assert.assertEquals(LIST_TO_STRING_EMPTY, linkedListEmpty.toString());
    }

}