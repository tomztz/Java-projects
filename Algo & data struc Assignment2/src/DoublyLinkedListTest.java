
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
    }
    @Test
    public void isEmpty(){
        //empty list
        DoublyLinkedList<Integer>testDLL=new DoublyLinkedList<Integer>();
        assertEquals("Test empty list expected true",true,testDLL.isEmpty());
        //non-empty list
        testDLL.insertBefore(0,4);
        assertEquals("Test non-empty list expected false",false,testDLL.isEmpty());
    }
    @Test
    public void get(){
        DoublyLinkedList<Integer>testDLL=new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        Integer expectedResult=new Integer(1);
        assertEquals("data at position 0 expect 1",expectedResult,testDLL.get(0));
        expectedResult=2;
        assertEquals("data at position 1 expect 2",expectedResult,testDLL.get(1));
        expectedResult=3;
        assertEquals("data at position 2 expect 3",expectedResult,testDLL.get(2));
        expectedResult=4;
        assertEquals("data at position 3 expect 4",expectedResult,testDLL.get(3));
        assertEquals("data at position 4 expect null",null,testDLL.get(4));
        assertEquals("data at position -10 expect null",null,testDLL.get(-10));

        //test empty list
        testDLL = new DoublyLinkedList<Integer>();
        assertEquals("data for empty list expect null",null,testDLL.get(0));

    }
    @Test
    public void delete(){
        DoublyLinkedList<Integer>testDLL=new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.deleteAt(0);
        assertEquals("check deleteAt at the head of the list---expect 2,3,4","2,3,4",testDLL.toString());
        testDLL.deleteAt(2);
        assertEquals("check deleteAt at the tail of the list---expect 1,2","2,3",testDLL.toString());
        testDLL.insertBefore(2,5);
        testDLL.deleteAt(1);
        assertEquals("check deleteAt at the middle of the list---expect 2,5","2,5",testDLL.toString());
        System.out.println(testDLL.toString());
        assertEquals("check deleteAt with pos<0 expect false",false,testDLL.deleteAt(-10));
        assertEquals("check deleteAt with pos>=size expect false",false,testDLL.deleteAt(10));
        assertEquals("check deleteAt with pos=size expect false",false,testDLL.deleteAt(2));

        //test empty list
        testDLL=new DoublyLinkedList<Integer>();
        assertEquals("check deleting an empty list",false,testDLL.deleteAt(0));

        //test 1 element list
        testDLL=new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        assertEquals("check deleting an 1 element list expect true",true,testDLL.deleteAt(0));

    }
    @Test
    public void reverse(){
        DoublyLinkedList<Integer>testDLL=new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.reverse();
        assertEquals("list after reverse expect 4,3,2,1","4,3,2,1",testDLL.toString());


    }
    @Test
    public void makeUnique(){
        DoublyLinkedList<Character>testDLL=new DoublyLinkedList<Character>();
        testDLL.insertBefore(0,'A');
        testDLL.insertBefore(1,'B');
        testDLL.insertBefore(2,'C');
        testDLL.insertBefore(3,'B');
        testDLL.insertBefore(4,'D');
        testDLL.insertBefore(5,'A');

        testDLL.makeUnique();
        assertEquals("list after makeUnique expect A,B,C,D","A,B,C,D",testDLL.toString());

        DoublyLinkedList<Integer>testDLL1=new DoublyLinkedList<Integer>();
        testDLL1.insertBefore(0,2);
        testDLL1.insertBefore(1,2);
        testDLL1.insertBefore(2,2);
        testDLL1.insertBefore(3,1);
        testDLL1.insertBefore(4,1);
        testDLL1.insertBefore(5,1);
        testDLL1.insertBefore(6,1);
        testDLL1.makeUnique();
        assertEquals("list after makeUnique expect 2,1","2,1",testDLL1.toString());
        //test empty list
        testDLL1=new DoublyLinkedList<Integer>();
        testDLL1.makeUnique();
        assertEquals("list after makeUnique of empty list","",testDLL1.toString());

    }
    @Test
    public void push(){
    DoublyLinkedList<Integer>testDLL=new DoublyLinkedList<Integer>();
    testDLL.insertBefore(0,1);
    testDLL.insertBefore(1,2);
    testDLL.insertBefore(2,3);
    testDLL.push(0);

    assertEquals("list after push expect 0,1,2,3","0,1,2,3",testDLL.toString());

}
    @Test
    public void pop(){
        DoublyLinkedList<Integer>testDLL=new DoublyLinkedList<Integer>();
        testDLL.push(1);
        testDLL.push(2);
        testDLL.push(3);
        Integer expectedResult=new Integer(3);
        assertEquals("pop value expect 3",expectedResult,testDLL.pop());
        testDLL.push(9);
        expectedResult=new Integer(9);
        assertEquals("pop value expect 9",expectedResult,testDLL.pop());
        //test list empty
        testDLL=new DoublyLinkedList<Integer>();
        assertEquals("pop value for empty DLL expect null",null,testDLL.pop());
    }
    @Test
    public void enqueue(){
        DoublyLinkedList<Integer>testDLL=new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.enqueue(4);

        assertEquals("expected DLL after enqueue --1,2,3,4","1,2,3,4",testDLL.toString());

    }
    @Test
    public void dequeue(){
        DoublyLinkedList<Integer>testDLL=new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.enqueue(4);

        Integer expectedResult=new Integer(1);
        assertEquals("dequeue value expect 1",expectedResult,testDLL.dequeue());
        expectedResult=new Integer(2);
        assertEquals("dequeue value expect 2",expectedResult,testDLL.dequeue());


        //test list empty
        testDLL=new DoublyLinkedList<Integer>();
        assertEquals("dequeue value for empty DLL expect null",null,testDLL.dequeue());
    }
    @Test
    public void testErrorsFromWebcat(){
        DoublyLinkedList<Integer>testDLL=new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-1,1);
        testDLL.deleteAt(0);
        testDLL.insertBefore(100,2);
        testDLL.insertBefore(100,3);
        assertEquals("expected result 2,3","2,3",testDLL.toString());

        testDLL=new DoublyLinkedList<Integer>();
        testDLL.enqueue(100);
        testDLL.enqueue(200);
        testDLL.enqueue(300);
        Integer expectedVal=new Integer(100);
        assertEquals("expected result after pop 100",expectedVal,testDLL.dequeue());

        testDLL=new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,2);
        testDLL.insertBefore(1,1);
        testDLL.insertBefore(2,2);
        testDLL.insertBefore(3,1);
        testDLL.insertBefore(4,1);
        testDLL.insertBefore(5,2);
        testDLL.insertBefore(6,1);
        testDLL.makeUnique();
        testDLL.deleteAt(1);
        assertEquals("expected list [2]","2",testDLL.toString());

        testDLL=new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,2);
        testDLL.insertBefore(1,1);
        testDLL.makeUnique();
        assertEquals("expected list [2,1]","2,1",testDLL.toString());


    }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.

}
