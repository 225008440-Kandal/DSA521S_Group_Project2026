// Student.java
// This class represents one student arriving at the service centre.
// It is the basic "record" used by the Queue, Linked List and Array.

public class Student {

    // ---- The 4 pieces of information for each student ----
    int studentNo;              // e.g. 221045678
    String name;               // e.g. "Maria"
    String serviceType;        // e.g. "Registration"
    int serviceTime;           // estimated service time in minutes, e.g. 12

    // ---- Constructor: builds a new student with the 4 values ----
    public Student(int studentNo, String name, String serviceType, int serviceTime) {
        this.studentNo = studentNo;
        this.name = name;
        this.serviceType = serviceType;
        this.serviceTime = serviceTime;
    }

    // ---- A helper to print the student nicely ----
    public String toString() {
        return studentNo + " | " + name + " | " + serviceType + " | " + serviceTime + " min";
    }
}