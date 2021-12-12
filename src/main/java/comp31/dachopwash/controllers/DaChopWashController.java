package comp31.dachopwash.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DaChopWashController {
    @GetMapping("/")
    public String getStarted()
    {
        return "index";
    }
}
