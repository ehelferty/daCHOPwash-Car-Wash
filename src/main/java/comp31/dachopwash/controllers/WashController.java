package comp31.dachopwash.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;

import comp31.dachopwash.models.entities.Wash;
import comp31.dachopwash.services.WashService;

@Controller
public class WashController {

    @Autowired WashService washService;

    @GetMapping("/washes/book")
    public String bookWash(@ModelAttribute Wash wash, Model model)
    {

        return "book";
    } 
    
}