//Taaseen Ali & Eddie Zhu
//APCS2 pd1
//HW46 -- Arrr, There Be Priorities Here Matey
//2018-05-09

import java.util.*;

public class ArrayPriorityQueue{
    private List<String> _ar = new ArrayList<String>();
    public void add(String s){
	_ar.add(s);
    }
    public String peekMin(){
	if(_ar.size() > 0){
	    String min = _ar.get(0);
	    for(String item:_ar){
		if(min.compareTo(item)>0){
		    min = item;
		}
	    }
	    return min;
	}
	return null;
    }

    public String removeMin(){
	if(_ar.size() > 0){
	String min = _ar.get(0);
	int k=0;
	for(int i=1; i<_ar.size(); i++){
	    if(min.compareTo(_ar.get(i))>0){
		min = _ar.get(i);
		k=i;
	    }
	}
	_ar.remove(k);
	return min;
	}
	return null;
    }
    public String toString(){ return _ar.toString();}
    
    public static void main(String argsp[]){
	ArrayPriorityQueue mrMyk = new ArrayPriorityQueue();
	mrMyk.add("foo");
	mrMyk.add("goo");
	mrMyk.add("aoo");
	mrMyk.add("loo");	
	mrMyk.add("fbo");

	System.out.println(mrMyk);
	System.out.println("Peeking...");
	System.out.println(mrMyk.peekMin());
	System.out.println("Dequeueing...");

	System.out.println(mrMyk.removeMin());
	System.out.println(mrMyk.removeMin());
	System.out.println(mrMyk.removeMin());
	System.out.println(mrMyk.removeMin());
	System.out.println(mrMyk.removeMin());
	System.out.println(mrMyk.removeMin());

	
    }
    

}
