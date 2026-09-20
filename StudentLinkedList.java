// StudentLinkedList.java
// Part A2 - Student Records: Singly Linked List (Dynamic implementation)
 
public class StudentLinkedList {
 
    // ---- A node holds one Student and a link to the next node ----
    class Node {
        Student data;
        Node next;
 
        Node(Student s) {
            this.data = s;
            this.next = null;
        }
    }
 
    Node head = null;   // points to the first node (null = empty list)
 
    // ---- insertAtEnd: add a student record at the end ----
    public void insertAtEnd(Student s) {
        Node newNode = new Node(s);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Record added: " + s.name);
    }
 
    // ---- insertAtBeginning: add a student record at the start ----
    public void insertAtBeginning(Student s) {
        Node newNode = new Node(s);
        newNode.next = head;
        head = newNode;
        System.out.println("Record added at start: " + s.name);
    }
 
    // ---- search: find a record by student number ----
    public void search(int studentNo) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.data.studentNo == studentNo) {
                System.out.println("Found: " + temp.data);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Student " + studentNo + " not found.");
        }
    }
 
    // ---- deleteAtBeginning: remove the first record ----
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
        } else {
            System.out.println("Removed: " + head.data.name);
            head = head.next;
        }
    }
 
    // ---- display: show all student records ----
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
        } else {
            System.out.println("--- Student records ---");
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
            System.out.println("-----------------------");
        }
    }
}
