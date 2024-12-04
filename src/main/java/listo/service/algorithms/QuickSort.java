package listo.service.algorithms;

import java.util.List;

public class QuickSort {
    public static List<Integer> sort(List<Integer> dataset) {
        quickSort(dataset, 0, dataset.size() - 1);
        return dataset;
    }

    private static void quickSort(List<Integer> dataset, int low, int high) {
        if (low < high) {
            int pi = partition(dataset, low, high);
            quickSort(dataset, low, pi - 1);
            quickSort(dataset, pi + 1, high);
        }
    }

    private static int partition(List<Integer> dataset, int low, int high) {
        int pivot = dataset.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (dataset.get(j) <= pivot) {
                i++;
                swap(dataset, i, j);
            }
        }
        swap(dataset, i + 1, high);
        return i + 1;
    }

    private static void swap(List<Integer> dataset, int i, int j) {
        int temp = dataset.get(i);
        dataset.set(i, dataset.get(j));
        dataset.set(j, temp);
    }
}
