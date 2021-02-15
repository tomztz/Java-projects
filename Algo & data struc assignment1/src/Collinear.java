// -------------------------------------------------------------------------
/**
 *  This class contains only two static methods that search for points on the
 *  same line in three arrays of integers. 
 *
 *  @author  
 *  @version 18/09/18 12:21:09
 */
class Collinear
{

public static final int Y1=1;
public static final int Y2=2;
public static final int Y3=3;
public static final double PREDICTED_TIME=37.87;

   // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinear(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * Array a1, a2 and a3 contain points on the horizontal line y=1, y=2 and y=3, respectively.
     * A non-horizontal line will have to cross all three of these lines. Thus
     * we are looking for 3 points, each in a1, a2, a3 which lie on the same
     * line.
     *
     * Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if
     * 
     * x1(y2−y3)+x2(y3−y1)+x3(y1−y2)=0 
     *
     * In our case y1=1, y2=2, y3=3.
     *
     * You should implement this using a BRUTE FORCE approach (check all possible combinations of numbers from a1, a2, a3)
     *
     * ----------------------------------------------------------
     *
     * 
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of growth: N^3
     *
     *  Explanation: three for loops, worst case for each loop takes around Ns to complete.
     *
     *  scientific verification below:
     *
     *
     *  Measured time with different inputs using stop watch:
     *  1000 inputs:1.334 s
     *  2000 inputs:12.25 s
     *  4000 inputs:17.758s
     *
     *  assume runing time in form of an^b
     *  b estimated=lg(12.25-1.334)=3.44
     *  lg(T (N)) = b lg N + c
     *  4.15=3.44*11.97+c
     *  c=-37.03
     *  a=2^c=7.142*10^-12
     *  T(N)=7.142*10^-12N^3.44
     *
     *  Estimated time for 5000 inputs:37.87s
     *  Actual :34.017
     *  error:-10.17428%
     *
     *  34.017=a*5000^3.44
     *  a=6.42*10^-12
     *  running time therefore
     *  6.42*10^-12N^3.44
     *  which rounds to N^3
     */
    static int countCollinear(int[] a1, int[] a2, int[] a3)
    {
        int count=0;
        for(int i=0;i<a1.length;i++) {
            for (int j = 0; j < a2.length; j++) {
                for(int k=0;k<a3.length;k++){
                    if ((a1[i]*(Y2-Y3)) + (a2[j]*(Y3-Y1)) + (a3[k]*(Y1-Y2))==0){
                        count++;
                    }

                }
            }
        }
      //TODO: implement this method



      return count;
    }

    // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinearFast(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * In this implementation you should make non-trivial use of InsertionSort and Binary Search.
     * The performance of this method should be much better than that of the above method.
     *
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: N^2logN
     *
     *  Explanation: two for loops with worst case N time to complete for each loop, and uses another binary search
     *  which takes worst case logN time to complete which adds up to N^2logN
     *  also from the speed up we could see that the program speeds up in an average logN.
     *
     *
     */
    static int countCollinearFast(int[] a1, int[] a2, int[] a3)
    {
        sort(a3);
        int count=0;
        for(int i=0;i<a1.length;i++) {
            for (int j = 0; j < a2.length; j++) {
                int temp=(a1[i]*(Y2-Y3)) + (a2[j]*(Y3-Y1));

                if(binarySearch(a3,temp)){
                   count++;
                }
            }

                }
      return count;
    }

    // ----------------------------------------------------------
    /**
     * Sorts an array of integers according to InsertionSort.
     * This method is static, thus it can be called as Collinear.sort(a)
     * @param a: An UNSORTED array of integers. 
     * @return after the method returns, the array must be in ascending sorted order.
     *
     * ----------------------------------------------------------
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: N^2
     *
     *  Explanation: Two linear for-loops.
     *
     */
    static void sort(int[] a)
    {
      for ( int j = 1; j<a.length; j++)
      {
        int i = j - 1;
        while(i>=0 && a[i]>a[i+1])
        {
          int temp = a[i];
          a[i] = a[i+1];
          a[i+1] = temp;
          i--;
        }
      }
    }

