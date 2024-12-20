package listo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/api")
    public String apiOverview() {
        return "Welcome to the RESTful API following HATEOAS principles.";
    }
}
