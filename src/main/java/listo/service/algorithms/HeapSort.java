package listo.service.algorithms;

import java.util.List;

public class HeapSort {

    public static List<Integer> sort(List<Integer> dataset) {
        int n = dataset.size();

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(dataset, n, i);

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(dataset, 0, i);

            // Call heapify on the reduced heap
            heapify(dataset, i, 0);
        }
        return dataset;
    }

    private static void heapify(List<Integer> dataset, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && dataset.get(left) > dataset.get(largest))
            largest = left;

        if (right < n && dataset.get(right) > dataset.get(largest))
            largest = right;

        if (largest != i) {
            swap(dataset, i, largest);
            heapify(dataset, n, largest);
        }
    }

    private static void swap(List<Integer> dataset, int i, int j) {
        int temp = dataset.get(i);
        dataset.set(i, dataset.get(j));
        dataset.set(j, temp);
    }
}
