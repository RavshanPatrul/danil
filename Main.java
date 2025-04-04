import java.util.Arrays;

class SortingAlgorithms {

    // Пузырьковая сортировка
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Быстрая сортировка
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low + 1;
        int right = high;
        while (true) {
            while (left <= right && arr[left] <= pivot) left++;
            while (right >= left && arr[right] >= pivot) right--;
            if (right < left) break;
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        int temp = arr[low];
        arr[low] = arr[right];
        arr[right] = temp;
        return right;
    }

    // Измерение времени сортировки
    public static void measureSortTime(int[] arr, String sortMethod) {
        int[] copy = arr.clone(); // Создаем копию массива для каждого алгоритма
        long startTime = System.nanoTime();

        if (sortMethod.equals("bubble")) {
            bubbleSort(copy);
        } else if (sortMethod.equals("quick")) {
            quickSort(copy, 0, copy.length - 1);
        }

        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        System.out.println(sortMethod + " sort took: " + timeTaken + " nanoseconds");
    }

    public static void main(String[] args) {
        // Небольшой массив
        int[] smallArray = {5, 2, 8, 1, 4};
        System.out.println("Small array:");
        System.out.println("Before sorting: " + Arrays.toString(smallArray));

        int[] bubbleCopy = smallArray.clone();
        bubbleSort(bubbleCopy);
        System.out.println("After bubble sort: " + Arrays.toString(bubbleCopy));

        int[] quickCopy = smallArray.clone();
        quickSort(quickCopy, 0, quickCopy.length - 1);
        System.out.println("After quick sort: " + Arrays.toString(quickCopy));

        measureSortTime(smallArray, "bubble");
        measureSortTime(smallArray, "quick");

        // Крупный массив
        int[] largeArray = new int[10000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = (int) (Math.random() * 10000); // Заполняем случайными числами
        }
        System.out.println("\nLarge array:");
        measureSortTime(largeArray, "bubble");
        measureSortTime(largeArray, "quick");
    }
}
