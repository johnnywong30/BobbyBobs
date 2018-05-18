//BobbyBobs -- Eddie Zhu, Joenny Wong, Qian Zhou
//APCS2 pd01
//HW50 -- Run Run Run, take a breath or two
//2018-05-17

/*********************************
 * 1. if nextVal > root of minheap, add to max heap; else add to minHeap
 * 2. balance heaps to diff<=1
 * 3. find med by taking avrg of root of minHeap and maxheap, or the root of 
 *      the larger one if applicable 
 *********************************/

import java.util.NoSuchElementException;
import java.util.Scanner;

public class RunMed{
    //inst  vars
    private ALHeapMax lilVals;
    private ALHeapMin bigVals;

    //methods:

    //constructor
    public RunMed(){
	lilVals = new ALHeapMax();
        bigVals = new ALHeapMin();
	
    }

    //getMedian(), returns median or throws NoSuchElementException

    public double getMedian(){
	if (lilVals.isEmpty()){
	    throw new NoSuchElementException();
	}
	if (lilVals.size()!=bigVals.size()){
	    return lilVals.peek();
	}
	return (lilVals.peek()+bigVals.peek())/2.0;
    }

    //add(Integer)

    public void add(Integer newVal){
	if (lilVals.isEmpty()||newVal.compareTo(lilVals.peek())<=0){lilVals.add(newVal);}
	else{ bigVals.add(newVal);}

	//balancing
	while (lilVals.size()-bigVals.size() !=1 &&
	       lilVals.size()-bigVals.size() !=0){
	    if (lilVals.size()>bigVals.size())
		bigVals.add(lilVals.remove());
	    else
		lilVals.add(bigVals.remove());
	}
	
	
    }
   public static void main( String[] args )
  {

     RunMed r = new RunMed();

    int n;
    double median;
    int count = 0;
    Scanner sc = new Scanner( System.in );

    while( sc.hasNextInt() ) {
      try {
        n = sc.nextInt();
        System.out.print("read " + n + "\n");

        count++;
        System.out.print("this many ints have been seen: " + count + "\n");

         r.add(n);
         median = r.getMedian();
         System.out.print("median is now " + median + "\n");
      } catch (Exception e) {
        System.err.println("BOOP! probs w yer input:\n"+e);
      }
    }
  }

    
}
