package comp31.dachopwash.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import comp31.dachopwash.models.entities.Wash;
import comp31.dachopwash.services.WashService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Allows users to interact with wash information. View and book washes.
 */
@Controller
public class WashController {
    WashService washService;

    @Autowired
    public WashController(WashService washService) {
        super();
        this.washService = washService;
    }

    /**
     * Main wash info landing page.
     * Displays all washes
     * @param model
     * @return
     */
    @GetMapping("/washes")
    public String getWash(Model model) {
        model.addAttribute("wash", washService.findWashes());
        return "wash";
    }

    /**
     * Allows users to book a car wash
     * @param model
     * @return
     */
    @GetMapping("/washes/book")
    public String bookWash(Model model) {
        return "book";
    }

    /**
     * Collects form data, parses, and sends to addWash in services.
     * @param model
     * @param wash
     * @param firstName
     * @param lastName
     * @param washtype
     * @return
     */
    @GetMapping("/addWash")
    public String bookWash(Model model, @ModelAttribute Wash wash,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String washtype) {

        Integer washTypeInt;
        switch (washtype) {
            case "simple":
                washTypeInt = 0;
                break;

            case "medium":
                washTypeInt = 1;
                break;

            default:
                washTypeInt = 2;
        }

        washService.addWash(washTypeInt, firstName, lastName);

        return "index";
    }

}