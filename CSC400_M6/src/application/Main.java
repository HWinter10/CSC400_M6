package application;

import java.util.Iterator;

public class Main {
		//Main
		public static void main(String[] args) {
	        CustomLinkedList linkedList = new CustomLinkedList();
	        
	        // Read integers from file & add to linked list
	        System.out.println("Reading from file..");
	        System.out.println("--Adding elements to list--");
	        linkedList.readFromFile("numbers.txt");
	
	        // Inserting elements
	        System.out.println("All list elements:");
	        linkedList.insert(1);
	        linkedList.insert(2);
	        linkedList.insert(3);
	        linkedList.insert(4);
	        
	        // Deleting elements
	        linkedList.delete(1);
	        linkedList.delete(4);
	        linkedList.delete(6);
	
	        // Iterate & display elements
	        Iterator<Integer> iterator = linkedList.iterator();
	        while (iterator.hasNext()) {
	            System.out.print(iterator.next() + " ");
	        }
		}    
}
	  
