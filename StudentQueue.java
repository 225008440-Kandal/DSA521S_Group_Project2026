// StudentQueue.java
// Part A1 - Waiting Line: Queue (Static / Array implementation)
 
public class StudentQueue {
 
    int size = 6;                          // maximum number of students
    Student[] queue = new Student[size];   // the array of students
    int front = -1;
    int rear = -1;
 
    // ---- enqueue: add a student at the rear ----
    public void enqueue(Student s) {
        if (rear == size - 1) {
            System.out.println("Queue is full! Cannot add " + s.name);
        } else if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
            queue[rear] = s;
            System.out.println("Added: " + s.name);
        } else {
            rear++;
            queue[rear] = s;
            System.out.println("Added: " + s.name);
        }
    }
 
    // ---- dequeue: remove a student from the front ----
    public void dequeue() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty! No student to serve.");
        } else if (front == rear) {
            System.out.println("Serving: " + queue[front].name);
            front = -1;
            rear = -1;
        } else {
            System.out.println("Serving: " + queue[front].name);
            front++;
        }
    }
 
    // ---- peek: show the student at the front ----
    public void peek() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Next student: " + queue[front].name);
        }
    }
 
    // ---- isEmpty: check if the queue is empty ----
    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }
 
    // ---- displayQueue: show all waiting students ----
    public void displayQueue() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("--- Waiting students ---");
            for (int i = front; i <= rear; i++) {
                System.out.println(queue[i]);
            }
            System.out.println("------------------------");
        }
    }
}
