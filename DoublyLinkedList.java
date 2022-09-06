package doublyLinkedList;
import java.util.*;
import java.io.*;

/* Even Myren Nybø, HW2 
 * Part 1:
 The assignment asks us for making a Student class that holds variables
  – the name of the student, the sum of the student's grades, and the number of grades. 
* It also asks for us to create a Node class that contains 
– a previous node reference, next node reference and a Student reference as the data portion
* It also what's us to make a doubly linked list, that adds head and tail,
 remove head and tail, and also searches and finds student information in list.
* Part 2:
* The assignment asks to get a file read it and put it into a list
  the program should update a student, remove a student, print the list with all students and also print one specific student an their average.
  We should have a menu that allows user to choose what they want to do with the list.
*/

//A class that holds information as 
//student name, sum of grades and how many grades they have.
class Student{
	private String name;
	private int sum;
	private int grade;
	public Student() {
		name = null;
		sum = 0;
		grade = 0;
	}
	public Student(String n, int s, int g){ 
		name = n;
		sum = s;
		grade = g;
	}
	public void setName(String n) {
		name = n;
	}
	public void setSum(int s) {
		sum = s;
	}
	public void setGrade(int g) {
		grade = g;
	}
	public String getName() {
		return name;
	}
	public int getSum() {
		return sum;
	}
	public int getGrade() {
		return grade;
	}
	
}
/*
 A class that creates nodes that can go
 forwards(Next) and backwards(prev). 
 It also stores all data from the Student class in the node.
*/
class Node{
	private Student data;
	private Node next;
	private Node prev;
	public Node() {
		data = null;
		next = null;
		prev = null;
	}
	public Node(Student d, Node n, Node p) {  
		data = d;
		next = n;
		prev = p;
	}
	public void setData(Student d) { 
		data = d;
	} 
	public void setNext(Node n) { 
		next = n; 
	}
	public void setPrev(Node p) { 
		prev = p;
	}
	public Student getData() { 
		return data;
	}
	public Node getNext() { 
		return next;
	}
	public Node getPrev() { 
		return prev;
	}
}

class Dlist{
	private Node head;
	private Node tail;
	public Dlist() {
		head = tail = null;
	}
	// Adds a Student to the front of the list
	public void addHead(Student n) {
		Node t = new Node(n,null,null); 
		if (head == null) {
			head = tail = t; 
		}
		else {
			head.setPrev(t);
			t.setNext(head);
			head = t;
		}
	}
	
	// Adds a new node and stores Student information to the end of the list
	public void addTail(Student n) {
		Node t = new Node(n,null,null);
		if (head == null) {
			head = tail = t;  
		}
		else {
			tail.setNext(t); 
			t.setPrev(tail);
			tail = t; 
		}
	}
	// Searches for the student name is located in the linked list,
	// and returns student name, sum and grades.
	// nsg variable return the number (n), sum (s) and
	public Student FindStudent(String n) {
			
	        Node t = head;
	        boolean found = false;
	        Student nsg = null; 
	        while (!found && t != null) {
	            if ((t.getData()).getName().equals(n)) {
	                found = true;
	                nsg = t.getData();
	            }
	            t = t.getNext();
	        }
	        if(found = false) {
	        	return null;
			}
	        return nsg;
	}
	// Removes the first student from the list
	public void removeHead() {
		if (head == null) {
			return;
		}
		else if (head == tail) {
			head = tail = null;
		}
		else {
			head = head.getNext(); 
			head.setPrev(null);
		}
	}
	//Removes the last student on the list
	public void removeTail() {		
		if (head == null) {
			return;
		}
		else if (head == tail) {
			head = tail = null;
		}
		else {
			tail = tail.getPrev();
			tail.setNext(null);
		}
	}
	// removes student in between head and tail in the list
	// t is the head of the list and it search for, found is a variable that finds if the name is in the list
	// "prev" is the node before the name user wants to remove, and "next" is the node in front of student node
	public void removeStudent(String n) {
		if (head == null) {
			return;
		}
		else if (head == tail) {
			head = tail = null;
		}
		else {
	        Node t = head;
	        boolean found = false;
	        while (!found) {
	            if (t.getData().getName().equals(n)) {
	            	found = true;
	                Node prev = t.getPrev();
	                Node next = t.getNext();
	                prev.setNext(next);
	                next.setPrev(prev);
	            }
	            t = t.getNext();
	        }
		}
	}
	// Checks if student is in the spot of head and returns a boolean
	public boolean isHead(Student nsg) {
		boolean ishead = false;
		Node t = head;
		if(nsg == t.getData()) {
			ishead = true;
			return ishead;
		}
		else {
			return ishead;
		}
	}
	// Checks if student is in the spot of the tail and returns a boolean
	public boolean isTail(Student nsg) {
		boolean istail = false;
		Node t = tail;
		if(t.getData() == nsg) {
			
			istail = true;
			return istail;
		}
		else {
			return istail;
		}
	}
	//prints every student on the same line as their sum of grades and number of grades.
	public void printList() {
		if (head == null) {
			System.out.println("List is empty");
		}
		else {
			System.out.println("Student\tSum\tGrades");
			Node t = head;
			while(t != null) {
				Student n = t.getData();
				System.out.println(n.getName() + "\t" +  n.getSum() + "\t"  + n.getGrade()); 
				t = t.getNext();
			}
		}
	}
}

