package unidirectionalLinkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 10.08.2016.
 */
public class SimpleLinkedListTest {
    SimpleLinkedList linkedList;
    public static final String LIST_TO_STRING_REVERT = "[4, 3, 2, 1]";
    public static final String LIST_TO_STRING = "[1, 2, 3, 4]";
    public static final String LIST_TO_STRING_EMPTY = "[]";

    @Before
    public void setUp() throws Exception {
        linkedList = new SimpleLinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
    }

    @After
    public void tearDown() throws Exception {
        linkedList = null;
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertTrue(LIST_TO_STRING.equals(linkedList.toString()));
    }

    @Test
    public void testRevert() throws Exception {
        linkedList.revert();
        Assert.assertTrue(LIST_TO_STRING_REVERT.equals(linkedList.toString()));
        Assert.assertTrue(LIST_TO_STRING_EMPTY.equals(new SimpleLinkedList().toString()));
    }

}