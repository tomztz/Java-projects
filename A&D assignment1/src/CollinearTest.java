import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for Collinear.java
 *
 *  @author
 *  @version 18/09/18 12:21:26
 */
@RunWith(JUnit4.class)
public class CollinearTest {
    //~ Constructor ........................................................
    @Test
    public void testConstructor() {
        new Collinear();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------

    /**
     * Check that the two methods work for empty arrays
     */
    @Test
    public void testEmpty() {
        int expectedResult = 0;

        assertEquals("countCollinear failed with 3 empty arrays", expectedResult, Collinear.countCollinear(new int[0], new int[0], new int[0]));
        assertEquals("countCollinearFast failed with 3 empty arrays", expectedResult, Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
    }

    // ----------------------------------------------------------

    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleFalse() {
        int[] a3 = {15};
        int[] a2 = {5};
        int[] a1 = {10};

        int expectedResult = 0;

        assertEquals("countCollinear({10}, {5}, {15})", expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast({10}, {5}, {15})", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }

    // ----------------------------------------------------------

    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleTrue() {
        int[] a3 = {15, 5};
        int[] a2 = {5};
        int[] a1 = {10, 15, 5};

        int expectedResult = 1;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }

    @Test
    public void testMultipleFalse(){
        int []a3={0,1,2,3,4,5};
        int []a2={-1,-2,-3};
        int[]a1={6,7,8,9};

        int expectedResult = 0;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));


    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    //Test cases for sort function:
    @Test
    public void testMultipleTrue(){
        int[]a3={15,5,9,3,20};
        int[]a2={10,2,5,40};
        int[]a1={5,2,0};
        int expectedResult = 3;//{5,10,15}{5,5,5}{0,10,20}

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));


    }
    @Test
    public void testSortEmpty() {
        int[] testArr = {};
        int[] expectedArr = {};
        Collinear.sort(testArr);
        for (int i = 0; i < testArr.length; i++) {
            assertEquals("Sort failed with reverse array", expectedArr[i], testArr[i]);
        }

    }

    @Test
    public void testSortReverse() {
        int[] testArr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expectedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Collinear.sort(testArr);
        for (int i = 0; i < testArr.length; i++) {
            assertEquals("Sort failed with reverse array", expectedArr[i], testArr[i]);
        }
    }

    @Test
    public void testSortUnOrder() {
        int[] testArr = {-1, 0, 9, 8, -5, 2, 3};
        int[] expectedArr = {-5, -1, 0, 2, 3, 8, 9};
        Collinear.sort(testArr);
        for (int i = 0; i < testArr.length; i++) {
            assertEquals("Sort failed with unordered array", expectedArr[i], testArr[i]);
        }
    }

    @Test
    public void testSortRepeats() {
        int[] testArr = {-1, 0, 9, 3, -1, 8, -1, 3};
        int[] expectedArr = {-1, -1, -1, 0, 3, 3, 8, 9};
        Collinear.sort(testArr);
        for (int i = 0; i < testArr.length; i++) {
            assertEquals("Sort failed with repeated elements array", expectedArr[i], testArr[i]);
        }
    }

    //Test cases for binarySearch function:
    @Test
    public void testSearchEmpty() {
        int[] testArr = {};
        boolean expectedBoo = false;
        assertEquals("search failed with empty array", expectedBoo, Collinear.binarySearch(testArr, 5));
    }

    @Test
    public void numNotIncludedArr() {
        int[] testArray = {0, 1, 2, 3, 4, 5, 6, 7};
        boolean expectedBoo = false;
        assertEquals("search failed with element not included array", expectedBoo, Collinear.binarySearch(testArray, -1));
    }

    @Test
    public void numIncludedArrLeft() {
        int[] testArray = {0, 1, 2, 3, 4, 5, 6, 7};
        boolean expectedBoo = true;
        assertEquals("search failed with element at the left side of array", expectedBoo, Collinear.binarySearch(testArray, 0));
    }

    @Test
    public void numIncludedArrRight() {
        int[] testArr = {0, 1, 2, 3, 4, 5, 6, 7};
        boolean expectedBoo = true;
        assertEquals("search failed with element at right side of array", expectedBoo, Collinear.binarySearch(testArr, 7));
    }


    }




