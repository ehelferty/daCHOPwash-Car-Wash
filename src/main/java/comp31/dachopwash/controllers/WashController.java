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
    
    @GetMapping("/wash")
    public String getWash(Model model) {
        model.addAttribute("wash", washService.findWashes());
        return "wash";
    }
}