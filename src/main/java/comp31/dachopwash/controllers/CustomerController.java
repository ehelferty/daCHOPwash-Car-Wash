package comp31.dachopwash.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comp31.dachopwash.models.entities.Customer;
import comp31.dachopwash.services.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        super();
        this.customerService = customerService;
    }

    @GetMapping("")
    public String getCustomers(Model model, @ModelAttribute Customer newCustomer,
                                @RequestParam(required=false) String customerFirstName,
                                @RequestParam(required=false) String customerLastName)
    {
        boolean invalidName = 
            customerFirstName == null || customerFirstName.isEmpty() ||
            customerLastName == null || customerLastName.isEmpty();

        if(invalidName){
            model.addAttribute("customers", customerService.findCustomers());
        }
        else{
            customerService.createCustomer(newCustomer.getCustomerFirstName(), newCustomer.getCustomerLastName());                          
            model.addAttribute("customer", new Customer());
            model.addAttribute("customers", customerService.findCustomers());
        }
        
        return "customers";
    }  
}
