// SortingAlgorithms.java
// Part B - Sorting Algorithms (Selection, Insertion, Merge, Quick)
/*
 * ============================================================
 *  COMPARISON OF SORTING ALGORITHMS (Part B)
 * ============================================================
 *
 *  Algorithm       | Best case  | Average    | Worst case | Method              | Stable?
 *  --------------- | ---------- | ---------- | ---------- | ------------------- | -------
 *  Selection Sort  | O(n^2)     | O(n^2)     | O(n^2)     | Selection + swap    | No
 *  Insertion Sort  | O(n)       | O(n^2)     | O(n^2)     | Insertion + shift   | Yes
 *  Merge Sort      | O(n log n) | O(n log n) | O(n log n) | Divide and conquer  | Yes
 *  Quick Sort      | O(n log n) | O(n log n) | O(n^2)     | Divide (pivot)      | No
 *
 *  Notes:
 *  - Selection & Insertion sort are simple but slow (O(n^2)) for large data.
 *  - Insertion sort is best when the array is nearly sorted (best case O(n)).
 *  - Merge sort is the most reliable: O(n log n) in ALL cases, but uses extra memory.
 *  - Quick sort is usually fast (O(n log n)) but degrades to O(n^2) with a bad pivot.
 * ============================================================
 */

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
    // ===== 2. INSERTION SORT =====
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];              // the element to insert
            int j = i - 1;
            // shift larger elements to the right
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;             // place key in its correct spot
        }
    }
        // ===== 3. MERGE SORT =====
    public static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;        // find the middle
            mergeSort(a, left, mid);             // sort the left half
            mergeSort(a, mid + 1, right);        // sort the right half
            merge(a, left, mid, right);          // merge the two halves
        }
    }

    // helper: merge two sorted halves back together
    public static void merge(int[] a, int left, int mid, int right) {
        int n1 = mid - left + 1;                 // size of left half
        int n2 = right - mid;                    // size of right half

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) leftArr[i] = a[left + i];
        for (int j = 0; j < n2; j++) rightArr[j] = a[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                a[k] = leftArr[i];
                i++;
            } else {
                a[k] = rightArr[j];
                j++;
            }
            k++;
        }
        // copy any leftovers
        while (i < n1) { a[k] = leftArr[i]; i++; k++; }
        while (j < n2) { a[k] = rightArr[j]; j++; k++; }
    }
        // ===== 4. QUICK SORT =====
    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(a, low, high);   // place pivot correctly
            quickSort(a, low, pivotIndex - 1);          // sort left of pivot
            quickSort(a, pivotIndex + 1, high);         // sort right of pivot
        }
    }

    // helper: partition around the last element as pivot
    public static int partition(int[] a, int low, int high) {
        int pivot = a[high];      // choose the last element as pivot
        int i = low - 1;          // index of smaller element

        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                // swap a[i] and a[j]
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        // put the pivot in its correct place
        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;             // return the pivot's final position
    }
}
