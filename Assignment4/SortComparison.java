// -------------------------------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){

       double temp;
       for (int i = 1; i < a.length; i++) {
          for(int j = i ; j > 0 ; j--){
             if(a[j] < a[j-1]){
                temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
             }
          }
       }
       return a;
    }//end insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){

       int n = a.length;

       for (int i = 0; i < n-1; i++)
       {
          int min_idx = i;
          for (int j = i+1; j < n; j++)
             if (a[j] < a[min_idx])
                min_idx = j;

          double temp = a[min_idx];
          a[min_idx] = a[i];
          a[i] = temp;
       }
       return a;

    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){

       recursiveQuick(a, 0, a.length-1);
       return a;

    }
   public static void recursiveQuick(double[] numbers, int lo, int hi) {
      if(hi <= lo) {
         return;
      }
      int pivotPos = partition(numbers, lo, hi);
      recursiveQuick(numbers, lo, pivotPos-1);
      recursiveQuick(numbers, pivotPos+1, hi);
   }
   //end quicksort
   private static int partition(double[] numbers, int lo, int hi) {
      int i = lo;
      int j = hi+1;
      double pivot = numbers[lo];
      while(true) {
         while((Double.compare(numbers[++i],pivot)< 0)) {
            if(i == hi) break;
         }
         while((Double.compare(pivot,numbers[--j]) < 0)) {
            if(j == lo) break;
         }
         if(i >= j) break;
         double temp = numbers[i];
         numbers[i] = numbers[j];
         numbers[j] = temp;
      }
      numbers[lo] = numbers[j];
      numbers[j] = pivot;
      return j;
   }
    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSort (double a[]) {
      double[]aux=new double[a.length];
      sort(a,aux,0,a.length-1);
      return a;
    }//end mergesort
    private static void sort(double a[],double[]aux,int lo,int hi){
       if(hi<=lo)return;
       int mid=lo+(hi-lo)/2;
       sort(a,aux,lo,mid);
       sort(a,aux,mid+1,hi);
       merge(a,aux,lo,mid,hi);
    }

   private static void merge(double a[],double[]aux,int lo,int mid,int hi) {
      for(int k=lo;k<=hi;k++){
         aux[k]=a[k];
      }
      int i=lo,j=mid+1;
      for(int k=lo;k<=hi;k++){
         if(i>mid)a[k]=aux[j++];
         else if (j>hi)a[k]=aux[i++];
         else if (aux[j]<aux[i]) a[k]=aux[j++];
         else a[k]=aux[i++];
      }

   }


 }//end class

