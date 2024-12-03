package listo.controller;

import listo.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sorting")
public class SortingController {

    @Autowired
    private SortingService sortingService;

//    @PostMapping("/{algorithm}")
//    public List<Integer> sortDataset(@PathVariable String algorithm, @RequestBody List<Integer> dataset) {
//        System.out.println("Sorting algorithm: " + algorithm);
//        //return sortingService.sort(algorithm, dataset);
//        return dataset;
//    }

    @GetMapping("/{algorithm}")
    public String sortDataset(@PathVariable String algorithm, @RequestBody String dataset) {
        System.out.println("Sorting algorithm: " + algorithm);
        System.out.println("Sorting dataset: " + dataset);
        //return sortingService.sort(algorithm, dataset);
        return algorithm;
    }

//    @GetMapping("/listo")
//    public String testName(){
//        return "Listowel";
//    }
//
//    @PostMapping("/listo/{listoVersion}")
//    public String testNamePost(@PathVariable String listoVersion, @RequestBody String name){
//        return name + listoVersion;
//    }
}
