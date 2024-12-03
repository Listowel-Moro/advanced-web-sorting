package listo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    // GET Request Example
    @GetMapping("/hello")
    public String doGet() {
        return "Hello there, world";
    }

    @RequestMapping("/")
    public ModelAndView getHomePage() {
        ModelAndView m = new ModelAndView();
        m.setViewName("welcome");
        return m;
    }

    // POST Request Example
    @PostMapping("/submit")
    public String doPost(@RequestBody String data) {
        // Here, `data` is the request body sent by the client
        return "Received data: " + data;
    }

    // Another GET Request with a Path Variable
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
}
