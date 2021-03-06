package org.howard.edu.lsp.assignment5.test;
import java.util.*;
import org.howard.edu.lsp.assignment5.implementation.IntegerSet;
import org.howard.edu.lsp.assignment5.implementation.ListEmptyException;


public class Driver {

   public static void main(String[] args) throws ListEmptyException {
//dynamic arrays created 
ArrayList<Integer> list1= new ArrayList<>();
ArrayList<Integer> list2= new ArrayList<>();
  
  
// make 2 instances of IntegerSet class for implementation
IntegerSet set1= new IntegerSet(list1);
IntegerSet set2= new IntegerSet(list2);
  
set1.addItem(1);
set1.addItem(3);
set1.addItem(4);
set1.addItem(6);
set1.addItem(3);
set1.addItem(8);
set1.addItem(7);
  
set2.addItem(1);
set2.addItem(2);
set2.addItem(3);
set2.addItem(4);
set2.addItem(5);
set2.addItem(6);
set2.addItem(7);
  
System.out.println("Set 1: "+set1.getlist());
System.out.println("Set 2: "+set2.getlist());
System.out.println("String Version of Set 1: " +set1.toString());
System.out.println("String Version of Set 2: " +set2.toString() +"\n");
System.out.println("Length of Set 1: " +set1.length());
System.out.println("Length of Set 2: " +set2.length());
System.out.println("Are the sets equal (true/false)?: "+set1.equals(set2));
System.out.println("Largest element in Set1: "+set1.largestelement() +"\n");
System.out.println("Smallest element in Set2: "+set2.smallestelement());  

IntegerSet setu= set1.union(set2);
System.out.println("Union: "+setu.getlist() );

IntegerSet seti= set1.intersection(set2);
System.out.println("Intersection: "+seti.getlist() );

IntegerSet setd = set2.difference(set1);
System.out.println("Difference of (Set 2 - Set 1): "+setd.getlist()+ "\n");

System.out.println("Does Set 1 contain the number 10(true/false)?: " +set1.contains(10));
System.out.println("Does Set 2 contain the number 5(true/false)?: " +set2.contains(5)+ "\n");

System.out.println("Clearing both Set 1 and Set 2:");
set1.clear();
set2.clear();

System.out.println("Cleared Set 1: "+set1.getlist());
System.out.println("Cleared Set 2: "+set2.getlist() + "\n");

System.out.println("Doing exception handling for both smallest and largest element methods");

try
{
    set1.smallestelement();
}
catch (ListEmptyException e)
{
    System.out.println(e.getMessage());
}

try
{
    set2.largestelement();
}
catch (ListEmptyException e)
{
    System.out.println(e.getMessage() + "\n");
}

System.out.println("Adding elements 1,2,3,4 to each newly cleared set");
set1.addItem(1);
set1.addItem(2);
set1.addItem(3);
set1.addItem(4);


set2.addItem(1);
set2.addItem(2);
set2.addItem(3);
set2.addItem(4);

System.out.println("Deleting 4 from each set.");

set1.removeItem(4);
set2.removeItem(4);
System.out.println("New Set 1: "+set1.getlist());
System.out.println("New Set 2: "+set2.getlist());
System.out.println("Does Set 1 and Set 2 equal each other (true/false)?: "+set1.equals(set2));





      
   }

}