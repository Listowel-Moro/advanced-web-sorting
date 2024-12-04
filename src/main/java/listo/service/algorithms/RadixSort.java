package listo.service.algorithms;

import java.util.List;

public class RadixSort {
    public static List<Integer> sort(List<Integer> dataset) {
        if (dataset == null || dataset.isEmpty()) return dataset;

        // Find the maximum value to determine the number of digits
        int max = dataset.stream().max(Integer::compareTo).orElse(0);
        int exp = 1; // Exponent representing the digit place (1, 10, 100, ...)

        while (max / exp > 0) {
            // Perform counting sort for each digit place
            countingSort(dataset, exp);
            exp *= 10;
        }
        return dataset;
    }

    private static void countingSort(List<Integer> dataset, int exp) {
        int n = dataset.size();
        int[] output = new int[n]; // To store sorted values
        int[] count = new int[10]; // Digit range is 0-9

        // Count occurrences of each digit
        for (int num : dataset) {
            int digit = (num / exp) % 10;
            count[digit]++;
        }

        // Change count[i] so it contains the position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array by placing numbers in sorted order
        for (int i = n - 1; i >= 0; i--) {
            int num = dataset.get(i);
            int digit = (num / exp) % 10;
            output[count[digit] - 1] = num;
            count[digit]--;
        }

        // Copy the sorted values back into the original dataset
        for (int i = 0; i < n; i++) {
            dataset.set(i, output[i]);
        }
    }
}
