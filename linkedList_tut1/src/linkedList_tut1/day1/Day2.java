package linkedList_tut1.day1;

import java.util.Scanner;

public class Day2 {
	
	
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	Node head;
	

	public static void main(String[] args) {
		Day2 ll = new Day2();
		ll.creation();
		ll.traverse();
	}
	public void creation() {
		int data,n;
		Node temp;
		do {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter data");
		data=sc.nextInt();
		Node new_node = new Node(data);
		if (head==null) {
			head=new_node;
		} else {
			// insertion at the begining
//             new_node.next=head;
//             head=new_node;
           // insertion at the end
             temp=head;
             while(temp!=null) {
            	 temp.next=new_node;
            	 
             }
             temp.next=new_node;
			
		}
		System.out.println("press 1 if you want to store more data");
		n=sc.nextInt();
		}
		
		while(n==1);
	}
	
	public void traverse() {
		Node temp;
		if (head==null) {
			System.out.println("linked list does not exist");
		} else {
			
               temp=head;
               while(temp!=null) {
            	   System.out.print(temp.data +",");
            	   temp=temp.next;
               }
		}
		
	}
	
	public void deletion() {
		
	}
}
