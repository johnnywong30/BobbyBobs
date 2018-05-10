//Tree -- Victor Lin, Qian Zhou
//APCS2 pd01
//HW46 -- Arrr, There Be Priorities Here Matey . . .
//2018-05-09

import java.util.ArrayList;
public class ArrayPriorityQueue implements PriorityQueue{
    private ArrayList<String> pq;
    public ArrayPriorityQueue(){
	pq=new ArrayList<String>();
    }
    public void add(String s){
	/*//first check first and last, one could also jump to binary search directly; String comparison 1Aa
	if(s.compareTo(pq.get(0))>=0)
	    pq.add(0,s);//O(n)
	else if (s.compareTo(peekMin())<=0)
	    pq.add(s);
	//binary search, O(logn)
	else{*/
	    int low = 0;
	    int high = pq.size();
	    int med = (low + high)/2;
	    while (low < high){
		if (s.compareTo(pq.get(med))==0){
		    pq.add( med,s);return;
		}
		if (s.compareTo(pq.get(med))<0){
		    low = med+1;
		}
		else{high = med-1;}
		med = (low+high)/2;
	    }
	    pq.add(low,s);//~O(n)
	    //	}
		
    }//O(nlogn)

    public boolean isEmpty(){//O(1)
	return pq.size()==0;
    }

    //if pq is empty, return null
    public String peekMin(){//O(1)
	if (isEmpty())return null;
	return pq.get(pq.size()-1);
    }
    public String removeMin(){//O(n)(remove)
	if (isEmpty())return null;
	return pq.remove(pq.size()-1);
    }
    public static void main(String[] args){
	ArrayPriorityQueue apq = new ArrayPriorityQueue();

	apq.add("aoo");
	apq.add("Aoo");
	apq.add("aooo");// A, a, ao

	System.out.println(apq.removeMin());//Aoo
	System.out.println(apq.removeMin());//aoo
	System.out.println(apq.removeMin());//aooo
	System.out.println(apq.removeMin());//null

	apq.add("goo");
	apq.add("aoo");System.out.println(apq.removeMin());//aoo
	apq.add("zoo");System.out.println(apq.removeMin());//goo
	System.out.println(apq.removeMin());//goo
	for (int i = 0; i<12; i++){
	    apq.add(i+"oo");
	}
	while (!apq.isEmpty()){
	    System.out.println(apq.removeMin());
	}
	
	
	
    }
}
