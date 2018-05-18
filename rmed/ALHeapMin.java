//BobbyBobs -- Johnny Wong, Eddie Zhu, Qian Zhou
//APCS2 pd01
//HW50 -- Run Run Run
//2018-05-17


import java.util.ArrayList;

public class ALHeapMin
{

  //instance vars
  private ArrayList<Integer> _heap; 

  /*****************************************************
   * default constructor  ---  inits empty heap
   *****************************************************/
  public ALHeapMin() 
  {
      _heap = new ArrayList<Integer>();
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
      int levelLimit = 0;
      for (int i = 0; i < _heap.size();i++){
	  if(i>levelLimit){
	      levelLimit=(1+levelLimit)*2;
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
      return _heap.size()==0;
  }//O(1)


  /*****************************************************
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   *****************************************************/
  public Integer peekMin()
  {
      
      
      if (isEmpty()) return null;
      return _heap.get(0);

  }//O(1)


  /*****************************************************
   * add(Integer) 
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * Algo: reiging champion through _heap with the initial champion as addVal,
   * and once defeated set the winner's index to champ and continue with champ 
   * as new winner. At last add reigning champion to the end
   *****************************************************/
  public void add( Integer addVal )
  {
      
      Integer champ = addVal;
      for (int i=0;i<_heap.size();i++){
	  if (_heap.get(i).compareTo(champ)>0){
	      champ =_heap.set(i,champ);
	  }
      }
      _heap.add(champ);
     
  
  }//O(n)


  /*****************************************************
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * Algo: find next smallest value down the same subtree and swap with the cur 
   * rent smallest value until we reach a leaf. Finally swap the curr smallest 
   * value with the last value of _heap and remove it
   *****************************************************/
  public Integer removeMin()
  {
      if(isEmpty()) return null;
      //rmPos and i positioning fooled me for quiet a while
      int rmPos=0;
      for(int i = minChildPos(0);i!=-1;i=minChildPos(i)){
	  swap(rmPos,i);
	  rmPos = i;//rmPos need to show curr pos of val to be removed
      }
      swap(rmPos,rmPos=_heap.size()-1);
      return _heap.remove(rmPos);
      
     
  }//O(logn)


  /*****************************************************
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or 
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   *****************************************************/
  private int minChildPos( int pos )
  {
      if (2*pos+1>=_heap.size()||pos<0){
	  return -1;
      }
      if (2*pos+2>=_heap.size()||_heap.get(2*pos+1).compareTo(_heap.get(2*pos+2))<0){
	  return 2*pos+1;
      }
      return 2*pos+2;
  }//O(1)
  

  //************ aux helper fxns ***************
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
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
    
 
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
