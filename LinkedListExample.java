package list;
import java.util.*;
import java.io.*;

class Node{
	private int data;
	private Node next;
	public Node(){
		data = 0;
		next = null;
	}
	public Node(int d, Node n) {
		d = data;
		n = next;
	}
	public void setData(int d) {
		data = d;
	}
	public void setNext(Node n) {
		next = n;
	}
	public int getData() {
		return data;
	}
	public Node getNext() {
		return next;
	}
}

class LinkedIst{
	private Node head;
	private Node tail;
	
	public void addTail(int x) {
		Node t = new Node(x, null);
		if (head == null) {
			head = tail = null;
		}
		else {
			tail.setNext(t);
			tail = t;
		}
	}
	public void addHead(int x) {
		Node t = new Node(x, null);
		if (head == null) {
			head = tail = null;
		}
		else {
			t.setNext(head);
			head = t;
		}
	}
	public void removeHead() {
		if( head == null) {
			head = tail = null;
		}
		else if(head == tail) {
			head = tail = null;
		}
		else {
			head = head.getNext();
		}
	}
	
	public void removeTail() {
		if (head == null) {
			return;
		}
		else if (head == tail) {
			head = tail = null;
		}
		else {
			Node t = head;
			while(t.getNext() != tail) {
				t = t.getNext();
			}
			tail = t;
			t.setNext(null);
		}
	}
	public boolean foundValue(int value) {
		
		boolean found = false;
		Node t = head;
		while (t != null && !found) {
			if(t.getData() == value) {
				found = true;
			}
			t.getNext();
		}
		return found;
	}
	
	public void change_Value(int value) {
		
		boolean found = false;
		Node t = head;
		while (t != null && !found) {
			if(t.getData() < value) {
				t.setNext(t);
				t.setData(value);
				found = true;
			}
			t.getNext();
		}
	}
	
}


public class LinkedListExample {

	public static void main(String[] args) {
		LinkedList m = new LinkedList();
		m.addHead(2);
		m.addTail(6);
		m.addHead(0);
		m.addTail(9);
		
		
		
		

	}

}