public class DoublyLinkedList {
	// This functions store the menu and return the value from user on what the user wants to do.
	public static int meny(Scanner scan) {
		int x;
        System.out.println("Choose one of the following options:");
        System.out.println("Enter 1 to update a student in list");
        System.out.println("Enter 2 to delete a student in the list");
        System.out.println("Enter 3 to display all student in the list");
        System.out.println("Enter 4 to display a particular student's average grade ");
        System.out.println("Enter 5 to close program");
        x = scan.nextInt();
        return x;
	}
	// This function adds new grades to the Student and returns the new average and the number of grades.
	// s = is the grades the user wants to add. NewGrades = how many new grades user wants to add.
	// nsg = name, sum and grades from the student the user wants to update. 
	public static Student updateStudent(Scanner scan, String n, Dlist d) {
		
		int s, NewGrades;
		Student nsg = d.FindStudent(n);
		
		if(nsg == null) {
			System.out.println("Student not in list, try again");
		}
		System.out.println("Student name:");
		System.out.println(nsg.getName());
		System.out.println("How many grades do you want to add?");
		NewGrades = scan.nextInt();
		if(NewGrades == 1) {
			System.out.println("Write in grade:");
			s = scan.nextInt();
			nsg.setSum(nsg.getSum() + s); //(NewGrades + 1)); 
			nsg.setGrade(nsg.getGrade() + NewGrades);
			return nsg;
		}
		else {
			for(int i = 0; i < NewGrades; i++) {
				System.out.println("Put grade:");
				s = scan.nextInt();
				nsg.setSum(nsg.getSum() + s);
			}
			nsg.setGrade(nsg.getGrade() + NewGrades);
			return nsg;
		}
	}
	// This function removes student from the list
	//removeStu = student the user wants to remove. Student is the information from the student they want remove.
	public static void removeStudent(Scanner scan, Dlist d){
		System.out.println("Who do you want to remove from the list?");
		String removeStu = scan.next();
		Student student = d.FindStudent(removeStu);
		if(student != null) {
			if(d.isHead(student) == true) {
				d.removeHead();
			}
			else if(d.isTail(student) == true) {
				d.removeTail();
			}
			else {
				if((student.getName()).equals(removeStu)) {
				d.removeStudent(removeStu);
					}
				}
			}
		else {
			System.out.println("Student not found...");
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		Scanner scan = new Scanner(System.in);
		Dlist d = new Dlist();
		int sum, grade, x;
		String name, StuName;
		System.out.println("Enter the file name of file you want to use:");
		String filename = scan.next();
		File file = new File(filename);
		if (!file.exists()) {
			System.out.println("error - file does not exist");
		}
		Scanner infile = new Scanner(file);
	    while (infile.hasNext()) {
	    	Student tempStudent = new Student();
	  		name = infile.next();
			sum = infile.nextInt();
			grade = infile.nextInt();
	  		tempStudent.setName(name);
	  		tempStudent.setSum(sum);
	  		tempStudent.setGrade(grade);
	  		d.addTail(tempStudent);
	    }
        x = meny(scan);
		while(x != 5) {
			if(x == 1) {
				System.out.println("Write name of the student you want to update:");
				StuName = scan.next();
				updateStudent(scan, StuName, d);
			}
			else if(x == 2) {
				removeStudent(scan, d);
			}
			else if(x == 3) {
				
				d.printList();
			}
			else {
				Student stu = new Student();
				System.out.println("Which student are you looking for? ");
				String findStu = scan.next();
				stu = d.FindStudent(findStu);
				if(stu != null) {
					int ave = stu.getSum()/stu.getGrade();
					System.out.println("Student" + "\t" + "Sum" + "\t" + "Grades");
					System.out.println(stu.getName() + "\t" + stu.getSum() + "\t" + stu.getGrade());
					System.out.println("Average grade is: " + ave + "\n");
				}
				else {
					System.out.println("Student not found...");
				}
			}
	        x = meny(scan);
		}
		scan.close();
		infile.close();
	}
}
