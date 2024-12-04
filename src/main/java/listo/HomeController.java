package listo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    @RequestMapping("/")
    public ModelAndView getHomePage() {
        ModelAndView m = new ModelAndView();
        m.setViewName("homepage");
        return m;
    }

}
