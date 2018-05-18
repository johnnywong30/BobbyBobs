//BobbyBobs -- Johnny Wong, Eddie Zhu, Qian Zhou
//APCS2 pd01
//HW50 -- Run Run Run
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

    private ALHeapMax lilVals; 
    private ALHeapMin bigVals; 

    public RunMed(){
	lilVals = new ALHeapMax();
	bigVals = new ALHeapMin();
    }

    public int getMedian(){
	if(lilVals.size() == bigVals.size()){
	    return (lilVals.peekMax() + bigVals.peekMin())/2;
		}
	else{try{
		return bigVals.peekMin();}
	    catch(Exception e){
		throw new NullPointerException();}
	}
    }




    public void add(Integer newVal){
	if (lilVals.isEmpty()||newVal.compareTo(lilVals.peekMax())>=0){
	    bigVals.add(newVal);
	}
	else {
	    lilVals.add(newVal);
	}
	//balancing portion
	if( lilVals.size() - bigVals.size() < 2){//lilVals size < bigVals size
	    for(int counter = lilVals.size() - bigVals.size(); counter < -1; counter++){
		int temp = bigVals.peekMin();
		bigVals.removeMin();
		lilVals.add(temp);
	    }
	}
	else{//big Vals smaller 
	    for(int counter = bigVals.size() - lilVals.size(); counter > -1; counter--){
		int temp = lilVals.peekMax();
		lilVals.removeMax();
		bigVals.add(temp);
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
