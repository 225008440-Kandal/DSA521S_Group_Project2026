// Experiment.java
// Part C - Algorithm Experiment: compare sorting algorithms by counting comparisons

import java.util.Random;

public class Experiment {

    // counter for the number of comparisons in the current run
    static long comparisons;

    // ---- Selection Sort (counts comparisons) ----
    public static void selectionSort(int[] a) {
        comparisons = 0;
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                comparisons++;
                if (a[j] < a[min]) min = j;
            }
            int t = a[min]; a[min] = a[i]; a[i] = t;
        }
    }

    // ---- Insertion Sort (counts comparisons) ----
    public static void insertionSort(int[] a) {
        comparisons = 0;
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                comparisons++;
                a[j + 1] = a[j];
                j--;
            }
            if (j >= 0) comparisons++;   // the comparison that stopped the loop
            a[j + 1] = key;
        }
    }

    // ---- helper: make a random array of the given size ----
    public static int[] randomArray(int size) {
        Random rand = new Random();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) a[i] = rand.nextInt(1000);
        return a;
    }

    // ---- run the experiment for all sizes ----
    public static void runExperiment() {
        int[] sizes = {20, 50, 100, 500};

        System.out.println("Size | Selection (comparisons) | Insertion (comparisons)");
        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < sizes.length; i++) {
            int n = sizes[i];

            // use the SAME data for both sorts so the comparison is fair
            int[] base = randomArray(n);

            int[] copy1 = base.clone();
            selectionSort(copy1);
            long selCount = comparisons;

            int[] copy2 = base.clone();
            insertionSort(copy2);
            long insCount = comparisons;

            System.out.println(n + "   |        " + selCount + "           |        " + insCount);
        }
    }
}