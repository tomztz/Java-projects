import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  Tianze Zhang
 */

@RunWith(JUnit4.class)
public class BSTTest
{
    @Test
    public void isEmpty(){
        BST<String, String> bst = new BST<String, String>();

        assertEquals("checking if tree is empty",
                true, bst.isEmpty());
    }
    @Test
    public void testSize(){
        BST<String, String> bst = new BST<String, String>();
        bst.put("B","B");
        bst.put("A","A");

        assertEquals("Checking size of tree",
                1, bst.height());
    }
    @Test
    public void testContainsNull(){
        BST<String, String> bst = new BST<String, String>();


        assertEquals("Checking contains of key null",
                false, bst.contains(null));
    }
    @Test
    public void testContainsLeft(){
        BST<String, String> bst = new BST<String, String>();
        bst.put("B","B");
        bst.put("A","A");

        assertEquals("Checking contains of key A",
                true, bst.contains("A"));
    }
    @Test
    public void testContainsRight(){
        BST<String, String> bst = new BST<String, String>();
        bst.put("B","B");
        bst.put("C","C");

        assertEquals("Checking contains of key C",
                true, bst.contains("C"));
    }
    @Test
    public void put(){
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        bst.put(1,1);
        bst.put(2,2);
        bst.put(2,null);
        bst.put(1,2);
        Integer temp=new Integer(2);
        assertEquals("Checking tree",
                temp, bst.get(1));
    }

    //TODO write more tests here.
    @Test
    public void testHeightEmpty(){
        BST<String, String> bst = new BST<String, String>();

        assertEquals("Checking height of tree",
                -1, bst.height());
    }

    @Test
    public void testHeight1element(){
        BST<String, String> bst = new BST<String, String>();
        bst.put("B","B");

        assertEquals("Checking height of tree",
                0, bst.height());
    }
    @Test
    public void testHeight(){
        BST<String, String> bst = new BST<String, String>();
        bst.put("B","B");
        bst.put("A","A");
        bst.put("C","C");
        bst.put("D","D");
        assertEquals("Checking height of tree",
                2, bst.height());
    }
    @Test
    public void testMedianEmpty(){
        BST<Integer, Integer> bst = new BST<Integer, Integer>();

        assertEquals("Checking median of tree",
                null, bst.median());
    }
    @Test
    public void testMedian(){
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        bst.put(7, 7);   //        _7_
        bst.put(8, 8);   //      /     \
        bst.put(3, 3);   //    _3_      8
        bst.put(1, 1);   //  /     \
        bst.put(2, 2);   // 1       6
        bst.put(6, 6);   //  \     /
        bst.put(4, 4);   //   2   4
        bst.put(5, 5);   //        \
        //         5
        Integer temp=new Integer(4);
        assertEquals("Checking median of tree",
                temp, bst.median());
    }
    @Test
    public void testInOrder1Element(){
        BST<String, String> bst = new BST<String, String>();
        bst.put("A","A");
        assertEquals("Checking in order traversal 1 element of tree",
                "(()A())", bst.printKeysInOrder());
    }
    @Test
    public void testInOrder(){
        BST<String, String> bst = new BST<String, String>();
        bst.put("B","B");
        bst.put("A","A");
        bst.put("C","C");
        bst.put("D","D");
        assertEquals("Checking in order traversal 1 element of tree",
                "((()A())B(()C(()D())))", bst.printKeysInOrder());
    }
    @Test
    public void testMedianString(){
        BST<String, String> bst = new BST<String, String>();
        bst.put("A", "A");
        bst.put("C", "C");
        bst.put("U", "U");
        bst.put("W", "W");



        assertEquals("Checking median of tree",
                "C", bst.median());
    }

    /** <p>Test {@link BST#prettyPrintKeys()}.</p> */

    @Test
    public void testPrettyPrint() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        assertEquals("Checking pretty printing of empty tree",
                "-null\n", bst.prettyPrintKeys());

                                        //  -7
                                        //   |-3
                                        //   | |-1
                                        //   | | |-null
        bst.put(7, 7);       //   | |  -2
        bst.put(8, 8);       //   | |   |-null
        bst.put(3, 3);       //   | |    -null
        bst.put(1, 1);       //   |  -6
        bst.put(2, 2);       //   |   |-4
        bst.put(6, 6);       //   |   | |-null
        bst.put(4, 4);       //   |   |  -5
        bst.put(5, 5);       //   |   |   |-null
                                        //   |   |    -null
                                        //   |    -null
                                        //    -8
                                        //     |-null
                                        //      -null

        String result =
                "-7\n" +
                        " |-3\n" +
                        " | |-1\n" +
                        " | | |-null\n" +
                        " | |  -2\n" +
                        " | |   |-null\n" +
                        " | |    -null\n" +
                        " |  -6\n" +
                        " |   |-4\n" +
                        " |   | |-null\n" +
                        " |   |  -5\n" +
                        " |   |   |-null\n" +
                        " |   |    -null\n" +
                        " |    -null\n" +
                        "  -8\n" +
                        "   |-null\n" +
                        "    -null\n";
        assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
    }


    /** <p>Test {@link BST#delete(Comparable)}.</p> */
    @Test
    public void testDelete() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        bst.delete(1);
        assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());

        bst.put(7, 7);   //        _7_
        bst.put(8, 8);   //      /     \
        bst.put(3, 3);   //    _3_      8
        bst.put(1, 1);   //  /     \
        bst.put(2, 2);   // 1       6
        bst.put(6, 6);   //  \     /
        bst.put(4, 4);   //   2   4
        bst.put(5, 5);   //        \
                                    //         5

        assertEquals("Checking order of constructed tree",
                "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

        bst.delete(9);
        assertEquals("Deleting non-existent key",
                "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

        bst.delete(8);
        assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());

        bst.delete(6);
        assertEquals("Deleting node with single child",
                "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());

        bst.delete(3);
        assertEquals("Deleting node with two children",
                "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
        bst.delete(4);
        assertEquals("Deleting node with right child",
                "(((()1())2(()5()))7())", bst.printKeysInOrder());
    }

}
