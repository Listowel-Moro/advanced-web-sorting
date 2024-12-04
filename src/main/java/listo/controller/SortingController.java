package listo.controller;

import listo.service.SortingService;
import listo.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sorting")
public class SortingController {

    @Autowired
    private SortingService sortingService;

    private List<Integer> dataset = new ArrayList<>();

    public SortingController(){
        dataset.add(34);
        dataset.add(3);
        dataset.add(56);
        dataset.add(18);
    }

    private List<Link> generateLinks() {
        List<Link> links = new ArrayList<>();
        links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SortingController.class).sortDataset("heapsort"))
                .withRel("heapSort"));
        links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SortingController.class).sortDataset("quicksort"))
                .withRel("quickSort"));
        links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SortingController.class).sortDataset("mergesort"))
                .withRel("mergeSort"));
        links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SortingController.class).sortDataset("bucketsort"))
                .withRel("bucketSort"));
        links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SortingController.class).sortDataset("radixsort"))
                .withRel("radixSort"));
        links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SortingController.class).changeInputData(null))
                .withRel("changeInput"));
        links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SortingController.class).updateElement(0, 0))
                .withRel("updateElement"));
        links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SortingController.class).removeElement(0))
                .withRel("removeElement"));
        links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SortingController.class).deleteData())
                .withRel("deleteData"));
        return links;
    }

    @PostMapping("/{algorithm}")
    public EntityModel<ApiResponse<List<Integer>>> sortDataset(@PathVariable String algorithm) {
        try {
            List<Integer> sortedData = sortingService.sort(algorithm, dataset);
            ApiResponse<List<Integer>> apiResponse = new ApiResponse<>(200, "Sorting successful!", sortedData, generateLinks());
            return EntityModel.of(apiResponse);
        } catch (IllegalArgumentException e) {
            ApiResponse<List<Integer>> errorResponse = new ApiResponse<>(400, e.getMessage(), null, generateLinks());
            return EntityModel.of(errorResponse);
        } catch (Exception e) {
            ApiResponse<List<Integer>> errorResponse = new ApiResponse<>(500, "An unexpected error occurred", null, generateLinks());
            return EntityModel.of(errorResponse);
        }
    }

    @PostMapping("/change-input")
    public EntityModel<ApiResponse<List<Integer>>> changeInputData(@RequestBody List<Integer> newInput) {
        dataset = newInput;
        ApiResponse<List<Integer>> apiResponse = new ApiResponse<>(200, "Input successfully changed", dataset, generateLinks());
        return EntityModel.of(apiResponse);
    }

    @PostMapping("/update-element/{index}")
    public EntityModel<ApiResponse<List<Integer>>> updateElement(@PathVariable int index, @RequestBody int element) {
        dataset.set(index, element);
        ApiResponse<List<Integer>> apiResponse = new ApiResponse<>(200, "Element successfully updated", dataset, generateLinks());
        return EntityModel.of(apiResponse);
    }

    @PostMapping("/remove-element/{index}")
    public EntityModel<ApiResponse<List<Integer>>> removeElement(@PathVariable int index) {
        dataset.remove(index);
        ApiResponse<List<Integer>> apiResponse = new ApiResponse<>(200, "Element successfully removed", dataset, generateLinks());
        return EntityModel.of(apiResponse);
    }

    @PostMapping("/delete-data")
    public EntityModel<ApiResponse<List<Integer>>> deleteData() {
        dataset.clear();
        ApiResponse<List<Integer>> apiResponse = new ApiResponse<>(200, "Dataset successfully cleared", dataset, generateLinks());
        return EntityModel.of(apiResponse);
    }

    @GetMapping("/current-dataset")
    public EntityModel<ApiResponse<List<Integer>>> fetchDataset() {
        ApiResponse<List<Integer>> apiResponse = new ApiResponse<>(200, "Dataset successfully cleared", dataset, generateLinks());
        return EntityModel.of(apiResponse);
    }
}
