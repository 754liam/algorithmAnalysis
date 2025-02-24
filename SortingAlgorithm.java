package sortingAlgorithms;
import java.util.Random;
import java.util.Arrays;
public class SortingAlgorithm {
    static int bubbleCount = 0;
    static int insertionCount = 0;
    static int mergeCount = 0;
    static int quickCount = 0;
    public static void main(String[] args) {
    	//Create orignal array
        Random rand = new Random();
        int size = 20;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100);
        }
        //Instantiate 4 different arrays to be used as parameters for the different sorting algorithms
        int[] arrBubble = Arrays.copyOf(arr, size);
        int[] arrInsertion = Arrays.copyOf(arr, size);
        int[] arrMerge = Arrays.copyOf(arr, size);
        int[] arrQuick = Arrays.copyOf(arr, size);
        bubbleSort(arrBubble);
        insertionSort(arrInsertion);
        mergeSort(arrMerge);
        quickSort(arrQuick);
        //Print how many exchanges were made
        System.out.println("Bubble exchanges: " + bubbleCount);
        System.out.println("Insertion exchanges: " + insertionCount);
        System.out.println("Merge exchanges: " + mergeCount);
        System.out.println("Quick exchanges: " + quickCount);
    }
    //Bubble sort method... uses the original array as a a parameter and returns the amount of exchanges made.
    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    bubbleCount++;
                    needNextPass = true;
                }
            }
        }
    }
  //Insertion sort method... uses the original array as a a parameter and returns the amount of exchanges made.
    public static int[] insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k + 1] = list[k];
                insertionCount++;
            }
            if (k + 1 != i) {
                list[k + 1] = currentElement;
                insertionCount++;
            }
        }
        return list;
    }
  //Merge sort methods... uses the original array as a a parameter and returns the amount of exchanges made.
    public static int[] mergeSort(int[] list) {
        if (list.length > 1) {
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);
            merge(firstHalf, secondHalf, list);
        }
        return list;
    }
    //Merge method, uses as a helper method for the mergeSort - merges the split arrays
    public static int[] merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;
        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
            mergeCount++;
        }
        while (current1 < list1.length) {
            temp[current3++] = list1[current1++];
            mergeCount++;
        }
        while (current2 < list2.length) {
            temp[current3++] = list2[current2++];
            mergeCount++;
        }
        return temp;
    }
    //Quick sort methods... uses the original array as a a parameter and returns the amount of exchanges made.
    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }
    private static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }
    private static int partition(int[] list, int first, int last) {
        int pivot = list[first];
        int low = first + 1;
        int high = last;
        while (high > low) {
            while (low <= high && list[low] <= pivot)
                low++;
            while (low <= high && list[high] > pivot)
                high--;
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
                quickCount++;
            }
        }
        while (high > first && list[high] >= pivot)
            high--;
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            quickCount++;
            return high;
        }
        else {
            return first;
        }
    }
}
