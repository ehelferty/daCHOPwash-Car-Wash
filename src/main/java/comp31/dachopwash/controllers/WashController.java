package comp31.dachopwash.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import comp31.dachopwash.services.WashService;

@Controller
public class WashController {
    WashService washService;

    @Autowired
    public WashController(WashService washService) {
        super();
        this.washService = washService;
    }
    
    @GetMapping("/washes")
    public String getWash(Model model) {
        model.addAttribute("wash", washService.findWashes());
        return "wash";
    }

    @GetMapping("/washes/book")
    public String bookWash(Model model) {
        return "book";
    }
}