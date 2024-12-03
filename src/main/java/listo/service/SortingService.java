package listo.service;

import listo.service.algorithms.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortingService {

    public List<Integer> sort(String algorithm, List<Integer> dataset) {
        switch (algorithm.toLowerCase()) {
            case "heapsort":
                return HeapSort.sort(dataset);
            case "quicksort":
                return QuickSort.sort(dataset);
            case "mergesort":
                return MergeSort.sort(dataset);
            case "radixsort":
                return RadixSort.sort(dataset);
            case "bucketsort":
                return BucketSort.sort(dataset);
            default:
                throw new IllegalArgumentException("Invalid sorting algorithm: " + algorithm);
        }
    }
}
