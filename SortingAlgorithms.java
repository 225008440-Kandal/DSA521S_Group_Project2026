// SortingAlgorithms.java
// Part B - Sorting Algorithms (Selection, Insertion, Merge, Quick)

public class SortingAlgorithms {

    // ---- Helper: print an array ----
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // ===== 1. SELECTION SORT =====
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;                       // assume the first is smallest
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;                   // found a smaller one
                }
            }
            // swap a[i] and a[minIndex]
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }
}