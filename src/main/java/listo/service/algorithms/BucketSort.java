package listo.service.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static List<Integer> sort(List<Integer> dataset) {
        if (dataset == null || dataset.isEmpty()) return dataset;

        // Find the maximum value to determine the number of buckets
        int max = Collections.max(dataset);
        int bucketCount = dataset.size();

        // Create empty buckets
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute dataset into buckets
        for (int num : dataset) {
            int bucketIndex = (num * bucketCount) / (max + 1);
            buckets.get(bucketIndex).add(num);
        }

        // Sort each bucket and collect the sorted elements
        dataset.clear();
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket); // You can use any sorting algorithm here
            dataset.addAll(bucket);
        }
        return dataset;
    }
}
