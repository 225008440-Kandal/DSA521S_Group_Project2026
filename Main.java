// Main.java - test// Main.ja// Main.java - test driver

public class Main {
    public static void main(String[] args) {

        System.out.println("===== SELECTION SORT =====");
        int[] arr = {17, 14, 11, 15, 18, 12, 10, 13, 9, 16};

        System.out.print("Before: ");
        SortingAlgorithms.printArray(arr);

        SortingAlgorithms.selectionSort(arr);

        System.out.print("After:  ");
        SortingAlgorithms.printArray(arr);

        System.out.println();
        System.out.println("===== INSERTION SORT =====");
        int[] arr2 = {17, 14, 11, 15, 18, 12, 10, 13, 9, 16};

        System.out.print("Before: ");
        SortingAlgorithms.printArray(arr2);

        SortingAlgorithms.insertionSort(arr2);

        System.out.print("After:  ");
        SortingAlgorithms.printArray(arr2);
        
        System.out.println();
        System.out.println("===== MERGE SORT =====");
        int[] arr3 = {17, 14, 11, 15, 18, 12, 10, 13, 9, 16};

        System.out.print("Before: ");
        SortingAlgorithms.printArray(arr3);

        SortingAlgorithms.mergeSort(arr3, 0, arr3.length - 1);

        System.out.print("After:  ");
        SortingAlgorithms.printArray(arr3);
    }
}