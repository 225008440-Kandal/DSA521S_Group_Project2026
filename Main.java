// Main.java
// Part D - Integrated System: menu that connects all the parts

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // create one object of each structure
        StudentQueue queue = new StudentQueue();
        StudentLinkedList records = new StudentLinkedList();
        PostfixStack calculator = new PostfixStack();
        DailyStatistics stats = new DailyStatistics();

        int choice;

        do {
            // ---- show the menu ----
            System.out.println();
            System.out.println("===== CAMPUS SERVICE CENTRE =====");
            System.out.println("1. Add student to waiting queue (enqueue)");
            System.out.println("2. Serve next student (dequeue)");
            System.out.println("3. Show waiting queue");
            System.out.println("4. Add a student record (linked list)");
            System.out.println("5. Show all student records");
            System.out.println("6. Evaluate a postfix expression");
            System.out.println("7. Add a daily service time");
            System.out.println("8. Show daily statistics");
            System.out.println("9. Run sorting experiment");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            if (choice == 1) {
                System.out.print("Student number: ");
                int no = input.nextInt();
                input.nextLine();                      // clear the line
                System.out.print("Name: ");
                String name = input.nextLine();
                System.out.print("Service type: ");
                String service = input.nextLine();
                System.out.print("Service time (minutes): ");
                int time = input.nextInt();
                queue.enqueue(new Student(no, name, service, time));

            } else if (choice == 2) {
                queue.dequeue();

            } else if (choice == 3) {
                queue.displayQueue();

            } else if (choice == 4) {
                System.out.print("Student number: ");
                int no = input.nextInt();
                input.nextLine();
                System.out.print("Name: ");
                String name = input.nextLine();
                System.out.print("Service type: ");
                String service = input.nextLine();
                System.out.print("Service time (minutes): ");
                int time = input.nextInt();
                records.insertAtEnd(new Student(no, name, service, time));

            } else if (choice == 5) {
                records.display();

            } else if (choice == 6) {
                input.nextLine();
                System.out.print("Enter postfix expression (e.g. 5 3 + 8 *): ");
                String expr = input.nextLine();
                int result = calculator.evaluatePostfix(expr);
                System.out.println("Result = " + result);

            } else if (choice == 7) {
                System.out.print("Service time (minutes): ");
                int time = input.nextInt();
                stats.addRecord(time);
                System.out.println("Record added.");

            } else if (choice == 8) {
                stats.displayReport();

            } else if (choice == 9) {
                Experiment.runExperiment();

            } else if (choice == 0) {
                System.out.println("Goodbye!");

            } else {
                System.out.println("Invalid choice, try again.");
            }

        } while (choice != 0);

        input.close();
    }
}