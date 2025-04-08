public class QuickSortExample {

    // Method to apply QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);  // Get partition index

            quickSort(arr, low, pi - 1);  // Sort left sub-array
            quickSort(arr, pi + 1, high); // Sort right sub-array
        }
    }

    // Partition method
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choosing the last element as pivot
        int i = low - 1;       // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot into correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return the partition index
    }

    // Main method to test QuickSort
    public static void main(String[] args) {
        int[] array = {34, 7, 23, 32, 5, 62};

        System.out.println("Before Sorting:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        quickSort(array, 0, array.length - 1);

        System.out.println("\n\nAfter Sorting:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
