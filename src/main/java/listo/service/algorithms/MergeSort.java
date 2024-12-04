package listo.service.algorithms;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static List<Integer> sort(List<Integer> dataset) {
        if (dataset.size() < 2) return dataset;

        int mid = dataset.size() / 2;
        List<Integer> left = new ArrayList<>(dataset.subList(0, mid));
        List<Integer> right = new ArrayList<>(dataset.subList(mid, dataset.size()));

        sort(left);
        sort(right);
        merge(dataset, left, right);
        return dataset;
    }

    private static void merge(List<Integer> dataset, List<Integer> left, List<Integer> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                dataset.set(k++, left.get(i++));
            } else {
                dataset.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) dataset.set(k++, left.get(i++));
        while (j < right.size()) dataset.set(k++, right.get(j++));
    }
}
