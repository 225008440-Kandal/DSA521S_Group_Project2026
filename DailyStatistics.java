// DailyStatistics.java
// Part A4 - Daily Statistics stored and processed in an ARRAY

public class DailyStatistics {

    int size = 100;                 // maximum number of records for the day
    int[] times = new int[size];    // service times (in minutes)
    int count = 0;                  // how many records have been added

    // ---- add one service time record ----
    public void addRecord(int time) {
        if (count == size) {
            System.out.println("Array is full!");
        } else {
            times[count] = time;
            count++;
        }
    }

    // ---- total of all service times ----
    public int total() {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum = sum + times[i];
        }
        return sum;
    }

    // ---- average service time ----
    public double average() {
        if (count == 0) return 0;
        return (double) total() / count;
    }

    // ---- highest service time ----
    public int highest() {
        int max = times[0];
        for (int i = 1; i < count; i++) {
            if (times[i] > max) max = times[i];
        }
        return max;
    }

    // ---- lowest service time ----
    public int lowest() {
        int min = times[0];
        for (int i = 1; i < count; i++) {
            if (times[i] < min) min = times[i];
        }
        return min;
    }

    // ---- count students who took 10 minutes or more ----
    public int countLongServices() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (times[i] >= 10) c++;
        }
        return c;
    }

    // ---- show the full daily report ----
    public void displayReport() {
        if (count == 0) {
            System.out.println("No records for today.");
        } else {
            System.out.println("--- Daily Statistics ---");
            System.out.println("Students served : " + count);
            System.out.println("Total minutes   : " + total());
            System.out.println("Average minutes : " + average());
            System.out.println("Longest service : " + highest());
            System.out.println("Shortest service: " + lowest());
            System.out.println("10+ min services: " + countLongServices());
            System.out.println("------------------------");
        }
    }
}