    // ----------------------------------------------------------
    /**
     * Searches for an integer inside an array of integers.
     * This method is static, thus it can be called as Collinear.binarySearch(a,x)
     * @param a: A array of integers SORTED in ascending order.
     * @param x: An integer.
     * @return true if 'x' is contained in 'a'; false otherwise.
     *
     * ----------------------------------------------------------
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: logN
     *
     *  Explanation: searches half of the array each time and worst case will take logn time to find a number.
     *
     */
    static boolean binarySearch(int[] a, int x)
    {
        int lo = 0, hi = a.length-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (x < a[mid]) hi = mid - 1;
            else if (x > a[mid]) lo = mid + 1;
            else return true;
        }
      //TODO: implement this method
      return false;
    }
    public static void main(String[] args) {
        //measure performance of countCollinear
        //count collinear:
        //test with input size 1000
        int[] a1 = new In("input-files/r01000-1.txt").readAllInts();
        int[]a2=new In("input-files/r01000-2.txt").readAllInts();
        int[]a3=new In("input-files/r01000-3.txt").readAllInts();
        Stopwatch stopwatch = new Stopwatch();
        StdOut.println(Collinear.countCollinear(a1,a2,a3));
        double time = stopwatch.elapsedTime();
        StdOut.println("elapsed time for 1000 inputs for countCollinear are " + time);

        //test with input size 2000
        a1 = new In("input-files/r02000-1.txt").readAllInts();
        a2=new In("input-files/r02000-2.txt").readAllInts();
        a3=new In("input-files/r02000-3.txt").readAllInts();
        Stopwatch stopwatch1 = new Stopwatch();
        StdOut.println(Collinear.countCollinear(a1,a2,a3));
        double time1 = stopwatch1.elapsedTime();
        StdOut.println("elapsed time for 2000 inputs for countCollinear are " + time1);
        //test with input size 4000
        a1 = new In("input-files/r04000-1.txt").readAllInts();
        a2=new In("input-files/r04000-2.txt").readAllInts();
        a3=new In("input-files/r04000-3.txt").readAllInts();
        Stopwatch stopwatch2 = new Stopwatch();
        StdOut.println(Collinear.countCollinear(a1,a2,a3));
        double time2 = stopwatch2.elapsedTime();
        StdOut.println("elapsed time for 4000 inputs for countCollinear are " + time2);

        //5000:
        a1 = new In("input-files/r05000-1.txt").readAllInts();
        a2=new In("input-files/r05000-2.txt").readAllInts();
        a3=new In("input-files/r05000-3.txt").readAllInts();
        Stopwatch stopwatch3 = new Stopwatch();
        StdOut.println(Collinear.countCollinear(a1,a2,a3));
        double time3 = stopwatch3.elapsedTime();
        StdOut.println("elapsed time for 5000 inputs for countCollinear are " + time3);

        double error=(time3-PREDICTED_TIME)*100/PREDICTED_TIME;
        System.out.println("the error between estimated and actual in percentage is "+error+" %");

        //countColinearFast:
        //1000 inputs:
         a1 = new In("input-files/r01000-1.txt").readAllInts();
        a2=new In("input-files/r01000-2.txt").readAllInts();
        a3=new In("input-files/r01000-3.txt").readAllInts();
        Stopwatch stopwatch4 = new Stopwatch();
        StdOut.println(Collinear.countCollinearFast(a1,a2,a3));
        double time4 = stopwatch4.elapsedTime();
        StdOut.println("elapsed time for 1000 inputs for countCollinearFast are " + time4);
        double speedup=time/time4;
        System.out.println("speed up for 1000 input is "+speedup);

        //2000
        a1 = new In("input-files/r02000-1.txt").readAllInts();
        a2=new In("input-files/r02000-2.txt").readAllInts();
        a3=new In("input-files/r02000-3.txt").readAllInts();
        Stopwatch stopwatch5 = new Stopwatch();
        StdOut.println(Collinear.countCollinearFast(a1,a2,a3));
        double time5 = stopwatch5.elapsedTime();
        StdOut.println("elapsed time for 2000 inputs for countCollinearFast are " + time5);
        speedup=time1/time4;
        System.out.println("speed up for 2000 input is "+speedup);

        //4000
        a1 = new In("input-files/r04000-1.txt").readAllInts();
        a2=new In("input-files/r04000-2.txt").readAllInts();
        a3=new In("input-files/r04000-3.txt").readAllInts();
        Stopwatch stopwatch6 = new Stopwatch();
        StdOut.println(Collinear.countCollinearFast(a1,a2,a3));
        double time6 = stopwatch6.elapsedTime();
        StdOut.println("elapsed time for 4000 inputs for countCollinearFast are " + time6);
        speedup=time2/time6;
        System.out.println("speed up for 4000 input is "+speedup);

        //5000
        a1 = new In("input-files/r05000-1.txt").readAllInts();
        a2=new In("input-files/r05000-2.txt").readAllInts();
        a3=new In("input-files/r05000-3.txt").readAllInts();
        Stopwatch stopwatch7 = new Stopwatch();
        StdOut.println(Collinear.countCollinearFast(a1,a2,a3));
        double time7 = stopwatch7.elapsedTime();
        StdOut.println("elapsed time for 5000 inputs for countCollinearFast are " + time7);
        speedup=time3/time7;
        System.out.println("speed up for 5000 input is "+speedup);





    }







}
