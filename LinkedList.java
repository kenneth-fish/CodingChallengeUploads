import java.io.*;
import java.util.*;
	
// Java program to implement
// a Singly Linked List
public class LinkedList {
	
	Node head; // head of list
	
	// Linked list Node.
	// This inner class is made static
	// so that main() can access it
	static class Node {
	
		int data;
		Node next;
	
		// Constructor
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	// Method to insert a new node
    //much safer to use if you are trying to avoid intersection and loops
	public static LinkedList insert(LinkedList list, int data)
	{
		// Create a new node with given data
		Node new_node = new Node(data);
		new_node.next = null;
	
		// If the Linked List is empty,
		// then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		}
		else {
			// Else traverse till the last node
			// and insert the new_node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
	
			// Insert the new_node at last node
			last.next = new_node;
		}
	
		// Return the list by head
		return list;
	}
    //unsafe way to insert nodes into a linked list
    //the only way I could think of to test checking for intersections and loops
    public static LinkedList insertNode(LinkedList list, Node node)
    {
        if(list.head == null){
            list.head = node;
        }
        else{
            Node last = list.head;
            while(last.next != null){
                last = last.next;
            }
            last.next = node;
        }
        return list;
    }
    //intersects method used to check if two linkedlists contain the same node
    public static Node intersects(LinkedList list1, LinkedList list2)
    {
        if(list1.head == null || list2.head == null){
            return null; 
        }
        Node current1 = list1.head;
        Node current2 = list2.head;
        while (current1.next != null){
            while(current2.next != null){
                if(current1 == current2){
                    return current1;
                }
                current2 = current2.next;
            }
            current2 = list2.head;
            current1 = current1.next;
        }
        return null;
    }
	
	// Method to print the LinkedList.
	public static void printList(LinkedList list)
	{
		Node currNode = list.head;
	
		System.out.print("LinkedList: ");
	
		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.data + " ");
	
			// Go to next node
			currNode = currNode.next;
		}
	}
    //loopCheck method used to check if a linkedlist has a loop in it
    public static Node loopCheck(LinkedList list){
        List<Node> nodeList = new ArrayList<>();
        if(list.head == null){
            return null;
        }
        Node current = list.head;
        while(current.next != null){
            for(int i = 0; i < nodeList.size(); i++){
                if(nodeList.get(i) == current){
                    return current;
                }
            }
            nodeList.add(current);
            current = current.next;
        }
        return null;
    }
	
	// Driver code
	public static void main(String[] args)
	{
		/* Start with the empty list. */
		LinkedList list = new LinkedList();
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        LinkedList secondList = new LinkedList();
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        LinkedList twistedList = new LinkedList();
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);
        
	
		//
		// ******INSERTION******
		//
	
		// Insert the values
		list = insertNode(list, one);
		list = insertNode(list, two);
		list = insertNode(list, three);
		list = insertNode(list, four);

		secondList = insertNode(secondList, five);
		secondList = insertNode(secondList, three);
		secondList = insertNode(secondList, six);
		secondList = insertNode(secondList, seven);

        Node result = intersects(list, secondList);
        if(result != null){
            System.out.println("Node with data " + result.data + " is in both lists.");
        }else{
            System.out.println("None of the nodes intersect.");
        }

        twistedList = insertNode(twistedList, eight);
        twistedList = insertNode(twistedList, nine);
        twistedList = insertNode(twistedList, ten);
        twistedList = insertNode(twistedList, nine);

        Node loopResult = loopCheck(twistedList);
        if(result != null){
             System.out.println("Node with data " + loopResult.data + " is causing a loop.");
        }else{
             System.out.println("There is no spoon (I mean loop)");
        }

	
        
		// Print the LinkedList
		//printList(list);
	}
}
