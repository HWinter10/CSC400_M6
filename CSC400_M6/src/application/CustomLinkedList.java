package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CustomLinkedList {
    private Node head;
    
    // Method - Insert new node @ end of list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) { // if list empty
            head = newNode; // new node becomes head
        } else {
            Node current = head; // if list not empty
            while (current.next != null) { // traverse to end of list 
                current = current.next;
            }
            current.next = newNode; // set next reference of last node
        }							// to the new node at end of list
    }
    
    // Method - Delete first occurence of node 
    public void delete(int data) { // remove first node of specif. data
    	if (head == null) { //if list empty, exit method
    		return;
    	}
    	// If node is head
    	if (head.data == data) { // if head contains data, update head
    		head = head.next;	 // to next node & remove first node
    		return;
    	}
    	// Traverse to find first occurence of node, just before deletion
    	Node current = head; 
    	while (current.next != null && current.next.data != data) {
    		current = current.next;
    	}
    	// If found, delete node
    	if (current.next != null) {
    		current.next = current.next.next; 
    	}	// if node found, make next mode current node
    }  
    
    // Method - Read integer from file
    public void readFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNext()) { // loop thru each element in file
                if (scanner.hasNextInt()) { 
                    int data = scanner.nextInt();
                    insert(data);
                } else {
                    scanner.next(); // skip non-integer input
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File '" + filename + "' not found.");
        }
    }
    
    // Method - Return interator for linked list
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    // Node inner class in linked list
    private class Node {
        int data;
        Node next;
        // initialize new node with given data
        Node(int data) { 
            this.data = data;
            this.next = null;
        }
    }

    // LinkedList inner class - iterates through linked list
    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int data = current.data;
            current = current.next;
            return data;
        }
    }
}

