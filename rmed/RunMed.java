//BobbyBobs -- Johnny Wong, Eddie Zhu, Qian Zhou
//APCS2 pd01
//HW50 -- Run Run Run
//2018-05-17

public class RunMed{

    private ALHeapMin lilVals; 
    private ALHeapMax bigVals; 

    public RunMed{
	lilVals = new ALHeapMin();
	bigVals = new ALHeapMax();
    }

    public int getMedian{
	if(lilVals.size() == bigVals.size()){
	    return (double)((double)lilVals.peekMin() + (double)bigVals.peekMax())/2
		}
	else{
	    return bigVals.peekMax();
	}
    }




    public void add(Integer newVal){

	//balancing portion
	if( lilVals.size() - bigVals.size() < 2){
	    for(int counter = lilVals.size() - bigVals.size(); counter > 0; counter--){
		int temp = bigVals.peekMax();
		bigVals.removeMax();
		lilVals.add(temp);
	    }
	}
	else{
	    for(int counter = bigVals.size() - lilVals.size(); counter > 0; counter--){
		int temp = lilVals.peekMin();
		lilVals.removeMin();
		bigVals.add(temp);
	    }
	}
	    
		
	  
    }
    
    public static void main ( String[] args ){

	System.out.println("test");
    }





    
}
