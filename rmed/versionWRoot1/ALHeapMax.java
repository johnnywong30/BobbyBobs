
/*****************************************************
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeapMax
{

  //instance vars
  private ArrayList<Integer> _heap; 

  /*****************************************************
   * default constructor  ---  inits empty heap
   *****************************************************/
  public ALHeapMax() 
  {
      _heap = new ArrayList<Integer>();
      _heap.add(null);
  }



  /*****************************************************
   * toString()  ---  overrides inherited method
   * Returns either 
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   *****************************************************/
  public String toString() 
  {
      String s="";
      int depth = 0;
      for (int i = 1; i < _heap.size();i++){
	  if(i==Math.pow(2,depth)){
	      depth++;
	      s+="\n";
	  }
	  s+=_heap.get(i)+" ";
	  
      }
      return s;
  }//O(n)


  /*****************************************************
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   *****************************************************/
  public boolean isEmpty()
  {
      return _heap.size()==1;
  }//O(1)

  public int size(){
       return _heap.size()-1;
  }

  /*****************************************************
   * Integer peekMax()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   *****************************************************/
  public Integer peek()
  {
      
      
      if (isEmpty()) return null;
      return _heap.get(1);

  }//O(1)


  /*****************************************************
   * add(Integer) 
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * Algo: add to end, swap up the tree until there's no values smaller  than it
   *****************************************************/
  public void add( Integer addVal )
  {
      _heap.add(addVal);
      for (int i = (_heap.size()-1);i>1&&_heap.get(i/2).compareTo(addVal)<0;i/=2){
	  swap(i, i/2);
      }
      
     
  
  }//O(logn)


  /*****************************************************
   * removeMax()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * Algo: find next greatest value down the same subtree and swap with the cur   * rent greatest value until we reach a leaf. Finally swap the curr greatest       * value with the last value of _heap and remove it
   *****************************************************/
  public Integer remove()
  {
      if(isEmpty()) return null;
      //rmPos and i positioning fooled me for quiet a while
      int rmPos=1;
      for(int i = childPos(1);i!=-1;i=childPos(i)){
	  swap(rmPos,i);
	  rmPos = i;//rmPos need to show curr pos of val to be removed
      }
      swap(rmPos,rmPos=_heap.size()-1);
      return _heap.remove(rmPos);
      
     
  }//O(logn)


  /*****************************************************
   * maxChildPos(int)  ---  helper fxn for removeMax()
   * Returns index of greatest child, or 
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   *****************************************************/
  private int childPos( int pos )
  {
      if (2*pos>=_heap.size()||pos<1){
	  return -1;
      }
      if (2*pos+1>=_heap.size()||_heap.get(2*pos).compareTo(_heap.get(2*pos+1))>0){
	  return 2*pos;
      }
      return 2*pos+1;
  }//O(1)
  

  //************ aux helper fxns ***************
  private Integer maxOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) > 0 )
	    return a;
    else
	    return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
  }
  //********************************************



  //main method for testing
  public static void main( String[] args )
  {
    
      ALHeapMax pile = new ALHeapMax();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);

      System.out.println("removing " + pile.remove() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.remove() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.remove() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.remove() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.remove() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.remove() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.remove() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.remove() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.remove() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.remove() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.remove() + "...");
      System.out.println(pile);
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
