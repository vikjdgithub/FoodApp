package linkedList_tut1.day1;

import java.util.Scanner;

public class Single_Creation_2 {
	
	static class  Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	Node head=null;
	
	public void Creation() {
		int data,n;
		do {
		System.out.println("Enter data");
		Scanner sc= new Scanner(System.in);
		data=sc.nextInt();
		Node new_node= new Node(data);// ek node ban gya 
		
		if (head==null) {
			head=new_node;   // head connected with node
		} else {
           // if head is not null then we have two choice 
			
	      // first is we can insert at he begining of new_node and after this new_node
		 // inserting at the begining
			new_node .next=head; // heda khali hua
			head=new_node;
			
		}
		
		System.out.println("press 1 if you want to insert more data in then list ");
		n=sc.nextInt();
		}while(n==1);
		
	}
	public void traverse() {
		Node temp=null;
		if (head==null) {
			System.out.println("linked list does not exist");
		} else {
                temp=head;
                while(temp!=null) {
                	System.out.print(temp.data +" ");
                	temp=temp.next;
                }
		}
		
	}
	public void insertionAtBegining() {
		int data,n;
		Node start=null;
		do {
		System.out.println("enter data");
		Scanner sc= new Scanner(System.in);
		 data =sc.nextInt();
	     Node new_node = new Node(data);
	     
		if (start==null) {
           start = new_node;
		} else {
            new_node.next=start;
            start=new_node;
		}
		System.out.println("press 1 if you wan tto store more data in the list");
		n=sc.nextInt();
		}while(n==1);
		traverse();
		
	}
	
	public void insertionAtEnd() {
		
	}
	public void DeleteFromBegining() {
		
		if (head==null) {
			System.out.println("linked list does no exist");
		} else {
            
            Scanner sc= new Scanner(System.in);
            System.out.println("press 1 if you wan to delete more data");
            int n=sc.nextInt();
            while(n==1) {
            Node	temp=head;
               head=temp.next;
            }
		}
		
	}
	
	public void DeleteFromEnd() {
		
	}
	
	public static void main(String[] args) {
		Single_Creation_2 ll = new Single_Creation_2();
		ll.Creation();
		ll.traverse();
		ll.DeleteFromBegining();
		
	}

}
