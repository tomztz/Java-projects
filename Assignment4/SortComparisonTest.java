import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */
/*
+---------------------+--------+-----------+-------+-------+
|time taken in ns     | Insert | Selection | Quick | Merge |
+---------------------+--------+-----------+-------+-------+
| 1000 Random         |5269300 | 4702400   |1005600|1012000|
+---------------------+--------+-----------+-------+-------+
| 1000 few unique     |5709400 |7484200    |3757100|1021700|
+---------------------+--------+-----------+-------+-------+
| 1000 nearly ordered |4075500 |4491300    |3848500|1049600|
+---------------------+--------+-----------+-------+-------+
| 1000 reverse order  |7111700 |5443800    |7163800|678400 |
+---------------------+--------+-----------+-------+-------+
| 1000 sorted         |5355600 |4394600    |13574200|687100|
+---------------------+--------+-----------+-------+-------+
| 10000 random        |140967900|80453400  |7371200|6944300|
+---------------------+--------+-----------+-------+-------+
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
        double a[]={};
        double expected[]={};
        assertArrayEquals(expected,SortComparison.insertionSort(a),0);
        assertArrayEquals(expected,SortComparison.selectionSort(a),0);
        assertArrayEquals(expected,SortComparison.quickSort(a),0);
        assertArrayEquals(expected,SortComparison.mergeSort(a),0);

    }



    // add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.
    @Test
    public void testInsertionSort(){
        double a[]={2.20,4.40,7.70,5.50,6.60,8.80,3.30,9.90,1.10,0.00};
        double expected[]={0.00,1.10,2.20,3.30,4.40,5.50,6.60,7.70,8.80,9.90};
        assertArrayEquals(expected,SortComparison.insertionSort(a),0);
    }
    @Test
    public void testSelectionSort(){
        double a[]={2.20,4.40,7.70,5.50,6.60,8.80,3.30,9.90,1.10,0.00};
        double expected[]={0.00,1.10,2.20,3.30,4.40,5.50,6.60,7.70,8.80,9.90};
        assertArrayEquals(expected,SortComparison.selectionSort(a),0);
    }
    @Test
    public void testQuickSortSorted(){
        double a[]={0.00,1.10,2.20,3.30,4.40,5.50,6.60,7.70,8.80,9.90};
        double expected[]={0.00,1.10,2.20,3.30,4.40,5.50,6.60,7.70,8.80,9.90};
        assertArrayEquals(expected,SortComparison.quickSort(a),0);
    }
    @Test
    public void testQuickSortDescending(){
        double a[]={9.90,8.80,7.70,6.60,5.50,4.40,3.30,2.20,1.10,0.00};
        double expected[]={0.00,1.10,2.20,3.30,4.40,5.50,6.60,7.70,8.80,9.90};
        assertArrayEquals(expected,SortComparison.quickSort(a),0);
    }
    @Test
    public void testQuickSort(){
        double a[]={5.50,4.40,7.70,2.20,6.60,8.80,3.30,9.90,1.10,0.00};
        double expected[]={0.00,1.10,2.20,3.30,4.40,5.50,6.60,7.70,8.80,9.90};
        assertArrayEquals(expected,SortComparison.quickSort(a),0);
    }
    @Test
    public void testMergeSortSorted(){
        double a[]={0.00,1.10,2.20,3.30,4.40,5.50,6.60,7.70,8.80,9.90};
        double expected[]={0.00,1.10,2.20,3.30,4.40,5.50,6.60,7.70,8.80,9.90};
        assertArrayEquals(expected,SortComparison.mergeSort(a),0);
    }

    @Test
    public void testMergeSortDescending(){
        double a[]={9.90,8.80,7.70,6.60,5.50,4.40,3.30,2.20,1.10,0.00};
        double expected[]={0.00,1.10,2.20,3.30,4.40,5.50,6.60,7.70,8.80,9.90};
        assertArrayEquals(expected,SortComparison.mergeSort(a),0);
    }
    @Test
    public void testMergeSort(){
        double a[]={5.50,4.40,7.70,2.20,6.60,8.80,3.30,9.90,1.10,0.00};
        double expected[]={0.00,1.10,2.20,3.30,4.40,5.50,6.60,7.70,8.80,9.90};
        assertArrayEquals(expected,SortComparison.mergeSort(a),0);
    }
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */

      public static void main(String[] args)
    {

        try{
            File file= new File("C:/Users/tomzt/IdeaProjects/Assignment1/numbers10000.txt");
            Scanner scanner = new Scanner(file);
            int i=0;
            double[]arr= new double[10000];
            while (scanner.hasNextLine()) {
                arr[i] = Double.parseDouble(scanner.nextLine());
                i++;
            }
            long start = System.nanoTime();
            new SortComparison().mergeSort(arr);
            long finish = System.nanoTime();
            long duration = finish - start;
            System.out.println("time taken "+duration+"ns");
        }catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

    }

}

