package org.howard.edu.lsp.assignment5.implementation;
import java.util.*;

/**
 * Class that creates the IntegerSet type which is formed utilizing ArrayList
 * Integer Sets must not have duplicates 
 * @author Esau
 * @version 1.0 Feb 28, 2022
 *
 */

public class IntegerSet{
  
   /**
 *  creates new array list with type integer to be utilized
 */
private ArrayList<Integer> list= new ArrayList<>();
  
   /**
 * @param list passed in the array list and initializes it 
 */
public IntegerSet(ArrayList<Integer> list) {
       this.list=list;
   }
  
  
  

   /**
 * clears the all representation of class
 */
public void clear() {
       list.clear();
   }
  
  
   /**
 * @return returns the length of set
 */
public int length() {
       return list.size();
   }
  
   /**
 * @param b Takes in an instance of the Integer Set class to compare with current integerset list
 * @return returns true if the 2 lists are equal
 */
public boolean equals(IntegerSet b) {
      
       ArrayList<Integer> list2=b.list;
         
       if(list.size()!=list2.size()) {
           return false;
       }
         
       ArrayList<Integer> temp1=list;
         
       ArrayList<Integer> temp2=list2;
         
       Collections.sort(temp1);
       Collections.sort(temp2);
         
       for(int i=0;i<temp1.size();i++) {
           if(temp1.get(i)!=temp2.get(i)) {
               return false;
           }
       }
         
       return true;
      
   }
  
  
  
   /** 
 * @return returns the largest item 
 * @throws ListEmptyException when the list is empty this is thrown
 */
public int largestelement() throws ListEmptyException {
      
       if(list.size()==0) {
           ListEmptyException e= new ListEmptyException("This list cannot have a size of zero");
           throw e;
       }
      
       int max=0;
      
       for(int i=0;i<list.size();i++) {
           if(list.get(i)>max) {
               max=list.get(i);
           }
       }
      
       return max;
      
   }
  
  
   /**
 * @return returns the smallest element of the list and throws exception if the list is empty
 * @throws ListEmptyException is thrown when list is empty
 */
public int smallestelement() throws ListEmptyException {
      
       if(list.size()==0) {
    	   ListEmptyException e= new ListEmptyException("This list cannot have a size of zero");
           throw e;       
           }
      
       int min=Integer.MAX_VALUE;
      
       for(int i=0;i<list.size();i++) {
           if(list.get(i)<min) {
               min=list.get(i);
           }
       }
      
       return min;
      
   }
  /**
   * 
   * @param item item int value that is used to check whether or not a set contains a certain int value
   * @return boolean value that returns false if the int value is not found and true if it is
   */
public boolean contains(int item) {
	boolean exist=false;
	for(int i=0;i<list.size();i++) {
        
        if(list.get(i)==item) {
            exist=true;
        }
    }
	return exist;
}
  
   /**
 * @param item int value that is added to the list if it is not present 
 * utilizes the contains function to see if the set already contains the elements
 */
public void addItem(int item ) {
      
       if(contains(item)==false) {
           list.add(item);
       }
      
   }
  
  
   /**
 * @param item parameter chosen that removes the item from the list if it is found in the list
 */
public void removeItem(int item ) {
      
      
      
       for(int i=0;i<list.size();i++) {
          
           if(list.get(i)==item) {
               list.remove(i);
           }
       }
      
   }


  
   /**
 * @param list2 list that is entered as the parameter for the method and is utilized to check the union of
 * @return returns the union of the two sets
 */
public IntegerSet union(IntegerSet list2) {
      
       ArrayList<Integer> temp=list2.getlist();
      
       Set<Integer> set = new HashSet<>();
       set.addAll(list);
       set.addAll(temp);
      
       ArrayList<Integer> list3= new ArrayList<>(set);
      
       IntegerSet list4= new IntegerSet(list3);
      
       return list4;
      
   }
  
   /**
 * @param list2 list that is utilized as the parameter to check the intersection of 
 * @return returns the intersection of the two sets
 */
public IntegerSet intersection(IntegerSet list2) {
	
	   ArrayList<Integer> temp1= list;
       ArrayList<Integer> temp2= list2.getlist();
      
       temp1.retainAll(temp2);
      
IntegerSet list4= new IntegerSet(temp1);
      
       return list4;
   }
  
   /**
 * @param list2  the second set/list
 * @return returns the difference of the two sets meaning the the values that overlap in each set
 * are taken out of the first set then the first set is returned 
 */
public IntegerSet difference (IntegerSet list2) {
	
       ArrayList<Integer> temp1= list;

       ArrayList<Integer> temp2=list2.getlist();
      
       temp1.removeAll(temp2);
      
IntegerSet list4= new IntegerSet(temp1);
      
       return list4;
      
   }
  /**
   * 
   * @return returns list 
   */
   public ArrayList<Integer> getlist(){
       return list;
   }
   /**We cannot simply use toString on list as the method does not work with ArrayList type
    * Instead iterate over list elements then append them to a string builder (buffer) then convert 
    * that string builder to a regular string
    * @return returns a StringBuilder instance converted to a string type via the toString method
    */
   
   public String toString() {
	   StringBuilder buffer = new StringBuilder();
	   for (Integer nextNumber : list) {
	       buffer.append(nextNumber).append(" ");
	   }
	   return buffer.toString();
   }
  
  
}