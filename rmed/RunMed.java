// BobbyBobs -- Johnny Wong, Eddie Zhu, Qian Zhou
// APCS2 pd01
// HW50 -- Run Run Run
// 2018-05-17

/*********************************
* 1. If nextVal > root of minheap, add to max heap; else add to minHeap
* 2. Balance heaps to so the size difference <= 1
* 3. Find median by
*          - If heap sizes are equal, the median is the mean of the roots
*          - Otherwise, the median is the root of the larger heap
*********************************/

import java.util.NoSuchElementException;
import java.util.Scanner;



public class RunMed{
     // INSTANCE VARS
     private ALHeapMax lilVals;
     private ALHeapMin bigVals;

     // CONSTRUCTOR
     public RunMed(){
          lilVals = new ALHeapMax();
          bigVals = new ALHeapMin();
     }

     // METHODS

     // int getMedian()
     // returns median or throws NoSuchElementException()
     public int getMedian(){
          // check if numbers had been streamed
          if (lilVals.size() == 0 && bigVals.size() == 0){
               throw new NoSuchElementException();
          }
          // If heap sizes are equal, the median is the mean of the roots
          if (lilVals.size() == bigVals.size()){
               return (lilVals.peekMax() + bigVals.peekMin())/2;
          }
          // Otherwise, the median is the root of the larger heap
          else{
               return bigVals.peekMin();
          }
     }

     // void add(Integer newVal)
     // adds newVal to appropriate heap, balances if necessary
     public void add(Integer newVal){
          // if newVal is less than root of maxheap, add to maxheap
          if (lilVals.isEmpty() || newVal.compareTo(lilVals.peekMax()) >= 0){
               bigVals.add(newVal);
          }
          // otherwise add to minheap
          else {
               lilVals.add(newVal);
          }

          //balancing mechanism
          //lilVals size < bigVals size
          if( lilVals.size() - bigVals.size() < 2){
               for(int counter = lilVals.size() - bigVals.size(); counter < -1; counter++){
                    // remove from bigVals and add to lilVals until balanced
                    lilVals.add(bigVals.removeMin());
               }
          }
          //bigVals size < lilVals size
          else{
               for(int counter = bigVals.size() - lilVals.size(); counter > -1; counter--){
                    // remove from lilVals and add to bigVals until balanced
                    bigVals.add(lilVals.removeMax());
               }
          }
     }

     public static void main ( String[] args ){

          RunMed r = new RunMed();

          int n;
          int median;
          int count = 0;
          Scanner sc = new Scanner( System.in );

          while( sc.hasNextInt() ) {
               try {
                    n = sc.nextInt();
                    System.out.print("Streamed " + n + "\n");

                    count++;
                    System.out.print("This many ints have been seen so far: " + count + "\n");

                    r.add(n);
                    median = r.getMedian();
                    System.out.print("Median is now " + median + "\n");
               } catch (Exception e) {
                    System.err.println("BOOP! probs w yer input:\n"+e);
               }
          }
     }






}
